package net.chilimod.mod.items;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.chilimod.mod.ChiliMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class InstantHealChili extends Item
{
	public InstantHealChili(int id) {
		super(id);
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.setHealth(20F);
	    par1ItemStack.stackSize -= 1;
	    if(ChiliMod.enableSpecialChiliSounds){
	    	par2World.playSoundAtEntity(par3EntityPlayer, "ChiliMod:activateSpecialChili", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
	    }
	    return par1ItemStack;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ChiliMod.modid + ":" + ChiliMod.InstantHealChili.getUnlocalizedName().substring(5));
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add(EnumChatFormatting.AQUA + "Instant Heals Player To 10 Hearts");
	}
}
