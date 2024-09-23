package net.uniego.aida.lobecorp.init;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//初始化声音
public class SoundInit {
    public static final Identifier SWALLOW_WATER_ID = LobeCorpUtil.id("swallow_water");

    public static final SoundEvent SWALLOW_WATER = SoundEvent.of(SWALLOW_WATER_ID);//吞水的声音

    public static void register() {
        Registry.register(Registries.SOUND_EVENT, SWALLOW_WATER_ID, SWALLOW_WATER);
    }
}
