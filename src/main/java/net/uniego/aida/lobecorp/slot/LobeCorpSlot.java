package net.uniego.aida.lobecorp.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.screen.slot.Slot;

//脑叶公司插槽
public class LobeCorpSlot extends Slot {
    private boolean enabled;//启用状态

    public LobeCorpSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
