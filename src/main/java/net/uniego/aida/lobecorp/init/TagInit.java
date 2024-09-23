package net.uniego.aida.lobecorp.init;


import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//初始化标签
public class TagInit {
    public static final TagKey<Item> HYDRATING_FOODS = TagKey.of(RegistryKeys.ITEM, LobeCorpUtil.id("hydrating_foods"));
    public static final TagKey<Item> RED_EGO_WEAPONS = TagKey.of(RegistryKeys.ITEM, LobeCorpUtil.id("red_ego_weapons"));
    public static final TagKey<Item> WHITE_EGO_WEAPONS = TagKey.of(RegistryKeys.ITEM, LobeCorpUtil.id("white_ego_weapons"));
    public static final TagKey<Item> BLACK_EGO_WEAPONS = TagKey.of(RegistryKeys.ITEM, LobeCorpUtil.id("black_ego_weapons"));
    public static final TagKey<Item> PALE_EGO_WEAPONS = TagKey.of(RegistryKeys.ITEM, LobeCorpUtil.id("pale_ego_weapons"));
}
