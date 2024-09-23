package net.uniego.aida.lobecorp;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

//常用工具
public class LobeCorpUtil {
    //注册ID
    public static Identifier id(String id) {
        return new Identifier(LobeCorpMain.MOD_ID, id);
    }

    //播放声音
    public static void playSound(PlayerEntity player, SoundEvent soundEvent) {
        player.getWorld().playSound(null, player.getBlockPos(), soundEvent, SoundCategory.PLAYERS, 1, 1);
    }
}
