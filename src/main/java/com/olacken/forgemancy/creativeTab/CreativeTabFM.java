package com.olacken.forgemancy.creativeTab;

import com.olacken.forgemancy.init.ModItems;
import com.olacken.forgemancy.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabFM {
    public static final CreativeTabs LMRB_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return ModItems.ingot;
        }
    };
}
