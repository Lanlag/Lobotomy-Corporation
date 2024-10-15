package net.uniego.aida.lobecorp.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.access.ServerPlayerAccess;
import net.uniego.aida.lobecorp.entity.DeadPlayerEntity;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.gui.screen.BoxScreenHandler;
import net.uniego.aida.lobecorp.gui.screen.WorkScreenHandler;
import net.uniego.aida.lobecorp.item.badge.TeamBadge;
import net.uniego.aida.lobecorp.manager.SanityManager;
import net.uniego.aida.lobecorp.manager.ThirstManager;
import net.uniego.aida.lobecorp.network.packet.SyncAbnormalityPacket;
import net.uniego.aida.lobecorp.network.packet.SyncEquipmentPacket;
import net.uniego.aida.lobecorp.network.packet.SyncIconPacket;
import net.uniego.aida.lobecorp.network.packet.SyncOffsetPacket;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity implements ServerPlayerAccess {
    @Unique
    private final SanityManager sanityManager = ((ManagerAccess) this).lobecorp$getSanityManager();
    @Unique
    private final ThirstManager thirstManager = ((ManagerAccess) this).lobecorp$getThirstManager();
    @Unique
    ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) (Object) this;
    @Unique
    private float syncedSanity = -1.0E8F;
    @Unique
    private float syncedAssimilation = -1.0E8F;
    @Unique
    private int syncedWaterLevel = -99999999;
    @Unique
    private boolean playerChangeDimension = false;
    @Unique
    private boolean openBoxScreenHandler = false;
    @Unique
    private boolean openWorkScreenHandler = false;
    @Unique
    private DeadPlayerEntity deadPlayer = null;
    @Unique
    private ItemStack syncedBadgeItemStack = ItemStack.EMPTY;

    public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Shadow
    public abstract boolean isSpectator();

    @Shadow
    public abstract void closeHandledScreen();

    @Override
    public void lobecorp$playerChangeDimension() {
        playerChangeDimension = true;
    }

    @Override
    public DeadPlayerEntity lobecorp$getDeadPlayer() {
        return deadPlayer;
    }

    @Override
    public void lobecorp$openWorkScreenHandler() {
        openWorkScreenHandler = true;
    }

    @Override
    public void lobecorp$openBoxScreenHandler() {
        openBoxScreenHandler = true;
    }

    //实时同步玩家饱水度和脱水度，饱食度和消耗度，以及玩家装饰等机制
    @Inject(method = "tick", at = @At("TAIL"))
    private void tickMixin(CallbackInfo ci) {
        SyncEquipmentPacket.send(serverPlayerEntity);
        SyncOffsetPacket.send(serverPlayerEntity);
        ItemStack badgeItemStack = LobeCorpUtil.getLobeCorpEquippedStack(serverPlayerEntity, LobeCorpEquipmentSlot.LOBECORP_BADGE_SLOT);
        if (!badgeItemStack.equals(syncedBadgeItemStack)) {
            TeamBadge.syncTeam(badgeItemStack, getCommandSource(), getCommandSource().getServer().getCommandManager(), serverPlayerEntity);
            syncedBadgeItemStack = badgeItemStack;
        }
        //正在交互的玩家离异想体太远时或者正在交互的玩家恐慌时，应当立刻强制关闭正在与其交互的玩家的屏幕
        if (currentScreenHandler instanceof WorkScreenHandler workScreenHandler) {
            AbnormalityEntity abnormality = workScreenHandler.abnormality;
            if (abnormality != null) {
                Vec3d interactPlayerPos = getPos();
                Vec3d abnormalityPos = abnormality.getPos();
                double squaredDistanceTo = interactPlayerPos.squaredDistanceTo(abnormalityPos);
                if (squaredDistanceTo > LobeCorpUtil.MAX_INTERACT_ABNORMALITY_DISTANCE || sanityManager.isCrazy()) {
                    closeHandledScreen();
                }
            }
        } else if (currentScreenHandler instanceof BoxScreenHandler boxScreenHandler) {
            AbnormalityEntity abnormality = boxScreenHandler.abnormality;
            if (abnormality != null) {
                Vec3d interactPlayerPos = getPos();
                Vec3d abnormalityPos = abnormality.getPos();
                double squaredDistanceTo = interactPlayerPos.squaredDistanceTo(abnormalityPos);
                if (squaredDistanceTo > LobeCorpUtil.MAX_INTERACT_ABNORMALITY_DISTANCE || sanityManager.isCrazy()) {
                    closeHandledScreen();
                }
            }
        }
    }

    //当玩家状态发生变化时，发送同步信息的数据包，同时同步服务端客户端的异想体信息
    @Inject(method = "playerTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;tick()V", shift = At.Shift.AFTER))
    private void playerTickMixin(CallbackInfo ci) {
        if (openWorkScreenHandler) {
            if (currentScreenHandler instanceof WorkScreenHandler workScreenHandler) {
                SyncAbnormalityPacket.send(serverPlayerEntity, workScreenHandler.abnormality.getId());
                openWorkScreenHandler = false;
            }
        }
        if (openBoxScreenHandler) {
            if (currentScreenHandler instanceof BoxScreenHandler boxScreenHandler) {
                SyncAbnormalityPacket.send(serverPlayerEntity, boxScreenHandler.abnormality.getId());
                openBoxScreenHandler = false;
            }
        }
        if (sanityManager.getSanity() != syncedSanity
                || sanityManager.getAssimilationAmount() != syncedAssimilation
                || thirstManager.getWaterLevel() != syncedWaterLevel
                || playerChangeDimension) {
            SyncIconPacket.send(serverPlayerEntity);
            syncedSanity = sanityManager.getSanity();
            syncedAssimilation = sanityManager.getAssimilationAmount();
            syncedWaterLevel = thirstManager.getWaterLevel();
            if (playerChangeDimension) playerChangeDimension = false;
        }
    }

    //当复制玩家状态时，确保数据一致
    @Inject(method = "copyFrom", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;setHealth(F)V"))
    private void copyFromMixin(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo ci) {
        sanityManager.setSanity(((ManagerAccess) oldPlayer).lobecorp$getSanityManager().getSanity());
        thirstManager.setWaterLevel(((ManagerAccess) oldPlayer).lobecorp$getThirstManager().getWaterLevel());
        thirstManager.setHydrationLevel(((ManagerAccess) oldPlayer).lobecorp$getThirstManager().getHydrationLevel());
        thirstManager.setDesiccation(((ManagerAccess) oldPlayer).lobecorp$getThirstManager().getDesiccation());
    }

    //在玩家死亡时创建尸体
    @Inject(method = "onDeath", at = @At("TAIL"))
    private void onDeathMixin(DamageSource damageSource, CallbackInfo ci) {
        if (!isSpectator()) deadPlayer = DeadPlayerEntity.create(serverPlayerEntity);
    }
}
