package net.uniego.aida.lobecorp;

import net.minecraft.client.model.ModelPart;

import static net.minecraft.util.math.MathHelper.RADIANS_PER_DEGREE;

public class AnimationUtil {
    //旋转模型头部
    public static void rotateHead(float headYaw, float headPitch, ModelPart head) {
        head.yaw = degreeToRadians(headYaw);
        head.pitch = degreeToRadians(headPitch);
    }

    //将角度转换为弧度
    public static float degreeToRadians(float degree) {
        return degree * RADIANS_PER_DEGREE;
    }
}
