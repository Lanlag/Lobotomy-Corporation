package net.uniego.aida.lobecorp.init;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.uniego.aida.lobecorp.event.client.ClientTickEventsEndTickEvent;
import net.uniego.aida.lobecorp.event.client.ClientTickEventsStartTickEvent;
import net.uniego.aida.lobecorp.event.client.HudRenderCallbackEvent;
import net.uniego.aida.lobecorp.event.server.ServerEntityWorldChangeEventsAfterPlayerChangeEvent;

//初始化事件
public class EventInit {
    //注册客户端事件
    public static void registerClientEvents() {
        ClientTickEvents.END_CLIENT_TICK.register(new ClientTickEventsEndTickEvent());
        ClientTickEvents.START_CLIENT_TICK.register(new ClientTickEventsStartTickEvent());
        HudRenderCallback.EVENT.register(new HudRenderCallbackEvent());
    }

    //注册服务端事件
    public static void registerServerEvents() {
        ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register(new ServerEntityWorldChangeEventsAfterPlayerChangeEvent());
    }
}
