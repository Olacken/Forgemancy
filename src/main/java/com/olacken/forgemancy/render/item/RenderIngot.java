package com.olacken.forgemancy.render.item;

import com.olacken.forgemancy.util.RenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class RenderIngot implements IItemRenderer {

    private static Random random = new Random();
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch(type) {
            case ENTITY : {
                EntityItem entity = (EntityItem)data[1];
                RenderHelper.renderItemEntity(this, item, entity, item.isOnItemFrame());
                break;
            }
            case EQUIPPED : {
                doRender(item, true);
                break;
            }
            case EQUIPPED_FIRST_PERSON : {
                    doRender(item, true);
                break;
            }
            default :{
                GL11.glPushMatrix();
                    GL11.glScaled(-16.0f, -16.0f, 0.0f);
                    GL11.glTranslatef(-1.0f, -1.0f, 0.0f);
                    doRender(item, true);
                GL11.glPopMatrix();
                break;}
        }


    }

    @Override
    public void doRender(ItemStack item, boolean isOn3D) {
        IIcon icon = item.getItem().getIconFromDamageForRenderPass(0, 1);
        float uMin = icon.getMinU();
        float vMin = icon.getMinV();
        float uMax = icon.getMaxU();
        float vMax = icon.getMaxV();
        float scale = 1f / 16f;
        Random rand = new Random();
        IIcon icon1 = item.getItem().getIconFromDamageForRenderPass(0, 2);
        float uMin1 = icon1.getMinU();
        float vMin1 = icon1.getMinV();
        float uMax1 = icon1.getMaxU();
        float vMax1 = icon1.getMaxV();
        NBTTagCompound color = item.stackTagCompound.getCompoundTag("Alloy").getCompoundTag("Color");
        GL11.glPushMatrix();

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
            GL11.glScalef(0.75f,1.0f,1.0f);
            GL11.glTranslatef(1f/3f, 0.0f, 0.0f);
            GL11.glColor4f(color.getFloat("r"),color.getFloat("g"),color.getFloat("b"),0.5f);
            RenderHelper.renderItemIn2D(Tessellator.instance, uMax - (uMax - uMin)*1/4, vMin, uMin, vMax, icon.getIconWidth(), icon.getIconHeight(), scale, isOn3D);

            GL11.glColor4f(1f,1f,1f,1f);
            GL11.glScalef(1f/3f,1.0f,1.0f);
            GL11.glTranslatef(-1.0f, 0.0f, 0.0f);
            RenderHelper.renderItemIn2D(Tessellator.instance, uMax1, vMin1, uMin1 + (uMax1 - uMin1)*3/4, vMax1, icon1.getIconWidth(), icon1.getIconHeight(), scale, isOn3D);
        GL11.glColorMask(true,true,true,true);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
