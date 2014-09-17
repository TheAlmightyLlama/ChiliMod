package net.chilimod.mod.items;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.chilimod.mod.ChiliMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ChiliFoods extends ItemFood
{
	public ChiliFoods(int id, int par2, float f, boolean par3) {
		super(id, par2, par3);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ChiliMod.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		--par1ItemStack.stackSize;
        par3EntityPlayer.getFoodStats().addStats(this);
        Random rand = new Random();
	    int randomNum = rand.nextInt((20 - 1) + 1) + 1;
	    if(randomNum <= 5)
	    {
	    	par2World.playSoundAtEntity(par3EntityPlayer, "ChiliMod:fart", 0.8F, par2World.rand.nextFloat() * 0.1F + 0.9F);
	    }
	    else
	    {
	    	par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.8F, par2World.rand.nextFloat() * 0.1F + 0.9F);
	    }
		this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
		return par1ItemStack;
	}
}
