package net.uniego.aida.lobecorp.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;
import net.uniego.aida.lobecorp.LobeCorpUtil;

import java.util.UUID;

//脑叶公司物品
public class LobeCorpItem extends Item {
    //插槽修饰ID
    public static final UUID LOBECORP_WEAPON_MODIFIER_ID = UUID.fromString("91D1DBFF-954B-4399-A2A3-B5CC7D838E98");
    public static final UUID LOBECORP_SUIT_MODIFIER_ID = UUID.fromString("EE3CBD25-29F0-4496-8D0F-CE1094AE095C");
    public static final UUID LOBECORP_BADGE_MODIFIER_ID = UUID.fromString("A4D67FF2-34CB-4704-A01D-62DC1BD306AF");
    public static final UUID LOBECORP_TOOL_MODIFIER_ID = UUID.fromString("48C60708-5D00-4BA1-85D4-62137DB8ADCE");
    public static final UUID LOBECORP_HAT_MODIFIER_ID = UUID.fromString("5F886ED8-2D1D-4E09-A077-CA09662DB231");
    public static final UUID LOBECORP_HEAD_MODIFIER_ID = UUID.fromString("B1E0739C-EE5F-4374-AB13-8880603B287F");
    public static final UUID LOBECORP_OCCIPUT_MODIFIER_ID = UUID.fromString("D0B1526D-85FF-4FE6-9C37-C18C18A30126");
    public static final UUID LOBECORP_EYE_MODIFIER_ID = UUID.fromString("BED26A1F-96B3-4AF8-95EF-1928ACADE830");
    public static final UUID LOBECORP_FACE_MODIFIER_ID = UUID.fromString("1F7944F3-2761-4E99-8BDE-2523FEC8ECC5");
    public static final UUID LOBECORP_CHEEK_MODIFIER_ID = UUID.fromString("97DBCE67-42BF-4DD8-B365-C27FB8A38F53");
    public static final UUID LOBECORP_MASK_MODIFIER_ID = UUID.fromString("D00D5F85-5F7D-447A-8E0F-201FB4A82643");
    public static final UUID LOBECORP_MOUTH_MODIFIER_ID = UUID.fromString("7BEF6C6E-6512-4B0A-A242-3BEEE2870842");
    public static final UUID LOBECORP_NECK_MODIFIER_ID = UUID.fromString("5E3397B7-52BB-4B96-8CEC-A7050E9814FF");
    public static final UUID LOBECORP_CHEST_MODIFIER_ID = UUID.fromString("6295FD4F-C578-4B89-8699-EA3E67B04C3D");
    public static final UUID LOBECORP_HAND_MODIFIER_ID = UUID.fromString("8F54F7F8-8057-4B7D-84C6-F8339112CE09");
    public static final UUID LOBECORP_GLOVE_MODIFIER_ID = UUID.fromString("5B7299F7-BC3E-49A6-8A72-43510FC3CF06");
    public static final UUID LOBECORP_RIGHTBACK_MODIFIER_ID = UUID.fromString("ED5AC93A-DAE1-4C91-996A-4129CDD742AC");
    public static final UUID LOBECORP_LEFTBACK_MODIFIER_ID = UUID.fromString("8F1ACDBD-EB65-461C-9E69-35A675023A0B");

    public static final LobeCorpItem LOBECORP_LOGO = new LobeCorpItem(new Item.Settings().rarity(Rarity.EPIC).maxCount(1).fireproof());
    public static final LobeCorpItem BLUE_LEAF = new LobeCorpItem(new Item.Settings()
            .food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.1F).snack().build()));

    public LobeCorpItem(Settings settings) {
        super(settings);
    }

    public static void register() {
        Registry.register(Registries.ITEM, LobeCorpUtil.id("lobecorp_logo"), LOBECORP_LOGO);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("blue_leaf"), BLUE_LEAF);
    }
}
