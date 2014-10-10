package com.olacken.forgemancy.util;

import com.olacken.forgemancy.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

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






}

