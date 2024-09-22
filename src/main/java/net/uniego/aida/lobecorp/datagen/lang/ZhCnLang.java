package net.uniego.aida.lobecorp.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.uniego.aida.lobecorp.init.AttributeInit;
import net.uniego.aida.lobecorp.init.DamageInit;
import net.uniego.aida.lobecorp.init.EffectInit;

import java.util.concurrent.CompletableFuture;

//中文翻译文件生成器
public class ZhCnLang extends FabricLanguageProvider {
    public ZhCnLang(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        //属性名
        translationBuilder.add(AttributeInit.PLAYER_MAX_SANITY_NAME, "最大精神值");
        translationBuilder.add(AttributeInit.PLAYER_MAX_ASSIMILATION_NAME, "最大认知同化值");
        //死亡信息
        translationBuilder.add(DamageInit.DEATH_ATTACK_DRY, "%1$s渴死了");
        translationBuilder.add(DamageInit.DEATH_ATTACK_DRY_PLAYER, "%1$s在与%2$s战斗中因口渴而死");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INSANE, "%1$s因为发狂死掉了");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INSANE_PLAYER, "%1$s在陷入与%2$s战斗时，因为承受不住疯狂而死了");
        translationBuilder.add(DamageInit.DEATH_ATTACK_MYSTIC, "%1$s被神秘杀死了");
        translationBuilder.add(DamageInit.DEATH_ATTACK_MYSTIC_PLAYER, "%1$s在试图逃离%2$s时被神秘杀死了");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INDIRECT_MYSTIC, "%1$s被%2$s使用神秘杀死");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INDIRECT_MYSTIC_ITEM, "%1$s被%2$s使用%3$s杀死了");
        translationBuilder.add(DamageInit.DEATH_ATTACK_RED, "%2$s致使%1$s死于物理破碎");
        translationBuilder.add(DamageInit.DEATH_ATTACK_RED_PLAYER, "%2$s致使%1$s死于物理破碎");
        translationBuilder.add(DamageInit.DEATH_ATTACK_WHITE, "%2$s致使%1$s死于精神崩溃");
        translationBuilder.add(DamageInit.DEATH_ATTACK_WHITE_PLAYER, "%2$s致使%1$s死于精神崩溃");
        translationBuilder.add(DamageInit.DEATH_ATTACK_BLACK, "%2$s致使%1$s死于侵蚀贯穿");
        translationBuilder.add(DamageInit.DEATH_ATTACK_BLACK_PLAYER, "%2$s致使%1$s死于侵蚀贯穿");
        translationBuilder.add(DamageInit.DEATH_ATTACK_PALE, "%2$s致使%1$s死于灵魂削除");
        translationBuilder.add(DamageInit.DEATH_ATTACK_PALE_PLAYER, "%2$s致使%1$s死于灵魂削除");
        //效果名
        translationBuilder.add(EffectInit.ABSENT.value(), "恍惚");
        translationBuilder.add(EffectInit.ASSIMILATION.value(), "认知同化");
        translationBuilder.add(EffectInit.HYDRATION.value(), "滋润");
        translationBuilder.add(EffectInit.INSANE.value(), "狂乱");
        translationBuilder.add(EffectInit.RESTORATION.value(), "精神恢复");
        translationBuilder.add(EffectInit.SANITY_BOOST.value(), "精神提升");
        translationBuilder.add(EffectInit.THIRST.value(), "干渴");
        translationBuilder.add(EffectInit.INSTANT_SANITY.value(), "瞬间镇定");
        translationBuilder.add(EffectInit.INSTANT_INJURY.value(), "瞬间损伤");
    }
}
