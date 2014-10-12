package com.olacken.forgemancy.util;

import com.olacken.forgemancy.api.AlloyData;
import com.olacken.forgemancy.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;
import java.util.Random;

public class AlloyUtils {
    public static void addAllIngots(List<ItemStack> result){
        Random rand = new Random(1234535L);
        ItemStack item = new ItemStack(ModItems.ingot);
        new AlloyData(1f/3f,1f/3f,1f/3f,1f,1f,1f,1f).setNBTData(item);
        result.add(item);
        for(int i=0;i<127;i++){
            item = new ItemStack(ModItems.ingot);
            new AlloyData(1f/3f,1f/3f,1f/3f,1f,rand.nextFloat(),rand.nextFloat(),rand.nextFloat()).setNBTData(item);
            result.add(item);

        }
    }

    public static AlloyData getDataFromItemStack(ItemStack item)
    {
        if(item.hasTagCompound() && item.stackTagCompound.hasKey("Alloy")) {
            NBTTagCompound ability = item.stackTagCompound.getCompoundTag("Alloy").getCompoundTag("Ability");
            NBTTagCompound color = item.stackTagCompound.getCompoundTag("Alloy").getCompoundTag("Color");


            return new AlloyData(ability.getFloat("catalysts"),ability.getFloat("resistance"),ability.getFloat("strength")
                    ,ability.getFloat("pureness"),color.getFloat("r"),color.getFloat("g"),color.getFloat("b"));
        }

        return null;
    }






}

