package net.uniego.aida.lobecorp.init;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//初始化粒子
public class ParticleInit {
    public static final SimpleParticleType GOOD = FabricParticleTypes.simple();
    public static final SimpleParticleType NORMAL = FabricParticleTypes.simple();
    public static final SimpleParticleType BAD = FabricParticleTypes.simple();

    public static void registerServer() {
        Registry.register(Registries.PARTICLE_TYPE, LobeCorpUtil.id("good"), GOOD);
        Registry.register(Registries.PARTICLE_TYPE, LobeCorpUtil.id("normal"), NORMAL);
        Registry.register(Registries.PARTICLE_TYPE, LobeCorpUtil.id("bad"), BAD);
    }

    public static void registerClient() {

    }
}
