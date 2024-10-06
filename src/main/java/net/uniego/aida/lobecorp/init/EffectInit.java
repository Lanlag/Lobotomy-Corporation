package net.uniego.aida.lobecorp.init;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.uniego.aida.lobecorp.effect.*;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

//初始化效果
public class EffectInit {
    public static RegistryEntry<StatusEffect> ABSENT;//恍惚
    public static RegistryEntry<StatusEffect> ASSIMILATION;//认知同化
    public static RegistryEntry<StatusEffect> HYDRATION;//滋润
    public static RegistryEntry<StatusEffect> INSANE;//狂乱
    public static RegistryEntry<StatusEffect> RESTORATION;//精神恢复
    public static RegistryEntry<StatusEffect> SANITY_BOOST;//精神提升
    public static RegistryEntry<StatusEffect> THIRST;//干渴
    public static RegistryEntry<StatusEffect> INSTANT_SANITY;//瞬间镇定
    public static RegistryEntry<StatusEffect> INSTANT_INJURY;//瞬间损伤

    public static void register() {
        ABSENT = register("absent", new AbsentEffect(StatusEffectCategory.HARMFUL, 2588492));
        ASSIMILATION = register("assimilation", (new AssimilationEffect(StatusEffectCategory.BENEFICIAL, 16744448))
                .addAttributeModifier(AttributeInit.PLAYER_MAX_ASSIMILATION, "DA2F9E13-1D13-4D70-9B54-04041C06B857",
                        4.0, EntityAttributeModifier.Operation.ADD_VALUE));
        HYDRATION = register("hydration", new HydrationEffect(StatusEffectCategory.BENEFICIAL, 6476510));
        INSANE = register("insane", new InsaneEffect(StatusEffectCategory.HARMFUL, 2557504));
        RESTORATION = register("restoration", new RestorationEffect(StatusEffectCategory.BENEFICIAL, 5885736));
        SANITY_BOOST = register("sanity_boost", (new SanityBoostEffect(StatusEffectCategory.BENEFICIAL, 16298947))
                .addAttributeModifier(AttributeInit.PLAYER_MAX_SANITY, "C5FAE497-6E90-44EB-97A3-9D50C2E8E26A",
                        4.0, EntityAttributeModifier.Operation.ADD_VALUE));
        THIRST = register("thirst", new ThirstEffect(StatusEffectCategory.HARMFUL, 13819490));
        INSTANT_SANITY = register("instant_sanity", new InstantSanityOrInjuryStatusEffect(StatusEffectCategory.BENEFICIAL, 10865167, false));
        INSTANT_INJURY = register("instant_injury", new InstantSanityOrInjuryStatusEffect(StatusEffectCategory.HARMFUL, 211141, true));
    }

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, LobeCorpUtil.id(id), statusEffect);
    }
}
