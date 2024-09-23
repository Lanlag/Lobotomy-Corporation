package net.uniego.aida.lobecorp.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.uniego.aida.lobecorp.init.*;
import net.uniego.aida.lobecorp.item.LobeCorpItem;

import java.util.concurrent.CompletableFuture;

//英文翻译文件生成器
public class EnUsLang extends FabricLanguageProvider {
    public EnUsLang(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        //属性名
        translationBuilder.add(AttributeInit.PLAYER_MAX_SANITY_NAME, "Max Sanity");
        translationBuilder.add(AttributeInit.PLAYER_MAX_ASSIMILATION_NAME, "Max Assimilation");
        //死亡信息
        translationBuilder.add(DamageInit.DEATH_ATTACK_DRY, "%1$s dried to death");
        translationBuilder.add(DamageInit.DEATH_ATTACK_DRY_PLAYER, "%1$s dried to death whilst fighting %2$s");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INSANE, "%1$s died due to insanity");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INSANE_PLAYER, "%1$s experienced insanity to death whilst fighting %2$s");
        translationBuilder.add(DamageInit.DEATH_ATTACK_MYSTIC, "%1$s was killed by mystic");
        translationBuilder.add(DamageInit.DEATH_ATTACK_MYSTIC_PLAYER, "%1$s was killed by mystic whilst trying to escape %2$s");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INDIRECT_MYSTIC, "%1$s was killed by %2$s using mystic");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INDIRECT_MYSTIC_ITEM, "%1$s was killed by %2$s using %3$s");
        translationBuilder.add(DamageInit.DEATH_ATTACK_RED, "%2$s caused %1$s died from Physical Shattering");
        translationBuilder.add(DamageInit.DEATH_ATTACK_RED_PLAYER, "%2$s caused %1$s died from Physical Shattering");
        translationBuilder.add(DamageInit.DEATH_ATTACK_WHITE, "%2$s caused %1$s died from Mental Collapse");
        translationBuilder.add(DamageInit.DEATH_ATTACK_WHITE_PLAYER, "%2$s caused %1$s died from Mental Collapse");
        translationBuilder.add(DamageInit.DEATH_ATTACK_BLACK, "%2$s caused %1$s died from Erosion Penetration");
        translationBuilder.add(DamageInit.DEATH_ATTACK_BLACK_PLAYER, "%2$s caused %1$s died from Erosion Penetration");
        translationBuilder.add(DamageInit.DEATH_ATTACK_PALE, "%2$s caused %1$s died from Soul Erasure");
        translationBuilder.add(DamageInit.DEATH_ATTACK_PALE_PLAYER, "%2$s caused %1$s died from Soul Erasure");
        //效果名
        translationBuilder.add(EffectInit.ABSENT.value(), "Absent");
        translationBuilder.add(EffectInit.ASSIMILATION.value(), "Assimilation");
        translationBuilder.add(EffectInit.HYDRATION.value(), "Hydration");
        translationBuilder.add(EffectInit.INSANE.value(), "Insane");
        translationBuilder.add(EffectInit.RESTORATION.value(), "Restoration");
        translationBuilder.add(EffectInit.SANITY_BOOST.value(), "Sanity Boost");
        translationBuilder.add(EffectInit.THIRST.value(), "Thirst");
        translationBuilder.add(EffectInit.INSTANT_SANITY.value(), "Instant Sanity");
        translationBuilder.add(EffectInit.INSTANT_INJURY.value(), "Instant Injury");
        //物品名
        translationBuilder.add(LobeCorpItem.LOBECORP_LOGO, "LobeCorp Logo");
        translationBuilder.add(LobeCorpItem.BLUE_LEAF, "Blue Leaf");
        //物品栏名
        translationBuilder.add(ItemGroupInit.LOBECORP_TAB_NAME, "LobeCorp");
        //声音名
        translationBuilder.add(SoundInit.SWALLOW_WATER_ID, "Swallow Water");
        //屏幕名
        translationBuilder.add(ScreenInit.CONTAINER_EQUIPMENT, "Equipment");
        //按键类名
        translationBuilder.add(KeyInit.CATEGORIES_LOBECORP, "Lobe Corp");
        translationBuilder.add(KeyInit.KEY_EQUIPMENT_INVENTORY, "Open/Close Equipment");
    }
}
