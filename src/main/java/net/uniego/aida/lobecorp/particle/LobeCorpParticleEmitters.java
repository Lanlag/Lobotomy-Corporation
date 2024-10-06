package net.uniego.aida.lobecorp.particle;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.uniego.aida.lobecorp.init.ParticleInit;

public class LobeCorpParticleEmitters {
    public static void spurtBloodParticle(Entity entity,int time,float range){
        for (int i = 0;i<time;i++){
            float f = (float)entity.getY();
            float g = (float)(Math.random() * 2.0F - 1.0F) * entity.getWidth() * 0.5F;
            float h = (float)(Math.random() * 2.0F - 1.0F) * entity.getWidth() * 0.5F;
            Vec3d vec3d = new Vec3d((Math.random() - 0.5F) * range,(Math.random() + 0.5F) * range,(Math.random() - 0.5F) * range);
            entity.getWorld().addParticle(ParticleInit.SPURT_BLOOD, entity.getX() + (double)g, (f + entity.getHeight()/2), entity.getZ() + (double)h, vec3d.x, vec3d.y, vec3d.z);
        }
    }
}
