package net.uniego.aida.lobecorp.item.ego.weapon.model;

import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

//EGO武器模型
public abstract class EGOWeaponModel extends EntityModel<Entity> {
    public abstract TexturedModelData getTexturedModelData();
}
