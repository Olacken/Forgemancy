package com.olacken.forgemancy.item;

import com.olacken.forgemancy.api.IMultiTexturedItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

public abstract class ItemAlloy extends ItemFMBase implements IMultiTexturedItem {
    protected IIcon[] itemIcons;


    @Override
    @SideOnly(Side.CLIENT)
    public float[] getColorForRenderPass(ItemStack item, int dmg, int renderPass) {
        NBTTagCompound color = item.stackTagCompound.getCompoundTag("Alloy").getCompoundTag("Color");
        float[] array = new float[4];
        array[0] = color.getFloat("r");
        array[1] = color.getFloat("g");
        array[2] = color.getFloat("b");
        array[3] = 0.5F;
        return array;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int dmg, int renderPass){
        if(renderPass < this.itemIcons.length)
            return this.itemIcons[renderPass];
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getTextureCount() {
        return this.itemIcons.length;
    }
}
