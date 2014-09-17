package net.chilimod.mod.items;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.chilimod.mod.ChiliMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class BanishRainChili extends Item
{
	public BanishRainChili(int id)
	{
		super(id);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(!par2World.isRemote)
		{
			int i = (300 + (new Random()).nextInt(600)) * 20;
			
			WorldInfo worldinfo = par3EntityPlayer.worldObj.getWorldInfo();
			worldinfo.setRaining(false);
		    worldinfo.setThundering(false);
		    worldinfo.setRainTime(i);
	        worldinfo.setThunderTime(i);
	        if(ChiliMod.enableSpecialChiliSounds){
	        	par2World.playSoundAtEntity(par3EntityPlayer, "ChiliMod:activateSpecialChili", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
	        }
		}
		par1ItemStack.stackSize -= 1;
		return par1ItemStack;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ChiliMod.modid + ":" + ChiliMod.BanishRainChili.getUnlocalizedName().substring(5));
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add(EnumChatFormatting.AQUA + "Banish's The Rain");
	}

}
