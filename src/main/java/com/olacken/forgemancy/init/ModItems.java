package com.olacken.forgemancy.init;

import com.olacken.forgemancy.item.ItemFMBase;
import com.olacken.forgemancy.item.ItemIngot;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

    public static ItemFMBase ingot = new ItemIngot();

    public static void init() {
        GameRegistry.registerItem(ingot, "ingot");

    }
}
