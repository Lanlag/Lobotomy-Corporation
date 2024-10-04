package net.uniego.aida.lobecorp.init;

import net.uniego.aida.lobecorp.network.handle.*;

//初始化网络
public class NetworkInit {
    //注册客户端数据包处理
    public static void registerClient() {
        SwingHandHandle.receive();
        SyncAbnormalityHandle.receive();
        SyncEquipmentHandle.receive();
        SyncIconHandle.receive();
        SyncOffsetHandle.receive();
    }

    //注册服务端数据包处理
    public static void registerServer() {
        BeginWorkHandle.receive();
        DrinkWaterHandle.receive();
        OpenCloseHandle.receive();
        OpenWorkHandle.receive();
        SwitchWeaponHandle.receive();
    }
}
