package com.olacken.forgemancy.recipe;

import com.olacken.forgemancy.api.AlloyData;
import com.olacken.forgemancy.util.AlloyUtils;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class AlloyShapedRecipe implements IRecipe {

    private ItemStack[] recipe;
    private ItemStack result;

    public AlloyShapedRecipe(ItemStack[] recipe,ItemStack result)
    {
        this.recipe = recipe;
        this.result = result;

    }


    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        AlloyData data = null;
        for(int i=0; i < inventoryCrafting.getSizeInventory(); i++){
            if(inventoryCrafting.getStackInSlot(i) != null && recipe[i] !=null) {
                if (data == null)
                    data = AlloyUtils.getDataFromItemStack(inventoryCrafting.getStackInSlot(i));
                else if (AlloyUtils.getDataFromItemStack(inventoryCrafting.getStackInSlot(i)) != null &&
                        !data.equals(AlloyUtils.getDataFromItemStack(inventoryCrafting.getStackInSlot(i))))
                    return false;
                if (recipe[i].getItem() != inventoryCrafting.getStackInSlot(i).getItem())
                    return false;
            }
            else if (inventoryCrafting.getStackInSlot(i) == null && recipe[i] == null);
            else
            return false;
        }
        data.setNBTData(result);
        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting p_77572_1_) {
        return result.copy();
    }

    @Override
    public int getRecipeSize() {
        return this.recipe.length;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return result;
    }
}
