package com.olacken.forgemancy.item;

import com.olacken.forgemancy.creativeTab.CreativeTabFM;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.Random;

public class ItemIngot extends ItemFMBase {

    public ItemIngot() {
        super();
        this.setUnlocalizedName("ingot");
        this.setCreativeTab(CreativeTabFM.LMRB_TAB);
    }

    private static int convertRGB(int r, int g, int b) {
        return r << 16 + g << 8 + b;
    }

    @Override
    public IIcon getIcon(ItemStack stack, int pass) {
        return super.getIcon(stack, pass);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack p_82790_1_, int p_82790_2_) {
        Random rand = new Random();
        return rand.nextInt(256) + rand.nextInt(256) * 256 + rand.nextInt(256) * 256 * 256;
    }

    @Override
    protected String getIconString() {
        return super.getIconString();
    }


}
