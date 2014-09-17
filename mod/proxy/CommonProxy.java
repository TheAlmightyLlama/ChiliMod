package net.chilimod.mod.proxy;

import java.util.Random;

import net.chilimod.mod.ChiliMod;
import net.chilimod.mod.ChiliModEventHooks;
import net.chilimod.mod.ConnectionHandlerThing;
import net.chilimod.mod.ServerTickHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy
{
	public void registerChiliProxy() {
		
	}

	public void printMessageToPlayer(String msg) {

	}
	
	public void registerServerTickHandler()
	{
		if(ChiliMod.enableFlightSpecialChili == true)
		{
			TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
		}
	}
	
	public void switchItem(int i, ItemStack itemstack, EntityPlayer par3EntityPlayer)
	{
		ChiliMod.proxy.printMessageToPlayer("Running switch");
		par3EntityPlayer.inventory.setInventorySlotContents(i, itemstack);
	}
	
	public String getMinecraftVersion() {
		return Loader.instance().getMinecraftModContainer().getVersion();
	}
}
