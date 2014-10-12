package com.olacken.forgemancy.proxy;

import com.olacken.forgemancy.creativeTab.CreativeTabsFM;
import com.olacken.forgemancy.render.RenderManager;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        CreativeTabsFM.initCreaTabs();
        RenderManager.initRenders();

    }
}
