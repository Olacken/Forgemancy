package com.olacken.forgemancy.recipe;

import com.olacken.forgemancy.init.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class AlloyCraftingManager {

    public static void initRecipes()
    {
        addRecipe(new ItemStack(ModItems.sword), new Object[]{" i ", " i ", " s ", 'i', ModItems.ingot, 's', Items.stick});
    }

    public static AlloyShapedRecipe addRecipe(ItemStack result, Object ... data)
    {
        String s = "";
        int i = 0;
        int width = 0;
        int height = 0;

        if (data[i] instanceof String[])
        {
            String[] stringArray = (String[])data[i++];

            for (int l = 0; l < stringArray.length; ++l)
            {
                String s1 = stringArray[l];
                ++height;
                width = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (data[i] instanceof String)
            {
                String s2 = (String)data[i++];
                ++height;
                width = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < data.length; i += 2)
        {
            Character character = (Character)data[i];
            ItemStack itemstack = null;

            if (data[i + 1] instanceof Item)
            {
                itemstack = new ItemStack((Item)data[i + 1]);
            }
            else if (data[i + 1] instanceof Block)
            {
                itemstack = new ItemStack((Block)data[i + 1], 1, 32767);
            }
            else if (data[i + 1] instanceof ItemStack)
            {
                itemstack = (ItemStack)data[i + 1];
            }

            hashmap.put(character, itemstack);
        }

        ItemStack[] itemShape = new ItemStack[width * height];

        for (int i1 = 0; i1 < width * height; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                itemShape[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                itemShape[i1] = null;
            }
        }

        AlloyShapedRecipe shapedRecipe = new AlloyShapedRecipe(itemShape, result);
        GameRegistry.addRecipe(shapedRecipe);
        return shapedRecipe;
    }
}
