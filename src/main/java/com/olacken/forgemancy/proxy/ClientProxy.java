package com.olacken.forgemancy.proxy;

import com.olacken.forgemancy.creativeTab.CreativeTabFM;
import com.olacken.forgemancy.init.ModItems;
import com.olacken.forgemancy.render.item.RenderIngot;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        Items.apple.setCreativeTab(CreativeTabFM.LMRB_TAB);
        initRenderers();

    }

    private void initRenderers()
    {
        MinecraftForgeClient.registerItemRenderer(ModItems.ingot, new RenderIngot());
    }
}
