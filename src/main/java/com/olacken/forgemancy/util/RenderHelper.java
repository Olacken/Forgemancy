package com.olacken.forgemancy.util;

import com.olacken.forgemancy.render.item.IItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class RenderHelper {
    private static Random random = new Random();

    public static void renderItemIn2D(Tessellator tessellator, float uMin, float vMin, float uMax, float vMax, int width, int height, float scale, boolean render3D) {
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

    public static void renderItemEntity(IItemRenderer itemRenderer, ItemStack item ,EntityItem entity, boolean isOnFrame) {


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

                itemRenderer.doRender(item, true);
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
                itemRenderer.doRender(item, false);
            }
        }

        GL11.glPopMatrix();
    }
}
