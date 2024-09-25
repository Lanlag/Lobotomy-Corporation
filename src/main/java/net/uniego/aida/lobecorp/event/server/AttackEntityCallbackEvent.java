package net.uniego.aida.lobecorp.event.server;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.dragon.EnderDragonPart;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.init.DamageInit;
import net.uniego.aida.lobecorp.init.TagInit;
import org.jetbrains.annotations.Nullable;

//攻击实体事件
public class AttackEntityCallbackEvent implements AttackEntityCallback {
    //EGO武器攻击逻辑，让玩家能够暴击以及EGO武器接收附魔加成
    public static void egoAttack(Entity target, PlayerEntity player, RegistryKey<DamageType> egoDamageType) {
        if (target.isAttackable()) {
            if (!target.handleAttack(player)) {
                float f = (float) player.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                float g = EnchantmentHelper.getAttackDamage(player.getMainHandStack(), target.getType());
                float h = player.getAttackCooldownProgress(0.5F);
                f *= 0.2F + h * h * 0.8F;
                g *= h;
                player.resetLastAttackedTicks();

                if (f > 0.0F || g > 0.0F) {
                    boolean bl = h > 0.9F;
                    int i = 0;
                    i += EnchantmentHelper.getKnockback(player);
                    if (player.isSprinting() && bl) {
                        player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, player.getSoundCategory(), 1.0F, 1.0F);
                        ++i;
                    }

                    f += player.getStackInHand(Hand.MAIN_HAND).getItem().getBonusAttackDamage(player, f);
                    boolean bl3 = bl && player.fallDistance > 0.0F && !player.isOnGround() && !player.isClimbing() && !player.isTouchingWater() && !player.hasStatusEffect(StatusEffects.BLINDNESS) && !player.hasVehicle() && target instanceof LivingEntity && !player.isSprinting();
                    if (bl3) {
                        f *= 1.5F;
                    }

                    f += g;
                    float j = 0.0F;
                    boolean bl5 = false;
                    int k = EnchantmentHelper.getFireAspect(player);
                    if (target instanceof LivingEntity) {
                        j = ((LivingEntity) target).getHealth();
                        if (k > 0 && !target.isOnFire()) {
                            bl5 = true;
                            target.setOnFireFor(1);
                        }
                    }

                    Vec3d vec3d = target.getVelocity();
                    boolean bl6 = target.damage(player.getDamageSources().create(egoDamageType, player), f);
                    if (bl6) {
                        if (i > 0) {
                            if (target instanceof LivingEntity) {
                                ((LivingEntity) target).takeKnockback((float) i * 0.5F, MathHelper.sin(player.getYaw() * 0.017453292F), -MathHelper.cos(player.getYaw() * 0.017453292F));
                            } else {
                                target.addVelocity(-MathHelper.sin(player.getYaw() * 0.017453292F) * (float) i * 0.5F, 0.1, MathHelper.cos(player.getYaw() * 0.017453292F) * (float) i * 0.5F);
                            }

                            player.setVelocity(player.getVelocity().multiply(0.6, 1.0, 0.6));
                            player.setSprinting(false);
                        }

                        if (target instanceof ServerPlayerEntity && target.velocityModified) {
                            ((ServerPlayerEntity) target).networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(target));
                            target.velocityModified = false;
                            target.setVelocity(vec3d);
                        }

                        if (bl3) {
                            player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, player.getSoundCategory(), 1.0F, 1.0F);
                            player.addCritParticles(target);
                        }

                        if (!bl3) {
                            if (bl) {
                                player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, player.getSoundCategory(), 1.0F, 1.0F);
                            } else {
                                player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_WEAK, player.getSoundCategory(), 1.0F, 1.0F);
                            }
                        }

                        if (g > 0.0F) {
                            player.addEnchantedHitParticles(target);
                        }

                        player.onAttacking(target);
                        if (target instanceof LivingEntity) {
                            EnchantmentHelper.onUserDamaged((LivingEntity) target, player);
                        }

                        EnchantmentHelper.onTargetDamaged(player, target);
                        ItemStack itemStack2 = player.getMainHandStack();
                        Entity entity = target;
                        if (target instanceof EnderDragonPart) {
                            entity = ((EnderDragonPart) target).owner;
                        }

                        if (!player.getWorld().isClient && !itemStack2.isEmpty() && entity instanceof LivingEntity) {
                            itemStack2.postHit((LivingEntity) entity, player);
                            if (itemStack2.isEmpty()) {
                                player.setStackInHand(Hand.MAIN_HAND, ItemStack.EMPTY);
                            }
                        }

                        if (target instanceof LivingEntity) {
                            float m = j - ((LivingEntity) target).getHealth();
                            player.increaseStat(Stats.DAMAGE_DEALT, Math.round(m * 10.0F));
                            if (k > 0) {
                                target.setOnFireFor(k * 4);
                            }

                            if (player.getWorld() instanceof ServerWorld && m > 2.0F) {
                                int n = (int) ((double) m * 0.5);
                                ((ServerWorld) player.getWorld()).spawnParticles(ParticleTypes.DAMAGE_INDICATOR, target.getX(), target.getBodyY(0.5), target.getZ(), n, 0.1, 0.0, 0.1, 0.2);
                            }
                        }

                        player.addExhaustion(0.1F);
                    } else {
                        player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_NODAMAGE, player.getSoundCategory(), 1.0F, 1.0F);
                        if (bl5) {
                            target.extinguish();
                        }
                    }
                }
            }
        }
    }

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        ItemStack stackInHand = player.getStackInHand(Hand.MAIN_HAND);
        if (stackInHand.isIn(TagInit.RED_EGO_WEAPONS)) {
            egoAttack(entity, player, DamageInit.RED);
            return ActionResult.SUCCESS;
        } else if (stackInHand.isIn(TagInit.WHITE_EGO_WEAPONS)) {
            egoAttack(entity, player, DamageInit.WHITE);
            return ActionResult.SUCCESS;
        } else if (stackInHand.isIn(TagInit.BLACK_EGO_WEAPONS)) {
            egoAttack(entity, player, DamageInit.BLACK);
            return ActionResult.SUCCESS;
        } else if (stackInHand.isIn(TagInit.PALE_EGO_WEAPONS)) {
            egoAttack(entity, player, DamageInit.PALE);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }
}
