package net.chilimod.mod.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.chilimod.mod.ChiliMod;
import net.chilimod.mod.ServerTickHandler;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class FlightRing extends Item
{
	public FlightRing(int id) {
		super(id);
		this.setMaxDamage(20);
		this.setMaxStackSize(1);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		ItemStack cvb = new ItemStack(ChiliMod.CMFlightRingActive);
		cvb.setItemDamage(par1ItemStack.getItemDamage());
		if(par3EntityPlayer.inventory.hasItem(ChiliMod.FlightChili.itemID) || par1ItemStack.getItemDamage() > 0){
			if(par2World.isRemote)
			{
				ChiliMod.proxy.printMessageToPlayer("Chili Flight Enabled");
			}
			par3EntityPlayer.capabilities.isFlying = true;
			par3EntityPlayer.sendPlayerAbilities();
			if(ChiliMod.enableSpecialChiliSounds){
				par2World.playSoundAtEntity(par3EntityPlayer, "ChiliMod:activateSpecialChili", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
			}
		}
		return cvb;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ChiliMod.modid + ":" + ChiliMod.CMFlightRing.getUnlocalizedName().substring(5));
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return false;
	}
}
