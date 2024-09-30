package net.uniego.aida.lobecorp.access;

import net.uniego.aida.lobecorp.manager.LevelManager;

//装备要求接口
public interface EquipRequireAccess {
    LevelManager.LobeCorpLevel getFortitudeRequire();//获取勇气要求

    LevelManager.LobeCorpLevel getPrudenceRequire();//获取谨慎要求

    LevelManager.LobeCorpLevel getTemperanceRequire();//获取自律要求

    LevelManager.LobeCorpLevel getJusticeRequire();//获取正义要求

    LevelManager.LobeCorpLevel getTotalRequire();//获取总要求
}
