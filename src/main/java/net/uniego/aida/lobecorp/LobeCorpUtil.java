package net.uniego.aida.lobecorp;

import net.minecraft.util.Identifier;

//常用工具
public class LobeCorpUtil {
    public static Identifier id(String path) {
        return new Identifier(LobeCorpMain.MOD_ID, path);
    }
}
