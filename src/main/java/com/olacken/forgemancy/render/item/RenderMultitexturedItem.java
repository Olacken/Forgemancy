package com.olacken.forgemancy.render.item;

import com.olacken.forgemancy.api.IMultiTexturedItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class RenderMultitexturedItem implements net.minecraftforge.client.IItemRenderer {

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
                renderItemEntity(item, item.getItemDamage(), entity, item.isOnItemFrame());
                break;
            }
            case EQUIPPED : {
                doRender(item,item.getItemDamage(), true);
                break;
            }
            case EQUIPPED_FIRST_PERSON : {
                doRender(item,item.getItemDamage(), true);
                break;
            }
            default :{
                GL11.glPushMatrix();
                GL11.glScaled(-16.0f, -16.0f, 0.0f);
                GL11.glTranslatef(-1.0f, -1.0f, 0.0f);
                doRender(item,item.getItemDamage(), true);
                GL11.glPopMatrix();
                break;}
        }


    }


    public void doRender(ItemStack item,int dmg, boolean isOn3D) {



        IMultiTexturedItem item1 = (IMultiTexturedItem)item.getItem();

        float scale = 1f / 16f;

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);

        for(int i = 0; i < item1.getTextureCount(); i++){
            IIcon icon = item.getItem().getIconFromDamageForRenderPass(0, i);
            float uMin = icon.getMinU();
            float vMin = icon.getMinV();
            float uMax = icon.getMaxU();
            float vMax = icon.getMaxV();
            float[] color = {1.0F,1.0F,1.0F,1.0F};
            switch (item1.getSpecialRenderForRenderPass(dmg, i)){
                case COLORED:
                    color = item1.getColorForRenderPass(item, dmg, i);
                    break;
                default:
            }
            GL11.glColor4f(color[0],color[1],color[2],color[3]);
           renderItemIn2D(Tessellator.instance, uMax, vMin, uMin, vMax, icon.getIconWidth(), icon.getIconHeight(), scale, isOn3D);

        }
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

    public void renderItemIn2D(Tessellator tessellator, float uMin, float vMin, float uMax, float vMax, int width, int height, float scale, boolean render3D) {
        if(render3D){
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, (double) uMin, (double) vMax);
            tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, (double) uMax, (double) vMax);
            tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, (double) uMax, (double) vMin);
            tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, (double) uMin, (double) vMin);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, -1.0F);
            tessellator.addVertexWithUV(0.0D, 1.0D, (double) (0.0F - scale), (double) uMin, (double) vMin);
            tessellator.addVertexWithUV(1.0D, 1.0D, (double) (0.0F - scale), (double) uMax, (double) vMin);
            tessellator.addVertexWithUV(1.0D, 0.0D, (double) (0.0F - scale), (double) uMax, (double) vMax);
            tessellator.addVertexWithUV(0.0D, 0.0D, (double) (0.0F - scale), (double) uMin, (double) vMax);
            tessellator.draw();
            float f5 = 0.5F * (uMin - uMax) / (float) width;
            float f6 = 0.5F * (vMax - vMin) / (float) height;
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0F, 0.0F, 0.0F);
            int k;
            float f7;
            float f8;

            for (k = 0; k < width; ++k) {
                f7 = (float) k / (float) width;
                f8 = uMin + (uMax - uMin) * f7 - f5;
                tessellator.addVertexWithUV((double) f7, 0.0D, (double) (0.0F - scale), (double) f8, (double) vMax);
                tessellator.addVertexWithUV((double) f7, 0.0D, 0.0D, (double) f8, (double) vMax);
                tessellator.addVertexWithUV((double) f7, 1.0D, 0.0D, (double) f8, (double) vMin);
                tessellator.addVertexWithUV((double) f7, 1.0D, (double) (0.0F - scale), (double) f8, (double) vMin);
            }

            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0F, 0.0F, 0.0F);
            float f9;

            for (k = 0; k < width; ++k) {
                f7 = (float) k / (float) width;
                f8 = uMin + (uMax - uMin) * f7 - f5;
                f9 = f7 + 1.0F / (float) width;
                tessellator.addVertexWithUV((double) f9, 1.0D, (double) (0.0F - scale), (double) f8, (double) vMin);
                tessellator.addVertexWithUV((double) f9, 1.0D, 0.0D, (double) f8, (double) vMin);
                tessellator.addVertexWithUV((double) f9, 0.0D, 0.0D, (double) f8, (double) vMax);
                tessellator.addVertexWithUV((double) f9, 0.0D, (double) (0.0F - scale), (double) f8, (double) vMax);
            }

            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);

            for (k = 0; k < height; ++k) {
                f7 = (float) k / (float) height;
                f8 = vMax + (vMin - vMax) * f7 - f6;
                f9 = f7 + 1.0F / (float) height;
                tessellator.addVertexWithUV(0.0D, (double) f9, 0.0D, (double) uMin, (double) f8);
                tessellator.addVertexWithUV(1.0D, (double) f9, 0.0D, (double) uMax, (double) f8);
                tessellator.addVertexWithUV(1.0D, (double) f9, (double) (0.0F - scale), (double) uMax, (double) f8);
                tessellator.addVertexWithUV(0.0D, (double) f9, (double) (0.0F - scale), (double) uMin, (double) f8);
            }

            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1.0F, 0.0F);

            for (k = 0; k < height; ++k) {
                f7 = (float) k / (float) height;
                f8 = vMax + (vMin - vMax) * f7 - f6;
                tessellator.addVertexWithUV(1.0D, (double) f7, 0.0D, (double) uMax, (double) f8);
                tessellator.addVertexWithUV(0.0D, (double) f7, 0.0D, (double) uMin, (double) f8);
                tessellator.addVertexWithUV(0.0D, (double) f7, (double) (0.0F - scale), (double) uMin, (double) f8);
                tessellator.addVertexWithUV(1.0D, (double) f7, (double) (0.0F - scale), (double) uMax, (double) f8);
            }

            tessellator.draw();
        }
        else {

            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            tessellator.addVertexWithUV(-0.5d, -0.25d, 0.0D, (double) uMin, (double) vMin);
            tessellator.addVertexWithUV(0.5d, -0.25d, 0.0D, (double) uMax, (double) vMin);
            tessellator.addVertexWithUV(0.5d, 0.75d, 0.0D, (double) uMax, (double) vMax);
            tessellator.addVertexWithUV(-0.5d, 0.75d, 0.0D, (double) uMin, (double) vMax);
            tessellator.draw();
        }
    }

    public void renderItemEntity(ItemStack item, int dmg, EntityItem entity, boolean isOnFrame) {


        GL11.glPushMatrix();
        random.setSeed(-769121950383L);


        int j = item.stackSize;
        byte b0;

        if (j < 2) {
            b0 = 1;
        } else if (j < 16) {
            b0 = 2;
        } else if (j < 32) {
            b0 = 3;
        } else {
            b0 = 4;
        }
        if(Minecraft.isFancyGraphicsEnabled()) {
            if (isOnFrame) {
                GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            } else {
                GL11.glRotatef((((float) entity.age) / 20.0F + entity.hoverStart) * (180F / (float) Math.PI), 0.0F, 1.0F, 0.0F);
            }

            GL11.glTranslatef(-0.5F, -0.125F, -(0.084375F * (float) b0 / 2.0F));

            for (int k = 0; k < b0; ++k) {
                if (k > 0) {
                    float x = (random.nextFloat() * 2.0F - 1.0F) * 0.3F / 0.5F;
                    float y = (random.nextFloat() * 2.0F - 1.0F) * 0.3F / 0.5F;
                    GL11.glTranslatef(x, y, 0.084375F);
                } else {
                    GL11.glTranslatef(0F, 0F, 0.084375F);
                }

                doRender(item, dmg, true);
            }
        }
        else
        {

            GL11.glTranslatef(0.25F,0.64F,0.0F);

            if (!isOnFrame)
            {
                GL11.glRotatef(180.0F - RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);
            }
            GL11.glScalef(-1.0F,-1.0F,1.0F);

            for (int l = 0; l < b0; ++l)
            {

                if (l > 0)
                {
                    float f10 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    float f16 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    float f17 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    GL11.glTranslatef(f10, f16, f17);
                }
                doRender(item, dmg, false);
            }
        }

        GL11.glPopMatrix();
    }
}
