package net.chilimod.mod.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.chilimod.mod.ChiliMod;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class TeaPlant extends BlockCrops
{
	public TeaPlant(int id) {
		super(id);
	}

	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.iconArray = new Icon[4];
		
		for (int i = 0; i < this.iconArray.length; i++)
		{
			this.iconArray[i] = iconRegister.registerIcon(ChiliMod.modid + ":" + this.getUnlocalizedName().substring(5) + (i+1));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		if(metadata < 7)
		{
			if(metadata == 6)
			{
				metadata = 5;
			}
			return iconArray[metadata >> 1];
		}
		return iconArray[3];
	}
	
	public int getSeedItem()
	{
		return ChiliMod.cSeedsTea.itemID;
	}
	
	public int getCropItem()
	{
		return ChiliMod.TeaLeaf.itemID;
	}
	
	public int quantityDropped(Random par1Random)
    {
		Random rand = new Random();
	    int randomNum = rand.nextInt((3 - 1) + 1) + 1;
	    return randomNum;
    }
	
}
