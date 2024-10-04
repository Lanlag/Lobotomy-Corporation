package net.uniego.aida.lobecorp.item.ego.gift;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.init.ComponentInit;
import net.uniego.aida.lobecorp.item.ego.EGOItem;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifierSlot;

import java.util.UUID;

//EGO饰品
public class EGOGift extends EGOItem {
    public static final EGOGift STANDARD_TRAINING_EGO_GIFT = new EGOGift(
            2, 2, 0, 0, 0, 0,
            LOBECORP_HEAD_MODIFIER_ID, LobeCorpAttributeModifierSlot.LOBECORP_HEAD);//教学用E.G.O
    public static final EGOGift BLESS_GIFT = new EGOGift(
            6, 6, 6, 6, 6, 6,
            LOBECORP_OCCIPUT_MODIFIER_ID, LobeCorpAttributeModifierSlot.LOBECORP_OCCIPUT);//祝福

    public EGOGift(int maxHealth, int maxSanity, int workSuccess, int workVelocity, int attackVelocity, int moveVelocity,
                   UUID uuid, LobeCorpAttributeModifierSlot lobecorpSlot) {
        this(maxHealth, maxSanity, workSuccess, workVelocity, attackVelocity, moveVelocity, uuid, lobecorpSlot, "");
    }

    public EGOGift(int maxHealth, int maxSanity, int workSuccess, int workVelocity, int attackVelocity, int moveVelocity,
                   UUID uuid, LobeCorpAttributeModifierSlot lobecorpSlot, String egoSkill) {
        super(new Settings().component(ComponentInit.LOBECORP_ATTRIBUTE_MODIFIERS, LobeCorpUtil.createEGOGiftAttributeModifiers
                (maxHealth, maxSanity, workSuccess, workVelocity, attackVelocity, moveVelocity, uuid, lobecorpSlot)), lobecorpSlot, egoSkill);
    }

    public static void register() {
        Registry.register(Registries.ITEM, LobeCorpUtil.id("standard_training_ego_gift"), STANDARD_TRAINING_EGO_GIFT);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("bless_gift"), BLESS_GIFT);
    }
}
