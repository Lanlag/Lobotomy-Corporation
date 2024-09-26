package net.uniego.aida.lobecorp.init;

import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.badge.TeamBadge;
import net.uniego.aida.lobecorp.item.ego.EGOItem;

//初始化物品
public class ItemInit {
    public static void register() {
        LobeCorpItem.register();
        EGOItem.register();
        TeamBadge.register();
    }
}
