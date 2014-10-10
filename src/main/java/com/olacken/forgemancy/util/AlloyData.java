package com.olacken.forgemancy.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class AlloyData {
    private float catalysts;
    private float resistance;
    private float strength;

    private float pureness;

    private float red;
    private float green;
    private float blue;

    //private List<> effects;

    public AlloyData(float cata, float resist, float stren, float pure, float r, float g, float b) {
        this.catalysts = cata;
        this.resistance = resist;
        this.strength = stren;

        this.pureness = pure;

        this.red = r;
        this.green = g;
        this.blue = b;

    }

    private boolean setAbility(float cata, float resist, float stren,float pure) {
        if (cata + resist + stren == 1.0f) {
            this.catalysts = cata;
            this.resistance = resist;
            this.strength = stren;
            this.pureness = pure;
            return true;
        }
        return false;
    }

    public void setNBTData(ItemStack itemstack)
    {

        NBTTagCompound compoundAbility = new NBTTagCompound();
        NBTTagList list = new NBTTagList();
        compoundAbility.setFloat("catalysts",this.catalysts);
        compoundAbility.setFloat("resistance",this.resistance);
        compoundAbility.setFloat("strength",this.strength);
        compoundAbility.setFloat("pureness",this.pureness);

        NBTTagCompound compoundColor = new NBTTagCompound();
        compoundColor.setFloat("r",this.red);
        compoundColor.setFloat("b",this.blue);
        compoundColor.setFloat("g",this.green);

        NBTTagCompound mainCompound = new NBTTagCompound();
        mainCompound.setTag("Ability",compoundAbility);
        mainCompound.setTag("Color",compoundColor);





        if(itemstack.stackTagCompound == null)
            itemstack.stackTagCompound = new NBTTagCompound();

        itemstack.stackTagCompound.setTag("Alloy",mainCompound);
    }


    public static AlloyData mixAlloy(AlloyData al1, float am1, AlloyData al2, float am2){
        float cata = (al1.catalysts*am1+al2.catalysts*am2)/(am1+am2);
        float resist = (al1.resistance*am1+al2.resistance*am2)/(am1+am2);
        float stren = (al1.strength*am1+al2.strength*am2)/(am1+am2);
        float pure = (al1.pureness*am1+al2.pureness*am2)/(am1+am2);
        float r = (al1.red*am1+al2.red*am2)/(am1+am2);
        float g = (al1.blue*am1+al2.blue*am2)/(am1+am2);
        float b = (al1.green*am1+al2.green*am2)/(am1+am2);

        return new AlloyData(cata, resist, stren, pure, r, g, b);
    }
}
