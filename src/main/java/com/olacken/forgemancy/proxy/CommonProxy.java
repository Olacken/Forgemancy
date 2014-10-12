package com.olacken.forgemancy.proxy;

import com.olacken.forgemancy.handler.ConfigurationHandler;
import com.olacken.forgemancy.init.ModBlocks;
import com.olacken.forgemancy.init.ModItems;
import com.olacken.forgemancy.recipe.AlloyCraftingManager;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy implements IProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationHandler.initConfigs(event.getSuggestedConfigurationFile());
        ModItems.initItems();
        ModBlocks.initBlocks();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        AlloyCraftingManager.initRecipes();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
