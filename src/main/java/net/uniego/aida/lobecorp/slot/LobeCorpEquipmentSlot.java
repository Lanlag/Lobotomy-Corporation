package net.uniego.aida.lobecorp.slot;

import net.minecraft.util.StringIdentifiable;

//脑叶公司装备插槽
public enum LobeCorpEquipmentSlot implements StringIdentifiable {
    LOBECORP_WEAPON_SLOT("lobecorp_weapon_slot"),//脑叶公司武器位
    LOBECORP_SUIT_SLOT("lobecorp_suit_slot"),//脑叶公司护甲位
    LOBECORP_BADGE_SLOT("lobecorp_badge_slot"),//脑叶公司袖标位
    LOBECORP_TOOL_SLOT("lobecorp_tool_slot"),//脑叶公司工具位
    LOBECORP_HAT_SLOT("lobecorp_hat_slot"),//脑叶公司头饰位
    LOBECORP_HEAD_SLOT("lobecorp_head_slot"),//脑叶公司头部位
    LOBECORP_OCCIPUT_SLOT("lobecorp_occiput_slot"),//脑叶公司后脑位
    LOBECORP_EYE_SLOT("lobecorp_eye_slot"),//脑叶公司眼部位
    LOBECORP_FACE_SLOT("lobecorp_face_slot"),//脑叶公司面部位
    LOBECORP_CHEEK_SLOT("lobecorp_cheek_slot"),//脑叶公司脸颊位
    LOBECORP_MASK_SLOT("lobecorp_mask_slot"),//脑叶公司面具位
    LOBECORP_MOUTH_SLOT("lobecorp_mouth_slot"),//脑叶公司口部位
    LOBECORP_NECK_SLOT("lobecorp_neck_slot"),//脑叶公司颈部位
    LOBECORP_CHEST_SLOT("lobecorp_chest_slot"),//脑叶公司胸部位
    LOBECORP_HAND_SLOT("lobecorp_hand_slot"),//脑叶公司手部位
    LOBECORP_GLOVE_SLOT("lobecorp_glove_slot"),//脑叶公司手套位
    LOBECORP_RIGHTBACK_SLOT("lobecorp_rightback_slot"),//脑叶公司右背位
    LOBECORP_LEFTBACK_SLOT("lobecorp_leftback_slot");//脑叶公司左背位

    private final String slotName;

    LobeCorpEquipmentSlot(final String slotName) {
        this.slotName = slotName;
    }

    public String getSlotName() {
        return slotName;
    }

    @Override
    public String asString() {
        return getSlotName();
    }
}
