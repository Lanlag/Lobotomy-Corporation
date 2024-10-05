package net.uniego.aida.lobecorp.entity.abnormality;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.entity.LobeCorpEntity;
import net.uniego.aida.lobecorp.init.AttributeInit;
import net.uniego.aida.lobecorp.init.ParticleInit;
import net.uniego.aida.lobecorp.network.packet.OpenWorkPacket;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//异想体实体
public abstract class AbnormalityEntity extends LobeCorpEntity {
    //工作方式
    public static final String INSTINCT = "Instinct";//本能工作
    public static final String INSIGHT = "Insight";//洞察工作
    public static final String ATTACHMENT = "Attachment";//沟通工作
    public static final String REPRESSION = "Repression";//压迫工作
    //工作结果
    public static final String GOOD = "good";
    public static final String NORMAL = "normal";
    public static final String BAD = "bad";
    //数据追踪
    private static final TrackedData<Integer> PE_BOX = DataTracker.registerData(AbnormalityEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> NE_BOX = DataTracker.registerData(AbnormalityEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> LAST_PE_BOX = DataTracker.registerData(AbnormalityEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> LAST_NE_BOX = DataTracker.registerData(AbnormalityEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<String> LAST_WORK_METHOD = DataTracker.registerData(AbnormalityEntity.class, TrackedDataHandlerRegistry.STRING);
    private static final TrackedData<Integer> LAST_WORK_LEVEL = DataTracker.registerData(AbnormalityEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<String> LAST_WORK_RESULT = DataTracker.registerData(AbnormalityEntity.class, TrackedDataHandlerRegistry.STRING);
    private static final TrackedData<Boolean> IS_WORKING = DataTracker.registerData(AbnormalityEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> IS_COOLING = DataTracker.registerData(AbnormalityEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> IS_ESCAPING = DataTracker.registerData(AbnormalityEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public final int eBox;//最大BOX产量
    protected final Map<String, Map<Integer, Float>> workProbabilities;//工作概率容器
    //固定参数
    private final String number;
    private final float baseWorkSpeed;//基础工作速度
    private final int maxQliphothCounter;//逆卡巴拉计数器极值
    private final int cooldownTime;//冷却时间
    private final RegistryKey<DamageType> damageTypeRegistryKey;
    private final int goodMoodMin;
    private final int goodMoodMax;
    private final int normalMoodMin;
    private final int normalMoodMax;
    private final int badMoodMin;
    private final int badMoodMax;
    private final Map<LobeCorpUtil.EGOLevel, Map<Integer, Float>> levelOutputValues;//等级输出值容器
    public float probability;//工作概率
    public float extraProbability;//额外工作概率
    public int workLevel;//工作等级
    public String workResult;//工作结果
    public int workDurationTime;//工作持续时间
    public boolean isApplied;//是否属性加成
    //流程参数
    public ServerPlayerEntity interactPlayer;//交互玩家
    public ServerPlayerEntity workPlayer;//工作玩家
    public String workMethod;//工作方式
    public int uBox;//独立E-BOX
    protected int qliphothCounter;//逆卡巴拉计数器
    private ServerPlayerEntity lastWorkPlayer;//上一个工作玩家
    private int workTickTimer;//工作计时器
    private int coolTickTimer;//冷却计时器
    private float levelOutputValue;//等级输出值
    private float temporaryStatusOutputValue;//暂时状态输出值
    private float finalStatusOutputValue;//最终状态输出值
    private Vec3d spawnPos;//出生位置
    private boolean isSpawned;//是否出生成功
    private int deadTickTimer;//死亡计时器
    private boolean isRespawned;//是否重生成功

    protected AbnormalityEntity(EntityType<? extends HostileEntity> entityType, World world, LobeCorpUtil.EGOLevel egoLevel,
                                String number, int eBox, int cooldownTime, float baseWorkSpeed, RegistryKey<DamageType> damageTypeRegistryKey,
                                int goodMoodMin, int goodMoodMax, int normalMoodMin, int normalMoodMax, int badMoodMin, int badMoodMax) {
        super(entityType, world, egoLevel, 0.0F, 0.0F, 0.0F, 0.0F);
        this.number = number;
        this.eBox = eBox;
        this.maxQliphothCounter = -1;
        this.qliphothCounter = -1;
        this.cooldownTime = cooldownTime;
        this.baseWorkSpeed = baseWorkSpeed;
        this.damageTypeRegistryKey = damageTypeRegistryKey;
        this.goodMoodMin = goodMoodMin;
        this.goodMoodMax = goodMoodMax;
        this.normalMoodMin = normalMoodMin;
        this.normalMoodMax = normalMoodMax;
        this.badMoodMin = badMoodMin;
        this.badMoodMax = badMoodMax;
        workProbabilities = new HashMap<>();
        setWorkProbabilities();
        levelOutputValues = new HashMap<>();
        setLevelOutputValues();
    }

    protected AbnormalityEntity(EntityType<? extends HostileEntity> entityType, World world, LobeCorpUtil.EGOLevel egoLevel,
                                float redResist, float whiteResist, float blackResist, float paleResist, String number,
                                int eBox, int maxQliphothCounter, int cooldownTime, float baseWorkSpeed, RegistryKey<DamageType> damageTypeRegistryKey,
                                int goodMoodMin, int goodMoodMax, int normalMoodMin, int normalMoodMax, int badMoodMin, int badMoodMax) {
        super(entityType, world, egoLevel, redResist, whiteResist, blackResist, paleResist);
        this.number = number;
        this.eBox = eBox;
        this.maxQliphothCounter = maxQliphothCounter;
        this.qliphothCounter = maxQliphothCounter;
        this.cooldownTime = cooldownTime;
        this.baseWorkSpeed = baseWorkSpeed;
        this.damageTypeRegistryKey = damageTypeRegistryKey;
        this.goodMoodMin = goodMoodMin;
        this.goodMoodMax = goodMoodMax;
        this.normalMoodMin = normalMoodMin;
        this.normalMoodMax = normalMoodMax;
        this.badMoodMin = badMoodMin;
        this.badMoodMax = badMoodMax;
        workProbabilities = new HashMap<>();
        setWorkProbabilities();
        levelOutputValues = new HashMap<>();
        setLevelOutputValues();
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(PE_BOX, 0);
        builder.add(NE_BOX, 0);
        builder.add(LAST_PE_BOX, 0);
        builder.add(LAST_NE_BOX, 0);
        builder.add(LAST_WORK_METHOD, "");
        builder.add(LAST_WORK_LEVEL, 0);
        builder.add(LAST_WORK_RESULT, "");
        builder.add(IS_WORKING, false);
        builder.add(IS_COOLING, false);
        builder.add(IS_ESCAPING, false);
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (player.getWorld().isClient) {
            if (((ManagerAccess) player).lobecorp$getSanityManager().isNormal()) {
                OpenWorkPacket.send(getUuid());
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.FAIL;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return super.isInvulnerableTo(damageSource) || !isEscaping() && !(damageSource.isOf(DamageTypes.GENERIC_KILL)
                || damageSource.isOf(DamageTypes.OUT_OF_WORLD) || damageSource.isOf(DamageTypes.OUTSIDE_BORDER));
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        //异想体死亡时，应当立刻强制关闭正在与其交互的玩家屏幕
        if (interactPlayer != null) {
            interactPlayer.closeHandledScreen();
        } else if (workPlayer != null) {
            workPlayer.closeHandledScreen();
        }
    }

    @Override
    protected void updatePostDeath() {
        deadTickTimer++;
        if (deadTickTimer >= 100) {
            super.updatePostDeath();
            if (!isRespawned && getType().create(getWorld()) instanceof AbnormalityEntity abnormality) {
                abnormality.setPos(spawnPos.getX(), spawnPos.getY() + 0.1F, spawnPos.getZ());
                abnormality.setUBox(uBox);
                if (!getWorld().isClient) {
                    getWorld().spawnEntity(abnormality);
                    isRespawned = true;
                }
            }
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        uBox = nbt.getInt("uBox");
        double posX = nbt.getDouble("spawnPosX");
        double posY = nbt.getDouble("spawnPosY");
        double posZ = nbt.getDouble("spawnPosZ");
        spawnPos = new Vec3d(posX, posY, posZ);
        isSpawned = nbt.getBoolean("isSpawned");
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("uBox", uBox);
        nbt.putDouble("spawnPosX", spawnPos.getX());
        nbt.putDouble("spawnPosY", spawnPos.getY());
        nbt.putDouble("spawnPosZ", spawnPos.getZ());
        nbt.putBoolean("isSpawned", isSpawned);
    }

    @Override
    public void tick() {
        super.tick();
        if (!isSpawned) {
            spawnPos = getPos();
            isSpawned = true;
        }
        work();
        if (!getWorld().isClient) {
            manage();
            escape();
        }
    }

    private void work() {
        //工作时间
        if (isWorking()) {
            workTickTimer++;
            if (workPlayer != null) {
                if (workTickTimer >= 20 && (getPeBox() + getNeBox() >= eBox)) {
                    workPlayer.closeHandledScreen();
                    //属性加成
                    if (getLastWorkPlayer() != null && !getWorld().isClient) {
                        if (getLastPeBox() + getLastNeBox() == eBox && !isApplied) {
                            int attributeBonus = Math.round(getLastPeBox() * getLevelOutputValue() * getStatusOutputValue());
                            if (Objects.equals(getLastWorkMethod(), INSTINCT)) {
                                double maxHealth = Objects.requireNonNull(getLastWorkPlayer().getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).getBaseValue();
                                Objects.requireNonNull(getLastWorkPlayer().getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(maxHealth + attributeBonus);
                                isApplied = true;
                            } else if (Objects.equals(getLastWorkMethod(), INSIGHT)) {
                                double maxSanity = Objects.requireNonNull(getLastWorkPlayer().getAttributeInstance(AttributeInit.PLAYER_MAX_SANITY)).getBaseValue();
                                Objects.requireNonNull(getLastWorkPlayer().getAttributeInstance(AttributeInit.PLAYER_MAX_SANITY)).setBaseValue(maxSanity + attributeBonus);
                                isApplied = true;
                            } else if (Objects.equals(getLastWorkMethod(), ATTACHMENT)) {
                                double workSuccess = Objects.requireNonNull(getLastWorkPlayer().getAttributeInstance(AttributeInit.PLAYER_WORK_SUCCESS)).getBaseValue();
                                double workVelocity = Objects.requireNonNull(getLastWorkPlayer().getAttributeInstance(AttributeInit.PLAYER_WORK_VELOCITY)).getBaseValue();
                                Objects.requireNonNull(getLastWorkPlayer().getAttributeInstance(AttributeInit.PLAYER_WORK_SUCCESS)).setBaseValue(workSuccess + attributeBonus);
                                Objects.requireNonNull(getLastWorkPlayer().getAttributeInstance(AttributeInit.PLAYER_WORK_VELOCITY)).setBaseValue(workVelocity + attributeBonus);
                                isApplied = true;
                            } else if (Objects.equals(getLastWorkMethod(), REPRESSION)) {
                                double attackVelocity = Objects.requireNonNull(getLastWorkPlayer().getAttributeInstance(AttributeInit.PLAYER_ATTACK_VELOCITY)).getBaseValue();
                                double moveVelocity = Objects.requireNonNull(getLastWorkPlayer().getAttributeInstance(AttributeInit.PLAYER_MOVE_VELOCITY)).getBaseValue();
                                Objects.requireNonNull(getLastWorkPlayer().getAttributeInstance(AttributeInit.PLAYER_ATTACK_VELOCITY)).setBaseValue(attackVelocity + attributeBonus);
                                Objects.requireNonNull(getLastWorkPlayer().getAttributeInstance(AttributeInit.PLAYER_MOVE_VELOCITY)).setBaseValue(moveVelocity + attributeBonus);
                                isApplied = true;
                            }
                        }
                    }
                } else if (workTickTimer >= workDurationTime && (getPeBox() + getNeBox()) < eBox) {
                    workTickTimer = 0;
                    if (getWorld().random.nextFloat() < getProbability()) {
                        setPeBox(getPeBox() + 1);
                    } else {
                        workPlayer.damage(LobeCorpUtil.noKnockBackDamageSource(damageTypeRegistryKey, this), (float) getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
                        setNeBox(getNeBox() + 1);
                    }
                }
            }
        }
        //冷却时间
        if (isCooling()) {
            coolTickTimer++;
            switch (getLastWorkResult()) {
                case GOOD -> spawnWorkResultParticle(ParticleInit.GOOD);
                case NORMAL -> spawnWorkResultParticle(ParticleInit.NORMAL);
                case BAD -> spawnWorkResultParticle(ParticleInit.BAD);
            }
            if (coolTickTimer >= cooldownTime) {
                coolTickTimer = 0;
                setCooling(false);
            }
        }
    }

    //管理须知
    protected abstract void manage();

    //出逃行为
    protected abstract void escape();

    public int getPeBox() {
        return dataTracker.get(PE_BOX);
    }

    public void setPeBox(int peBox) {
        dataTracker.set(PE_BOX, Math.max(0, Math.min(peBox, eBox)));
    }

    public int getNeBox() {
        return dataTracker.get(NE_BOX);
    }

    public void setNeBox(int neBox) {
        dataTracker.set(NE_BOX, Math.max(0, Math.min(neBox, eBox)));
    }

    public int getLastPeBox() {
        return dataTracker.get(LAST_PE_BOX);
    }

    public void setLastPeBox(int lastPeBox) {
        dataTracker.set(LAST_PE_BOX, lastPeBox);
    }

    public int getLastNeBox() {
        return dataTracker.get(LAST_NE_BOX);
    }

    public void setLastNeBox(int lastNeBox) {
        dataTracker.set(LAST_NE_BOX, lastNeBox);
    }

    public String getLastWorkMethod() {
        return dataTracker.get(LAST_WORK_METHOD);
    }

    public void setLastWorkMethod(String lastWorkMethod) {
        dataTracker.set(LAST_WORK_METHOD, lastWorkMethod);
    }

    public int getLastWorkLevel() {
        return dataTracker.get(LAST_WORK_LEVEL);
    }

    public void setLastWorkLevel(int lastWorkLevel) {
        dataTracker.set(LAST_WORK_LEVEL, lastWorkLevel);
    }

    public String getLastWorkResult() {
        return dataTracker.get(LAST_WORK_RESULT);
    }

    public void setLastWorkResult(String lastWorkResult) {
        dataTracker.set(LAST_WORK_RESULT, lastWorkResult);
    }

    public boolean isWorking() {
        return dataTracker.get(IS_WORKING);
    }

    public void setWorking(boolean working) {
        dataTracker.set(IS_WORKING, working);
    }

    public boolean isCooling() {
        return dataTracker.get(IS_COOLING);
    }

    public void setCooling(boolean cooling) {
        dataTracker.set(IS_COOLING, cooling);
    }

    public boolean isEscaping() {
        return dataTracker.get(IS_ESCAPING);
    }

    public void setEscaping(boolean escaping) {
        dataTracker.set(IS_ESCAPING, escaping);
    }

    public ServerPlayerEntity getLastWorkPlayer() {
        return lastWorkPlayer;
    }

    public void setLastWorkPlayer(ServerPlayerEntity lastWorkPlayer) {
        this.lastWorkPlayer = lastWorkPlayer;
    }

    //设置所有等级输出值
    public void setLevelOutputValues() {
        //设置ZAYIN等级输出值
        Map<Integer, Float> zayinOutputValues = new HashMap<>();
        zayinOutputValues.put(1, 0.60F);
        zayinOutputValues.put(2, 0.44F);
        zayinOutputValues.put(3, 0.30F);
        zayinOutputValues.put(4, 0.18F);
        zayinOutputValues.put(5, 0.08F);
        zayinOutputValues.put(6, 0.00F);
        levelOutputValues.put(LobeCorpUtil.EGOLevel.ZAYIN, zayinOutputValues);
        //设置TETH等级输出值
        Map<Integer, Float> tethOutputValues = new HashMap<>();
        tethOutputValues.put(1, 0.60F);
        tethOutputValues.put(2, 0.55F);
        tethOutputValues.put(3, 0.40F);
        tethOutputValues.put(4, 0.27F);
        tethOutputValues.put(5, 0.16F);
        tethOutputValues.put(6, 0.00F);
        levelOutputValues.put(LobeCorpUtil.EGOLevel.TETH, tethOutputValues);
        //设置HE等级输出值
        Map<Integer, Float> heOutputValues = new HashMap<>();
        heOutputValues.put(1, 0.72F);
        heOutputValues.put(2, 0.55F);
        heOutputValues.put(3, 0.50F);
        heOutputValues.put(4, 0.36F);
        heOutputValues.put(5, 0.24F);
        heOutputValues.put(6, 0.00F);
        levelOutputValues.put(LobeCorpUtil.EGOLevel.HE, heOutputValues);
        //设置WAW等级输出值
        Map<Integer, Float> wawOutputValues = new HashMap<>();
        wawOutputValues.put(1, 0.84F);
        wawOutputValues.put(2, 0.66F);
        wawOutputValues.put(3, 0.50F);
        wawOutputValues.put(4, 0.45F);
        wawOutputValues.put(5, 0.32F);
        wawOutputValues.put(6, 0.00F);
        levelOutputValues.put(LobeCorpUtil.EGOLevel.WAW, wawOutputValues);
        //设置ALEPH等级输出值
        Map<Integer, Float> alephOutputValues = new HashMap<>();
        alephOutputValues.put(1, 0.92F);
        alephOutputValues.put(2, 0.77F);
        alephOutputValues.put(3, 0.60F);
        alephOutputValues.put(4, 0.45F);
        alephOutputValues.put(5, 0.40F);
        alephOutputValues.put(6, 0.00F);
        levelOutputValues.put(LobeCorpUtil.EGOLevel.ALEPH, alephOutputValues);
    }

    //获取单一等级输出值
    public float getLevelOutputValue() {
        if (levelOutputValues.containsKey(getEGOLevel())) {
            Map<Integer, Float> outputValues = levelOutputValues.get(getEGOLevel());
            if (outputValues.containsKey(getLastWorkLevel())) {
                levelOutputValue = outputValues.get(getLastWorkLevel());
            }
        }
        return levelOutputValue;
    }

    //获取状态等级输出值
    public float getStatusOutputValue() {
        float health = getLastWorkPlayer().getHealth();
        float maxHealth = getLastWorkPlayer().getMaxHealth();
        float sanity = ((ManagerAccess) getLastWorkPlayer()).lobecorp$getSanityManager().getSanity();
        float maxSanity = ((ManagerAccess) getLastWorkPlayer()).lobecorp$getSanityManager().getMaxSanity();
        if (Objects.equals(getLastWorkMethod(), REPRESSION)) {
            finalStatusOutputValue = 0.5F;
            return finalStatusOutputValue;
        } else if (Objects.equals(getLastWorkMethod(), ATTACHMENT)) {
            temporaryStatusOutputValue = (health + sanity) / (maxHealth + maxSanity);
        } else if (Objects.equals(getLastWorkMethod(), INSIGHT)) {
            temporaryStatusOutputValue = sanity / maxSanity;
        } else if (Objects.equals(getLastWorkMethod(), INSTINCT)) {
            temporaryStatusOutputValue = health / maxHealth;
        }
        if (temporaryStatusOutputValue > 0.0F && temporaryStatusOutputValue <= 0.1F) {
            finalStatusOutputValue = 1.5F;
        } else if (temporaryStatusOutputValue > 0.1F && temporaryStatusOutputValue <= 0.2F) {
            finalStatusOutputValue = 1.3F;
        } else if (temporaryStatusOutputValue > 0.2F && temporaryStatusOutputValue < 0.7F) {
            finalStatusOutputValue = 1.0F;
        } else if (temporaryStatusOutputValue >= 0.7F && temporaryStatusOutputValue < 0.8F) {
            finalStatusOutputValue = 0.8F;
        } else if (temporaryStatusOutputValue >= 0.8F && temporaryStatusOutputValue < 0.9F) {
            finalStatusOutputValue = 0.6F;
        } else if (temporaryStatusOutputValue >= 0.9F && temporaryStatusOutputValue <= 1.0F) {
            finalStatusOutputValue = 0.4F;
        }
        return finalStatusOutputValue;
    }

    //设置所有工作概率
    protected abstract void setWorkProbabilities();

    //获取单一工作概率
    public float getProbability() {
        if (workProbabilities.containsKey(workMethod)) {
            Map<Integer, Float> probabilities = workProbabilities.get(workMethod);
            if (probabilities.containsKey(workLevel)) {
                int workSuccess = ((ManagerAccess) workPlayer).lobecorp$getLevelManager().getWorkSuccess();
                probability = Math.max(0.00F, Math.min(probabilities.get(workLevel) + (workSuccess * 0.2F) / 100 + extraProbability, 0.95F));
            }
        }
        return probability;
    }

    public void setExtraProbability(float extraProbability) {
        this.extraProbability += extraProbability;
    }

    public void setWorkLevel(String workMethod) {
        switch (workMethod) {
            case INSTINCT -> workLevel = ((ManagerAccess) workPlayer).lobecorp$getLevelManager().getLevelF().getValue();
            case INSIGHT -> workLevel = ((ManagerAccess) workPlayer).lobecorp$getLevelManager().getLevelP().getValue();
            case ATTACHMENT ->
                    workLevel = ((ManagerAccess) workPlayer).lobecorp$getLevelManager().getLevelT().getValue();
            case REPRESSION ->
                    workLevel = ((ManagerAccess) workPlayer).lobecorp$getLevelManager().getLevelJ().getValue();
        }
    }

    public void setWorkResult(int peBox) {
        if (peBox >= goodMoodMin && peBox <= goodMoodMax) {
            workResult = GOOD;
        } else if (peBox >= normalMoodMin && peBox <= normalMoodMax) {
            workResult = NORMAL;
        } else if (peBox >= badMoodMin && peBox <= badMoodMax) {
            workResult = BAD;
        }
    }

    public void setWorkDurationTime() {
        workDurationTime = (int) (5 * (1 - baseWorkSpeed * (1 +
                (float) ((ManagerAccess) workPlayer).lobecorp$getLevelManager().getWorkVelocity() / 100)) * 20);
    }

    public void setUBox(int uBox) {
        this.uBox = Math.max(0, Math.min(uBox, 999));
    }

    public void setQliphothCounter(int qliphothCounter) {
        this.qliphothCounter = Math.max(0, Math.min(qliphothCounter, maxQliphothCounter));
    }

    //生成工作结果粒子
    public void spawnWorkResultParticle(ParticleEffect particleEffect) {
        getWorld().addParticle(particleEffect, getX(), getEyeY(), getZ(), 0.1F, 0.1F, 0.1F);
    }
}
