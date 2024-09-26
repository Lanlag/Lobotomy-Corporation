package net.uniego.aida.lobecorp.init;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//初始化声音
public class SoundInit {
    public static final Identifier SWALLOW_WATER_ID = LobeCorpUtil.id("sound.swallow_water");
    public static final Identifier SWITCH_WEAPON_ID = LobeCorpUtil.id("sound.switch_weapon");

    public static final SoundEvent SWALLOW_WATER = SoundEvent.of(SWALLOW_WATER_ID);//吞水的声音
    public static final SoundEvent SWITCH_WEAPON = SoundEvent.of(SWITCH_WEAPON_ID);//切换武器的声音

    public static void register() {
        Registry.register(Registries.SOUND_EVENT, SWALLOW_WATER_ID, SWALLOW_WATER);
        Registry.register(Registries.SOUND_EVENT, SWITCH_WEAPON_ID, SWITCH_WEAPON);
    }
}
