package net.uniego.aida.lobecorp.entity.ordeal;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.entity.LobeCorpEntity;
import net.uniego.aida.lobecorp.init.EntityInit;

import java.util.function.Predicate;

//考验实体
public abstract class OrdealEntity extends LobeCorpEntity {
    public static final Predicate<LivingEntity> GREEN_ATTACK_TARGET_PREDICATE;//绿色考验攻击目标

    static {
        GREEN_ATTACK_TARGET_PREDICATE = entity -> {
            EntityType<?> entityType = entity.getType();
            return !(entityType == EntityType.ARMOR_STAND
                    || entityType == EntityInit.DOUBT_ENTITY);
        };
    }

    protected OrdealEntity(EntityType<? extends HostileEntity> entityType, World world, LobeCorpUtil.EGOLevel egoLevel,
                           float redResist, float whiteResist, float blackResist, float paleResist) {
        super(entityType, world, egoLevel, redResist, whiteResist, blackResist, paleResist);
    }

    @Override
    protected void updatePostDeath() {
        //零点之时再丢弃
        if (getWorld().getTimeOfDay() % 24000 == 0 && !getWorld().isClient && !isRemoved()) {
            getWorld().sendEntityStatus(this, (byte) 60);
            discard();
        }
    }
}
