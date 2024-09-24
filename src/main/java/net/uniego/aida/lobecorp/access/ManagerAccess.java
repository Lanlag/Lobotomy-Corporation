package net.uniego.aida.lobecorp.access;

import net.uniego.aida.lobecorp.manager.LevelManager;
import net.uniego.aida.lobecorp.manager.SanityManager;
import net.uniego.aida.lobecorp.manager.ThirstManager;

//机制接口
public interface ManagerAccess {
    //获取精神机制
    SanityManager lobecorp$getSanityManager();

    //获取干渴机制
    ThirstManager lobecorp$getThirstManager();

    //获取等级机制
    LevelManager lobecorp$getLevelManager();
}
