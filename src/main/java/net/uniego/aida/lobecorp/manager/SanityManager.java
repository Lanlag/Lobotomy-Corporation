package net.uniego.aida.lobecorp.manager;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;
import net.uniego.aida.lobecorp.init.AttributeInit;

//精神机制
public class SanityManager {
    private final PlayerEntity player;
    private float sanity = 20.0F;
    private float assimilationAmount = 0.0F;
    private boolean isCrazy = false;
    private int sanityTickTimer;

    public SanityManager(PlayerEntity player) {
        this.player = player;
    }

    public void cure(float amount) {
        float f = getSanity();
        if (f > 0.0F) {
            setSanity(f + amount);
        }
    }

    //能否通过干渴值回复精神值
    public boolean canWaterCure() {
        return getSanity() > 0.0F && getSanity() < getMaxSanity() && !isCrazy();
    }

    //判断是否正常
    public boolean isNormal() {
        return !player.isRemoved() && !isCrazy() && getSanity() > 0.0F;
    }

    //判断是否恐慌
    public boolean isCrazy() {
        isCrazy = getSanity() <= 0.0F || (isCrazy && getSanity() < getMaxSanity());
        return isCrazy;
    }

    //恐慌状态（暂定空白）
    public void panicState() {
        if (!player.getAbilities().invulnerable) {
            if (isCrazy()) {
                ++sanityTickTimer;
            } else {
                sanityTickTimer = 0;
            }
        }
    }

    public void readNbt(NbtCompound nbt) {
        if (nbt.contains("Sanity", 99)) {
            setSanity(nbt.getFloat("Sanity"));
            setAssimilationAmountUnclamped(nbt.getFloat("AssimilationAmount"));
        }
    }

    public void writeNbt(NbtCompound nbt) {
        nbt.putFloat("Sanity", getSanity());
        nbt.putFloat("AssimilationAmount", getAssimilationAmount());
    }

    public float getSanity() {
        return sanity;
    }

    public void setSanity(float sanity) {
        this.sanity = MathHelper.clamp(sanity, 0.0F, getMaxSanity());
    }

    public float getMaxSanity() {
        return (float) player.getAttributeValue(AttributeInit.PLAYER_MAX_SANITY);
    }

    public float getMaxAssimilation() {
        return (float) player.getAttributeValue(AttributeInit.PLAYER_MAX_ASSIMILATION);
    }

    public float getAssimilationAmount() {
        return assimilationAmount;
    }

    public void setAssimilationAmount(float assimilationAmount) {
        setAssimilationAmountUnclamped(MathHelper.clamp(assimilationAmount, 0.0F, getMaxAssimilation()));
    }

    public void setAssimilationAmountUnclamped(float assimilationAmount) {
        this.assimilationAmount = assimilationAmount;
    }
}
