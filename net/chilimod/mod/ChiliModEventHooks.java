package net.chilimod.mod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;


public class ChiliModEventHooks {
	@ForgeSubscribe
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			if(player.isPotionActive(ChiliMod.CMInvincibilityPotion))
			{
				if (event.entityLiving.worldObj.rand.nextInt(20) == 0)
				{
					player.capabilities.disableDamage = true;
					player.sendPlayerAbilities();
				}
				if (event.entityLiving.getActivePotionEffect(ChiliMod.CMInvincibilityPotion).getDuration()==0) {
					event.entityLiving.removePotionEffect(ChiliMod.CMInvincibilityPotion.id);
					player.capabilities.disableDamage = false;
					player.sendPlayerAbilities();
					return;
				}
			}
			else
			{
				if(!player.capabilities.isCreativeMode)
				{
					player.capabilities.disableDamage = false;
					player.sendPlayerAbilities();
				}
			}
		}
	}
}
