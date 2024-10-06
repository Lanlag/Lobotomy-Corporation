package net.uniego.aida.lobecorp.init;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

//初始化伤害
public class DamageInit {
    public static final String DEATH_ATTACK_DRY = "death.attack.dry";
    public static final String DEATH_ATTACK_DRY_PLAYER = "death.attack.dry.player";
    public static final String DEATH_ATTACK_INSANE = "death.attack.insane";
    public static final String DEATH_ATTACK_INSANE_PLAYER = "death.attack.insane.player";
    public static final String DEATH_ATTACK_INDIRECT_MYSTIC = "death.attack.indirectMystic";
    public static final String DEATH_ATTACK_INDIRECT_MYSTIC_ITEM = "death.attack.indirectMystic.item";
    public static final String DEATH_ATTACK_MYSTIC = "death.attack.mystic";
    public static final String DEATH_ATTACK_MYSTIC_PLAYER = "death.attack.mystic.player";
    public static final String DEATH_ATTACK_RED = "death.attack.red";
    public static final String DEATH_ATTACK_RED_PLAYER = "death.attack.red.player";
    public static final String DEATH_ATTACK_WHITE = "death.attack.white";
    public static final String DEATH_ATTACK_WHITE_PLAYER = "death.attack.white.player";
    public static final String DEATH_ATTACK_BLACK = "death.attack.black";
    public static final String DEATH_ATTACK_BLACK_PLAYER = "death.attack.black.player";
    public static final String DEATH_ATTACK_PALE = "death.attack.pale";
    public static final String DEATH_ATTACK_PALE_PLAYER = "death.attack.pale.player";

    public static final RegistryKey<DamageType> DRY = register("dry");//干渴伤害
    public static final RegistryKey<DamageType> INSANE = register("insane");//狂乱伤害
    public static final RegistryKey<DamageType> MYSTIC = register("mystic");//神秘伤害
    public static final RegistryKey<DamageType> INDIRECT_MYSTIC = register("indirect_mystic");//间接神秘伤害
    public static final RegistryKey<DamageType> RED = register("red");//物理伤害
    public static final RegistryKey<DamageType> WHITE = register("white");//精神伤害
    public static final RegistryKey<DamageType> BLACK = register("black");//侵蚀伤害
    public static final RegistryKey<DamageType> PALE = register("pale");//灵魂伤害

    private static RegistryKey<DamageType> register(String id) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, LobeCorpUtil.id(id));
    }
}
