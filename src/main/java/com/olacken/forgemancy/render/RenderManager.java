package com.olacken.forgemancy.render;

import com.olacken.forgemancy.init.ModItems;
import com.olacken.forgemancy.render.item.RenderMultitexturedItem;
import net.minecraftforge.client.MinecraftForgeClient;

public class RenderManager {
    public static void initRenders(){
        MinecraftForgeClient.registerItemRenderer(ModItems.ingot, new RenderMultitexturedItem());
        MinecraftForgeClient.registerItemRenderer(ModItems.sword, new RenderMultitexturedItem());
    }
}
