package com.olacken.forgemancy.item;

import com.olacken.forgemancy.api.SpecialRender;
import com.olacken.forgemancy.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class ItemIngot extends ItemAlloy{


    public ItemIngot() {
        super();
        this.setUnlocalizedName("ingot");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcons = new IIcon[2];
        this.itemIcons[0] = p_94581_1_.registerIcon(Reference.TEXTURE_PREFIX + "ingot0");
        this.itemIcons[1] = p_94581_1_.registerIcon(Reference.TEXTURE_PREFIX + "ingot1");
    }
    @Override
    @SideOnly(Side.CLIENT)
    public SpecialRender getSpecialRenderForRenderPass(int dmg, int renderPass) {
        return renderPass == 0 ? SpecialRender.COLORED: SpecialRender.DEFAULT;
    }
}
