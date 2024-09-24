package net.uniego.aida.lobecorp.init;

import net.uniego.aida.lobecorp.network.handle.*;

//初始化网络
public class NetworkInit {
    //注册客户端数据包处理
    public static void registerClient() {
        SwingHandHandle.receive();
        SyncEquipmentHandle.receive();
        SyncIconHandle.receive();
        SyncOffsetHandle.receive();
    }

    //注册服务端数据包处理
    public static void registerServer() {
        DrinkWaterHandle.receive();
        OpenCloseHandle.receive();
    }
}
