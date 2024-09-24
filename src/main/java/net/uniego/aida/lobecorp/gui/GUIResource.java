package net.uniego.aida.lobecorp.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ButtonTextures;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//所有GUI所要使用的资源
@Environment(EnvType.CLIENT)
public class GUIResource {
    //贴图
    //各种图标
    public static final Identifier LOBECORP_ICONS = LobeCorpUtil.id("textures/gui/lobecorp_icons.png");
    //脑叶公司屏幕贴图
    public static final Identifier LOBECORP_INVENTORY = LobeCorpUtil.id("textures/gui/container/lobecorp_inventory.png");
    //饰品屏幕贴图
    public static final Identifier GIFT_INVENTORY = LobeCorpUtil.id("textures/gui/container/gift_inventory.png");
    //EGO饰品按钮
    public static final ButtonTextures EGO_GIFT_BUTTON = new ButtonTextures(LobeCorpUtil.id("ego_gift_button"), LobeCorpUtil.id("ego_gift_button_highlighted"));
    //脑叶公司插槽图
    public static final Identifier EMPTY_LOBECORP_WEAPON_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_weapon");
    public static final Identifier EMPTY_LOBECORP_SUIT_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_suit");
    public static final Identifier EMPTY_LOBECORP_BADGE_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_badge");
    public static final Identifier EMPTY_LOBECORP_TOOL_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_tool");
    public static final Identifier EMPTY_LOBECORP_HAT_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_hat");
    public static final Identifier EMPTY_LOBECORP_HEAD_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_head");
    public static final Identifier EMPTY_LOBECORP_OCCIPUT_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_occiput");
    public static final Identifier EMPTY_LOBECORP_EYE_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_eye");
    public static final Identifier EMPTY_LOBECORP_FACE_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_face");
    public static final Identifier EMPTY_LOBECORP_CHEEK_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_cheek");
    public static final Identifier EMPTY_LOBECORP_MASK_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_mask");
    public static final Identifier EMPTY_LOBECORP_MOUTH_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_mouth");
    public static final Identifier EMPTY_LOBECORP_NECK_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_neck");
    public static final Identifier EMPTY_LOBECORP_CHEST_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_chest");
    public static final Identifier EMPTY_LOBECORP_HAND_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_hand");
    public static final Identifier EMPTY_LOBECORP_GLOVE_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_glove");
    public static final Identifier EMPTY_LOBECORP_RIGHTBACK_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_rightback");
    public static final Identifier EMPTY_LOBECORP_LEFTBACK_TEXTURE = LobeCorpUtil.id("gui/sprites/empty_lobecorp_leftback");

    //颜色代码
    //16进制颜色代码（包含透明度）
    public static final int BG1 = 0xA0000000;//一般用于外部背景
    public static final int BG2 = 0x20FFFFFF;//一般用于内部背景
    public static final int BG3 = 0x40FFFFFF;//用于高亮标记所选快捷栏
    public static final int BG4 = 0x60000000;//用于渲染快捷栏内部背景
    //16进制颜色代码（不包含透明度）
    //状态条
    public static final int AIR = 0x739DF3;//氧气条颜色
    public static final int EXPERIENCE = 0xB3F37D;//经验条以及经验字体颜色
    public static final int POISON = 0x947818;//中毒颜色
    public static final int WITHER = 0x3B1313;//凋零颜色
    public static final int FROZEN = 0x4CBAD8;//冻伤颜色
    public static final int HEALTH = 0xC10000;//生命条以及生命字体颜色
    public static final int MOUNT_JUMP = 0xFFB65F;//坐骑跳跃条颜色
    public static final int ABSENT = 0x2B8181;//恍惚颜色
    public static final int INSANE = 0x270E40;//狂乱颜色
    public static final int SANITY = 0x005BC2;//精神条以及精神字体颜色
    public static final int SHIELD = 0xD4AF37;//力场盾颜色

    //HUD元素类型名
    public static final String AIR_ELEMENT = "air_element";//玩家氧气条
    public static final String ARMOR_ELEMENT = "armor_element";//玩家护甲
    public static final String EXPERIENCE_ELEMENT = "experience_element";//玩家经验条
    public static final String FOOD_ELEMENT = "food_element";//玩家饥饿条
    public static final String HEAD_ELEMENT = "head_element";//玩家头像
    public static final String HEALTH_ELEMENT = "health_element";//玩家生命条
    public static final String HOT_BAR_ELEMENT = "hot_bar_element";//玩家快捷栏
    public static final String MOUNT_HEALTH_ELEMENT = "mount_health_element";//坐骑生命条
    public static final String MOUNT_JUMP_ELEMENT = "mount_jump_element";//坐骑跳跃条
    public static final String SANITY_ELEMENT = "sanity_element";//玩家精神条
    public static final String WATER_ELEMENT = "water_element";//玩家干渴条

    //面板信息
    public static final String STAFF_LEVEL = "staff.level";//职员等级
    public static final String STAFF_FORTITUDE = "staff.fortitude";//勇气
    public static final String STAFF_PRUDENCE = "staff.prudence";//谨慎
    public static final String STAFF_TEMPERANCE = "staff.temperance";//自律
    public static final String STAFF_JUSTICE = "staff.justice";//正义
    public static final String STAFF_MAX_HEALTH = "staff.max_health";//最大生命
    public static final String STAFF_MAX_SANITY = "staff.max_sanity";//最大精神
    public static final String STAFF_WORK_SUCCESS = "staff.work_success";//工作胜率
    public static final String STAFF_WORK_VELOCITY = "staff.work_velocity";//工作速率
    public static final String STAFF_ATTACK_VELOCITY = "staff.attack_velocity";//攻击速率
    public static final String STAFF_MOVE_VELOCITY = "staff.move_velocity";//移动速率
}
