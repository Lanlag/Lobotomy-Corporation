package net.uniego.aida.lobecorp.item.ego.gift;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.uniego.aida.lobecorp.init.ComponentInit;
import net.uniego.aida.lobecorp.item.ego.EGOItem;
import net.uniego.aida.lobecorp.item.ego.gift.gifts.BearPawsGift;
import net.uniego.aida.lobecorp.item.ego.gift.gifts.JustitiaGift;
import net.uniego.aida.lobecorp.item.ego.gift.gifts.PenitenceGift;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifierSlot;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

import java.util.List;
import java.util.UUID;

//EGO饰品
public class EGOGift extends EGOItem {
    public static final EGOGift STANDARD_TRAINING_EGO_GIFT = new EGOGift(
            2, 2, 0, 0, 0, 0,
            LOBECORP_HEAD_MODIFIER_ID, LobeCorpAttributeModifierSlot.LOBECORP_HEAD);//教学用E.G.O
    public static final EGOGift HORN_GIFT = new EGOGift(
            2, 2, 0, 0, 0, 0,
            LOBECORP_HEAD_MODIFIER_ID, LobeCorpAttributeModifierSlot.LOBECORP_HEAD);//犄角
    public static final EGOGift BLESS_GIFT = new EGOGift(
            6, 6, 6, 6, 6, 6,
            LOBECORP_OCCIPUT_MODIFIER_ID, LobeCorpAttributeModifierSlot.LOBECORP_OCCIPUT);//祝福

    public EGOGift(int maxHealth, int maxSanity, int workSuccess, int workVelocity, int attackVelocity, int moveVelocity,
                   UUID uuid, LobeCorpAttributeModifierSlot lobecorpSlot) {
        this(maxHealth, maxSanity, workSuccess, workVelocity, attackVelocity, moveVelocity, uuid, lobecorpSlot, null);
    }

    public EGOGift(int maxHealth, int maxSanity, int workSuccess, int workVelocity, int attackVelocity, int moveVelocity,
                   UUID uuid, LobeCorpAttributeModifierSlot lobecorpSlot, List<String> egoSkill) {
        super(new Settings().component(ComponentInit.LOBECORP_ATTRIBUTE_MODIFIERS, LobeCorpUtil.createEGOGiftAttributeModifiers
                (maxHealth, maxSanity, workSuccess, workVelocity, attackVelocity, moveVelocity, uuid, lobecorpSlot)), lobecorpSlot, egoSkill);
    }

    public static void register() {
        Registry.register(Registries.ITEM, LobeCorpUtil.id("standard_training_ego_gift"), STANDARD_TRAINING_EGO_GIFT);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("penitence_gift"), PenitenceGift.PENITENCE_GIFT);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("horn_gift"), HORN_GIFT);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("bear_paws_gift"), BearPawsGift.BEAR_PAWS_GIFT);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("justitia_gift"), JustitiaGift.JUSTITIA_GIFT);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("bless_gift"), BLESS_GIFT);
    }
}
