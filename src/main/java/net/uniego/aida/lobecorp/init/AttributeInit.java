package net.uniego.aida.lobecorp.init;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.uniego.aida.lobecorp.LobeCorpUtil;

import java.util.UUID;

//初始化属性
public class AttributeInit {
    public static final UUID ATTACK_VELOCITY_MODIFIER_ID = UUID.fromString("9F0BF5D-8C67-40D0-9A7C-C9E29011F02B");//攻击速率修饰ID
    public static final UUID MOVE_VELOCITY_MODIFIER_ID = UUID.fromString("A12BFDCB-F7D2-458A-B2B5-9C4F7AFAC2E8");//移动速率修饰ID

    public static final String PLAYER_MAX_SANITY_NAME = "attribute.name.player.max_sanity";//最大精神值
    public static final String PLAYER_MAX_ASSIMILATION_NAME = "attribute.name.player.max_assimilation";//最大认知同化值
    public static final String PLAYER_WORK_SUCCESS_NAME = "attribute.name.player.work_success";//工作胜率
    public static final String PLAYER_WORK_VELOCITY_NAME = "attribute.name.player.work_velocity";//工作速率
    public static final String PLAYER_ATTACK_VELOCITY_NAME = "attribute.name.player.attack_velocity";//攻击速率
    public static final String PLAYER_MOVE_VELOCITY_NAME = "attribute.name.player.move_velocity";//移动速率

    public static final RegistryEntry<EntityAttribute> PLAYER_MAX_SANITY = register("player.max_sanity",
            (new ClampedEntityAttribute(PLAYER_MAX_SANITY_NAME, 20.0, 1.0, 1024.0)).setTracked(true));
    public static final RegistryEntry<EntityAttribute> PLAYER_MAX_ASSIMILATION = register("player.max_assimilation",
            (new ClampedEntityAttribute(PLAYER_MAX_ASSIMILATION_NAME, 0.0, 0.0, 2048.0)).setTracked(true));
    public static final RegistryEntry<EntityAttribute> PLAYER_WORK_SUCCESS = register("player.work_success",
            (new ClampedEntityAttribute(PLAYER_WORK_SUCCESS_NAME, 20.0, 1.0, 1024.0)).setTracked(true));
    public static final RegistryEntry<EntityAttribute> PLAYER_WORK_VELOCITY = register("player.work_velocity",
            (new ClampedEntityAttribute(PLAYER_WORK_VELOCITY_NAME, 20.0, 1.0, 1024.0)).setTracked(true));
    public static final RegistryEntry<EntityAttribute> PLAYER_ATTACK_VELOCITY = register("player.attack_velocity",
            (new ClampedEntityAttribute(PLAYER_ATTACK_VELOCITY_NAME, 20.0, 1.0, 1024.0)).setTracked(true));
    public static final RegistryEntry<EntityAttribute> PLAYER_MOVE_VELOCITY = register("player.move_velocity",
            (new ClampedEntityAttribute(PLAYER_MOVE_VELOCITY_NAME, 20.0, 1.0, 1024.0)).setTracked(true));

    private static RegistryEntry<EntityAttribute> register(String id, EntityAttribute attribute) {
        return Registry.registerReference(Registries.ATTRIBUTE, LobeCorpUtil.id(id), attribute);
    }
}
