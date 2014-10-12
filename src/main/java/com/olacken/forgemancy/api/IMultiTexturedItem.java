package com.olacken.forgemancy.api;

import net.minecraft.item.ItemStack;

public interface IMultiTexturedItem {

    public int getTextureCount();

    public SpecialRender getSpecialRenderForRenderPass(int dmg,int renderPass);

    public float[] getColorForRenderPass(ItemStack item, int dmg, int renderPass);

}
