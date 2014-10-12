package com.olacken.forgemancy.creativeTab;

import com.olacken.forgemancy.api.AlloyData;
import com.olacken.forgemancy.init.ModItems;
import com.olacken.forgemancy.reference.Reference;
import com.olacken.forgemancy.util.AlloyUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class CreativeTabsFM {
    public static CreativeTabs ALLOY_INGOT_TAB;

    public static void initCreaTabs(){

        ALLOY_INGOT_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {

            @Override
            public ItemStack getIconItemStack() {
                ItemStack item = new ItemStack(ModItems.ingot);
                new AlloyData(1f/3f,1f/3f,1f/3f,1f,1f,1f,1f).setNBTData(item);
                return item;
            }

            @Override
            public Item getTabIconItem() {
                return null;
            }

            @Override
            public void displayAllReleventItems(List p_78018_1_) {
                super.displayAllReleventItems(p_78018_1_);
                AlloyUtils.addAllIngots(p_78018_1_);
            }
        };


    }
}
