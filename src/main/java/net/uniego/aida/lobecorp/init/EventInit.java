package net.uniego.aida.lobecorp.init;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.uniego.aida.lobecorp.event.HudRenderCallbackEvent;

//初始化事件
public class EventInit {
    //注册客户端事件
    public static void registerClientEvents() {
        HudRenderCallback.EVENT.register(new HudRenderCallbackEvent());
    }

    //注册服务端事件
    public static void registerServerEvents() {

    }
}
