package net.uniego.aida.lobecorp.util;

import net.minecraft.client.model.ModelPart;

public class AnimationUtil {
    //旋转模型头部
    public static void rotateHead(float headYaw, float headPitch, ModelPart head) {
        head.yaw = MathUtil.degreeToRadians(headYaw);
        head.pitch = MathUtil.degreeToRadians(headPitch);
    }
}
