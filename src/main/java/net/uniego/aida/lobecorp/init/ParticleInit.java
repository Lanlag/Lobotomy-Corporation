package net.uniego.aida.lobecorp.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.uniego.aida.lobecorp.particle.SpurtBloodParticle;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;
import org.jetbrains.annotations.Nullable;

//初始化粒子
public class ParticleInit {
    public static final SimpleParticleType GOOD = FabricParticleTypes.simple();
    public static final SimpleParticleType NORMAL = FabricParticleTypes.simple();
    public static final SimpleParticleType BAD = FabricParticleTypes.simple();
    public static final SimpleParticleType SPURT_BLOOD = FabricParticleTypes.simple();

    public static void registerServer() {
        Registry.register(Registries.PARTICLE_TYPE, LobeCorpUtil.id("good"), GOOD);
        Registry.register(Registries.PARTICLE_TYPE, LobeCorpUtil.id("normal"), NORMAL);
        Registry.register(Registries.PARTICLE_TYPE, LobeCorpUtil.id("bad"), BAD);
        Registry.register(Registries.PARTICLE_TYPE, LobeCorpUtil.id("spurt_blood"), SPURT_BLOOD);
    }

    public static void registerClient() {
        ParticleFactoryRegistry.getInstance().register(GOOD, WorkResultParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(NORMAL, WorkResultParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(BAD, WorkResultParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SPURT_BLOOD, SpurtBloodParticle.Factory::new);
    }

    //工作结果粒子
    @Environment(EnvType.CLIENT)
    public static class WorkResultParticle extends SpriteBillboardParticle {

        public WorkResultParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
            super(world, x, y, z, velocityX, velocityY, velocityZ);
            setSprite(spriteProvider);
            setMaxAge(10);
            scale(2.0F);
        }

        @Override
        public ParticleTextureSheet getType() {
            return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
        }

        @Environment(EnvType.CLIENT)
        public static class Factory implements ParticleFactory<SimpleParticleType> {
            private final SpriteProvider spriteProvider;

            public Factory(SpriteProvider spriteProvider) {
                this.spriteProvider = spriteProvider;
            }

            @Nullable
            @Override
            public Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
                return new WorkResultParticle(world, x, y, z, velocityX, velocityY, velocityZ, spriteProvider);
            }
        }
    }
}
