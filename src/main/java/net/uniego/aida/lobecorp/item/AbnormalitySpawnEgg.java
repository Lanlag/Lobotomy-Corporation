package net.uniego.aida.lobecorp.item;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.init.EntityInit;

//异想体生成蛋
public class AbnormalitySpawnEgg extends LobeCorpItem {
    public static final AbnormalitySpawnEgg STANDARD_TRAINING_DUMMY_RABBIT_EGG = new AbnormalitySpawnEgg(EntityInit.STANDARD_TRAINING_DUMMY_RABBIT_ENTITY);
    public static final AbnormalitySpawnEgg ONE_SIN_AND_HUNDREDS_OF_GOOD_DEEDS_EGG = new AbnormalitySpawnEgg(EntityInit.ONE_SIN_AND_HUNDREDS_OF_GOOD_DEEDS_ENTITY);
    public static final AbnormalitySpawnEgg BEAUTY_AND_THE_BEAST_EGG = new AbnormalitySpawnEgg(EntityInit.BEAUTY_AND_THE_BEAST_ENTITY);
    public static final AbnormalitySpawnEgg HAPPY_TEDDY_BEAR_EGG = new AbnormalitySpawnEgg(EntityInit.HAPPY_TEDDY_BEAR_ENTITY);
    public static final AbnormalitySpawnEgg JUDGEMENT_BIRD_EGG = new AbnormalitySpawnEgg(EntityInit.JUDGEMENT_BIRD_ENTITY);
    private static final MapCodec<EntityType<?>> ENTITY_TYPE_MAP_CODEC;

    static {
        ENTITY_TYPE_MAP_CODEC = Registries.ENTITY_TYPE.getCodec().fieldOf("id");
    }

    private final EntityType<?> type;

    public AbnormalitySpawnEgg(EntityType<?> type) {
        super(new Settings().maxCount(1).fireproof());
        this.type = type;
    }

    public static void register() {
        Registry.register(Registries.ITEM, LobeCorpUtil.id("standard_training_dummy_rabbit_egg"), STANDARD_TRAINING_DUMMY_RABBIT_EGG);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("one_sin_and_hundreds_of_good_deeds_egg"), ONE_SIN_AND_HUNDREDS_OF_GOOD_DEEDS_EGG);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("beauty_and_the_beast_egg"), BEAUTY_AND_THE_BEAST_EGG);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("happy_teddy_bear_egg"), HAPPY_TEDDY_BEAR_EGG);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("judgement_bird_egg"), JUDGEMENT_BIRD_EGG);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!(world instanceof ServerWorld)) {
            return ActionResult.SUCCESS;
        } else {
            ItemStack itemStack = context.getStack();
            BlockPos blockPos = context.getBlockPos();
            Direction direction = context.getSide();
            BlockState blockState = world.getBlockState(blockPos);
            BlockPos blockPos2;
            if (blockState.getCollisionShape(world, blockPos).isEmpty()) {
                blockPos2 = blockPos;
            } else {
                blockPos2 = blockPos.offset(direction);
            }

            EntityType<?> entityType = getEntityType(itemStack);
            if (entityType.spawnFromItemStack((ServerWorld) world, itemStack, context.getPlayer(), blockPos2, SpawnReason.SPAWN_EGG,
                    true, !blockPos2.equals(blockPos) && direction == Direction.UP) != null) {
                itemStack.decrement(1);
                world.emitGameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);
            }

            return ActionResult.CONSUME;
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        if (blockHitResult.getType() != HitResult.Type.BLOCK) {
            return TypedActionResult.pass(itemStack);
        } else if (!(world instanceof ServerWorld)) {
            return TypedActionResult.success(itemStack);
        } else {
            BlockPos blockPos = blockHitResult.getBlockPos();
            if (!(world.getBlockState(blockPos).getBlock() instanceof FluidBlock)) {
                return TypedActionResult.pass(itemStack);
            } else if (world.canPlayerModifyAt(user, blockPos) && user.canPlaceOn(blockPos, blockHitResult.getSide(), itemStack)) {
                EntityType<?> entityType = getEntityType(itemStack);
                Entity entity = entityType.spawnFromItemStack((ServerWorld) world, itemStack, user, blockPos, SpawnReason.SPAWN_EGG, false, false);
                if (entity == null) {
                    return TypedActionResult.pass(itemStack);
                } else {
                    itemStack.decrementUnlessCreative(1, user);
                    user.incrementStat(Stats.USED.getOrCreateStat(this));
                    world.emitGameEvent(user, GameEvent.ENTITY_PLACE, entity.getPos());
                    return TypedActionResult.consume(itemStack);
                }
            } else {
                return TypedActionResult.fail(itemStack);
            }
        }
    }

    public EntityType<?> getEntityType(ItemStack stack) {
        NbtComponent nbtComponent = stack.getOrDefault(DataComponentTypes.ENTITY_DATA, NbtComponent.DEFAULT);
        return !nbtComponent.isEmpty() ? nbtComponent.get(ENTITY_TYPE_MAP_CODEC).result().orElse(type) : type;
    }
}
