package net.uniego.aida.lobecorp.manager;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.init.DamageInit;
import net.uniego.aida.lobecorp.init.SoundInit;

//干渴机制
public class ThirstManager {
    public boolean hasDrankStream = false;//判断玩家是否喝了水流
    public int drankStreamTickTimer;//水流计时器
    public boolean hasDrankRain = false;//判断玩家是否已经喝了雨水
    public int drankRainTickTimer;//雨水计时器
    public boolean hasDrankCauldron = false;//判断玩家是否喝了坩埚
    public int drankCauldronTickTimer;//坩埚计时器
    private int waterLevel = 20;//干渴值
    private float hydrationLevel = 5.0F;//饱水度
    private float desiccation;//脱水度
    private int waterTickTimer;//水计时器

    public ThirstManager() {
    }

    //增加干渴值和饱水度
    public void add(int water, float hydrationModifier) {
        waterLevel = Math.min(water + waterLevel, 20);
        hydrationLevel = Math.min(hydrationLevel + (float) water * hydrationModifier * 2.0F, (float) waterLevel);
    }

    //更新干渴机制
    public void update(PlayerEntity player) {
        Difficulty difficulty = player.getWorld().getDifficulty();
        if (desiccation > 4.0F) {
            desiccation -= 4.0F;
            if (hydrationLevel > 0.0F) {
                hydrationLevel = Math.max(hydrationLevel - 1.0F, 0.0F);
            } else if (difficulty != Difficulty.PEACEFUL) {
                waterLevel = Math.max(waterLevel - 1, 0);
            }
        }

        boolean bl = player.getWorld().getGameRules().getBoolean(GameRules.NATURAL_REGENERATION);
        SanityManager sanityManager = ((ManagerAccess) player).lobecorp$getSanityManager();
        if (bl && hydrationLevel > 0.0F && sanityManager.canWaterCure() && waterLevel >= 20) {
            ++waterTickTimer;
            if (waterTickTimer >= 10) {
                float f = Math.min(hydrationLevel, 6.0F);
                sanityManager.cure(f / 6.0F);
                addDesiccation(f);
                waterTickTimer = 0;
            }
        } else if (bl && waterLevel >= 18 && sanityManager.canWaterCure()) {
            ++waterTickTimer;
            if (waterTickTimer >= 80) {
                sanityManager.cure(1.0F);
                addDesiccation(6.0F);
                waterTickTimer = 0;
            }
        } else if (waterLevel <= 0) {
            ++waterTickTimer;
            if (waterTickTimer >= 80) {
                if (player.getHealth() > 10.0F
                        || difficulty == Difficulty.HARD
                        || player.getHealth() > 1.0F && difficulty == Difficulty.NORMAL) {
                    player.damage(player.getDamageSources().create(DamageInit.DRY), 1.0F);
                }
                waterTickTimer = 0;
            }
        } else {
            waterTickTimer = 0;
        }
        //喝水状态冷却时间及声音播放
        if (hasDrankStream) {
            ++drankStreamTickTimer;
            if (drankStreamTickTimer >= 20) {
                LobeCorpUtil.playSound(player, SoundInit.SWALLOW_WATER);
                drankStreamTickTimer = 0;
                hasDrankStream = false;
            }
        } else if (hasDrankRain) {
            ++drankRainTickTimer;
            if (drankRainTickTimer >= 40) {
                LobeCorpUtil.playSound(player, SoundInit.SWALLOW_WATER);
                drankRainTickTimer = 0;
                hasDrankRain = false;
            }
        } else if (hasDrankCauldron) {
            ++drankCauldronTickTimer;
            if (drankCauldronTickTimer >= 20) {
                LobeCorpUtil.playSound(player, SoundInit.SWALLOW_WATER);
                drankCauldronTickTimer = 0;
                hasDrankCauldron = false;
            }
        }
    }

    public void readNbt(NbtCompound nbt) {
        if (nbt.contains("waterLevel", 99)) {
            waterLevel = nbt.getInt("waterLevel");
            waterTickTimer = nbt.getInt("waterTickTimer");
            hydrationLevel = nbt.getFloat("waterHydrationLevel");
            desiccation = nbt.getFloat("waterDesiccationLevel");
        }
    }

    public void writeNbt(NbtCompound nbt) {
        nbt.putInt("waterLevel", waterLevel);
        nbt.putInt("waterTickTimer", waterTickTimer);
        nbt.putFloat("waterHydrationLevel", hydrationLevel);
        nbt.putFloat("waterDesiccationLevel", desiccation);
    }

    //判断玩家是否喝水
    public boolean isNotDrink() {
        return !hasDrankStream && !hasDrankRain && !hasDrankCauldron;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public boolean isNotFull() {
        return waterLevel < 20;
    }

    public void addDesiccation(float desiccation) {
        this.desiccation = Math.min(this.desiccation + desiccation, 40.0F);
    }

    public float getDesiccation() {
        return desiccation;
    }

    public void setDesiccation(float desiccation) {
        this.desiccation = desiccation;
    }

    public float getHydrationLevel() {
        return hydrationLevel;
    }

    public void setHydrationLevel(float hydrationLevel) {
        this.hydrationLevel = hydrationLevel;
    }
}
