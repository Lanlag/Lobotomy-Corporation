package net.uniego.aida.lobecorp.access;

import net.uniego.aida.lobecorp.manager.SanityManager;
import net.uniego.aida.lobecorp.manager.ThirstManager;

//机制接口
public interface ManagerAccess {
    //获取精神机制
    SanityManager cogito$getSanityManager();

    //获取干渴机制
    ThirstManager cogito$getThirstManager();
}
