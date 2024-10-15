package net.uniego.aida.lobecorp.util;

import static net.minecraft.util.math.MathHelper.RADIANS_PER_DEGREE;

public class MathUtil {
    //随机正负
    public static int randomSign() {
        double random = Math.random();
        if (random < 0.5) {
            return -1;
        } else {
            return 1;
        }
    }

    //将角度转换为弧度
    public static float degreeToRadians(float degree) {
        return degree * RADIANS_PER_DEGREE;
    }
}
