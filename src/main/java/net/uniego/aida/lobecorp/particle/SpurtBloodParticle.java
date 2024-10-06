package net.uniego.aida.lobecorp.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.uniego.aida.lobecorp.util.MathUtil;

public class SpurtBloodParticle extends SpriteBillboardParticle {
    SpurtBloodParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
        super(clientWorld, d, e, f);
        this.gravityStrength = 0.04F;
        this.velocityX = g * MathUtil.randomSign();
        this.velocityY = h;
        this.velocityZ = i * MathUtil.randomSign();
        this.setBoundingBoxSpacing(0.01F, 0.01F);
        this.gravityStrength = 0.07F;
        this.maxAge = (int) (8.0 / (Math.random() * 0.8 + 0.2));
        float dk = 1F - (float) Math.random() * 0.6F;

        this.setColor(dk, dk, dk);
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age < this.maxAge) {
            this.age++;
        }
        if (this.maxAge-- <= 0) {
            this.markDead();
        } else {
            this.velocityY -= this.gravityStrength;
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            this.velocityX *= 0.9800000190734863;
            this.velocityY *= 0.9800000190734863;
            this.velocityZ *= 0.9800000190734863;
            if (this.onGround) {
                if (Math.random() < 0.25) {
                    this.markDead();
                }
                this.velocityX *= 0.699999988079071;
                this.velocityZ *= 0.699999988079071;
            }
        }
        setAlpha(1.0F - (float) this.age / (float) this.maxAge);
        scale(1.0F - (float) this.age / ((float) this.maxAge * 4));
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

        public Particle createParticle(SimpleParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            SpurtBloodParticle spurtBloodParticle = new SpurtBloodParticle(clientWorld, d, e, f, g, h, i);
            spurtBloodParticle.setSprite(this.spriteProvider);
            return spurtBloodParticle;
        }
    }
}
