package net.uniego.aida.lobecorp.item.ego;

import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.ego.gift.EGOGift;

//EGO物品
public class EGOItem extends LobeCorpItem {
    public EGOItem(Settings settings) {
        super(settings.maxCount(1).fireproof());
    }

    public static void register() {
        EGOGift.register();
    }
}
