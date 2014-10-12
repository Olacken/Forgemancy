package com.olacken.forgemancy.init;

import com.olacken.forgemancy.item.ItemFMBase;
import com.olacken.forgemancy.item.ItemIngot;
import com.olacken.forgemancy.item.ItemSword;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {

    public static ItemFMBase ingot = new ItemIngot();
    public static Item sword = new ItemSword();

    public static void initItems() {
        GameRegistry.registerItem(ingot, "ingot");
        GameRegistry.registerItem(sword, "sword");

    }
}
