package net.uniego.aida.lobecorp.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ColorResistAccess;
import net.uniego.aida.lobecorp.access.EGOLevelAccess;

//脑叶公司实体
public abstract class LobeCorpEntity extends HostileEntity implements ColorResistAccess, EGOLevelAccess {
    private final LobeCorpUtil.EGOLevel egoLevel;
    private final float redResist;
    private final float whiteResist;
    private final float blackResist;
    private final float paleResist;

    protected LobeCorpEntity(EntityType<? extends HostileEntity> entityType, World world, LobeCorpUtil.EGOLevel egoLevel,
                             float redResist, float whiteResist, float blackResist, float paleResist) {
        super(entityType, world);
        this.egoLevel = egoLevel;
        this.redResist = redResist;
        this.whiteResist = whiteResist;
        this.blackResist = blackResist;
        this.paleResist = paleResist;
    }

    public static boolean tryColorAttack(LobeCorpEntity lobecorpEntity, Entity target, RegistryKey<DamageType> egoDamageType) {
        float f = (float) lobecorpEntity.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        float g = (float) lobecorpEntity.getAttributeValue(EntityAttributes.GENERIC_ATTACK_KNOCKBACK);
        boolean bl = target.damage(lobecorpEntity.getDamageSources().create(egoDamageType, lobecorpEntity), f);
        if (bl) {
            if (g > 0.0F && target instanceof LivingEntity) {
                ((LivingEntity) target).takeKnockback(g * 0.5F,
                        MathHelper.sin(lobecorpEntity.getYaw() * 0.017453292F),
                        -MathHelper.cos(lobecorpEntity.getYaw() * 0.017453292F));
                lobecorpEntity.setVelocity(lobecorpEntity.getVelocity().multiply(0.6, 1.0, 0.6));
            }
            lobecorpEntity.applyDamageEffects(lobecorpEntity, target);
            lobecorpEntity.onAttacking(target);
        }
        return bl;
    }

    @Override
    public float getRedResist() {
        return redResist;
    }

    @Override
    public float getWhiteResist() {
        return whiteResist;
    }

    @Override
    public float getBlackResist() {
        return blackResist;
    }

    @Override
    public float getPaleResist() {
        return paleResist;
    }

    @Override
    public LobeCorpUtil.EGOLevel getEGOLevel() {
        return egoLevel;
    }

    @Override
    public boolean isPersistent() {
        return true;
    }
}
