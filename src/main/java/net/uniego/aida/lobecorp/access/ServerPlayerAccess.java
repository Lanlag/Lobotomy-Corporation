package net.uniego.aida.lobecorp.access;

import net.uniego.aida.lobecorp.entity.DeadPlayerEntity;

//服务端玩家接口
public interface ServerPlayerAccess {
    //玩家切换维度
    void lobecorp$playerChangeDimension();

    //获取玩家尸体
    DeadPlayerEntity lobecorp$getDeadPlayer();

    //打开工作界面
    void lobecorp$openWorkScreenHandler();

    //打开盒子界面
    void lobecorp$openBoxScreenHandler();
}
