package net.chilimod.mod;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {
	private int timer = 0;
	public void onPlayerTick(EntityPlayer player)
	{
			if(player.inventory.hasItem(ChiliMod.CMFlightRingActive.itemID))
			{
				int activeChiliDuration = 0;
				int chiliSlot = 0;
				int t = 0;
				ItemStack qwe = new ItemStack(ChiliMod.CMFlightRingActive);
				for(int i=0; i < player.inventory.getSizeInventory(); i++)
				{
					if(player.inventory.getStackInSlot(i) != null)
					{
						ItemStack j = player.inventory.getStackInSlot(i);
						if(j.getItem() != null && j.getItem() == qwe.getItem())
						{
							activeChiliDuration = j.getItemDamage();
							chiliSlot = i;
							t = 1;
							break;
						}
					}
				}
				if(t == 1)
				{
					if(player.capabilities.isCreativeMode == true)
					{
						player.capabilities.allowFlying = true;
						player.sendPlayerAbilities();
					}
					else if(activeChiliDuration == 0  && player.inventory.consumeInventoryItem(ChiliMod.FlightChili.itemID))
					{
						ItemStack itemgot = player.inventory.getStackInSlot(chiliSlot);
						itemgot.setItemDamage(1);
						if(player.capabilities.isFlying == false)
						{
							player.capabilities.isFlying = true;
							player.sendPlayerAbilities();
						}
					}
					else if(activeChiliDuration == 20  && player.inventory.consumeInventoryItem(ChiliMod.FlightChili.itemID))
					{
						ItemStack itemgot = player.inventory.getStackInSlot(chiliSlot);
						itemgot.setItemDamage(1);
						if(player.capabilities.isFlying == false)
						{
							player.capabilities.isFlying = true;
							player.sendPlayerAbilities();
						}
					}
					else if(activeChiliDuration > 0 && activeChiliDuration < 20)
					{
						if(timer == 20)
						{
							ItemStack itemgot = player.inventory.getStackInSlot(chiliSlot);
							itemgot.setItemDamage(itemgot.getItemDamage() + 1);
						}
						if(player.capabilities.isFlying == false)
						{
							player.capabilities.isFlying = true;
							player.sendPlayerAbilities();
						}
					}
					else
					{
						player.capabilities.isFlying = false;
		                player.fallDistance = 0F;
		                player.sendPlayerAbilities();
		                ChiliMod.proxy.printMessageToPlayer("No Chili's");
		                player.inventory.setInventorySlotContents(chiliSlot, new ItemStack(ChiliMod.CMFlightRing));
					}
				}
				else
				{
					if(player.capabilities.isCreativeMode == false)
					{
						if(player.capabilities.allowFlying == true)
						{
							player.capabilities.isFlying = false;
			                player.fallDistance = 0F;
			                player.sendPlayerAbilities();
						}
		                player.inventory.setInventorySlotContents(chiliSlot, new ItemStack(ChiliMod.CMFlightRing));
					}
				}
				
			}
			else if(!player.inventory.hasItem(ChiliMod.CMFlightRingActive.itemID))
			{
				if(player.capabilities.isCreativeMode == false && player.capabilities.isFlying == true)
				{
					player.capabilities.isFlying = false;
		            player.sendPlayerAbilities();
				}
			}
			
			if(timer >= 20)
			{
				timer = 0;
			}
			
			timer++;	
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if(type.equals(EnumSet.of(TickType.PLAYER)))
		{
			onPlayerTick((EntityPlayer)tickData[0]);
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel() {
		return null;
	}

}
