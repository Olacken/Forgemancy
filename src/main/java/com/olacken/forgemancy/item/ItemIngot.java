package com.olacken.forgemancy.item;

import com.olacken.forgemancy.creativeTab.CreativeTabFM;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.Random;

public class ItemIngot extends ItemFMBase {

    private IIcon itemIcon1;

    public ItemIngot() {
        super();
        this.setUnlocalizedName("ingot");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack p_82790_1_, int p_82790_2_) {
        /*
        Random rand = new Random();
        return rand.nextInt(256) + rand.nextInt(256) * 256 + rand.nextInt(256) * 256 * 256;//*/

        return 16777215;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcon = p_94581_1_.registerIcon("minecraft:iron_ingot");
        this.itemIcon1 = p_94581_1_.registerIcon("minecraft:gold_ingot");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int dmg, int renderPass){
        return renderPass == 1 ? this.itemIcon : this.itemIcon1;
    }
}
