package net.uniego.aida.lobecorp.util;

public class MathUtil {
    public static int randomSign() {
        double random = Math.random();
        if (random < 0.5) {
            return -1;
        } else {
            return 1;
        }
    }
}
