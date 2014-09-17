package net.chilimod.mod.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.chilimod.mod.ChiliMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class FlightRingActive extends Item
{
	public FlightRingActive(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setMaxDamage(20);
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		ItemStack qwe = new ItemStack(ChiliMod.CMFlightRing);
		qwe.setItemDamage(par1ItemStack.getItemDamage());
		par3EntityPlayer.capabilities.isFlying = false;
		par3EntityPlayer.fallDistance = 0F;
		par3EntityPlayer.sendPlayerAbilities();
		if(par2World.isRemote)
		{
			ChiliMod.proxy.printMessageToPlayer("Chili Flight Disabled");
		}
		if(ChiliMod.enableSpecialChiliSounds){
			par2World.playSoundAtEntity(par3EntityPlayer, "ChiliMod:disableSpecialChili", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		}
		return qwe;
	}
		
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ChiliMod.modid + ":" + ChiliMod.CMFlightRing.getUnlocalizedName().substring(5));
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add(EnumChatFormatting.AQUA + "Enabled");
	}
}
