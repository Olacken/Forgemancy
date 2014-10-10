package com.olacken.forgemancy.render.item;

import net.minecraft.item.ItemStack;

public interface IItemRenderer extends net.minecraftforge.client.IItemRenderer {
    public void doRender(ItemStack item, boolean isOn3D);
}
