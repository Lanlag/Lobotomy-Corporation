package net.uniego.aida.lobecorp.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ColorResistAccess;
import net.uniego.aida.lobecorp.access.EGOLevelAccess;

//脑叶公司实体
public class LobeCorpEntity extends HostileEntity implements ColorResistAccess, EGOLevelAccess {
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
}
