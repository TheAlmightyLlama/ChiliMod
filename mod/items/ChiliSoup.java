package net.chilimod.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.chilimod.mod.ChiliMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemSoup;

public class ChiliSoup extends ItemSoup
{
	public ChiliSoup(int par1, int par2, float f, boolean b) {
		super(par1, par2);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ChiliMod.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
