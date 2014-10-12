package com.olacken.forgemancy.item;

import com.olacken.forgemancy.api.SpecialRender;
import com.olacken.forgemancy.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemSword extends ItemAlloy
{

    public ItemSword()
    {
        super();
        this.setUnlocalizedName("sword");
        this.setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcons = new IIcon[2];
        this.itemIcons[0] = iconRegister.registerIcon(Reference.TEXTURE_PREFIX + "sword0");
        this.itemIcons[1] = iconRegister.registerIcon(Reference.TEXTURE_PREFIX + "sword1");
    }
    @Override
    public SpecialRender getSpecialRenderForRenderPass(int dmg, int renderPass) {
        return renderPass == 1 ? SpecialRender.COLORED: SpecialRender.DEFAULT;
    }

    @Override
    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_) {
        return super.hitEntity(p_77644_1_, p_77644_2_, p_77644_3_);
    }
}
