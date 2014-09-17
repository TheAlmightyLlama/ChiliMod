package net.chilimod.mod.proxy;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.chilimod.mod.ChiliMod;
import net.chilimod.mod.ServerTickHandler;
import net.chilimod.mod.registerSounds;
import net.chilimod.mod.creativetabs.ChiliModTabs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	public void registerChiliProxy() {
		MinecraftForge.EVENT_BUS.register(new registerSounds());
	}
	
	@Override
    public void printMessageToPlayer(String msg) {
		if(ChiliMod.enableMessages == true)
		{
			Minecraft.getMinecraft().thePlayer.addChatMessage(EnumChatFormatting.AQUA + msg);
		}
    }
	
	public void registerServerTickHandler()
	{
		if(ChiliMod.enableFlightSpecialChili == true)
		{
			TickRegistry.registerTickHandler(new ServerTickHandler(), Side.CLIENT);
		}
	}	
}
