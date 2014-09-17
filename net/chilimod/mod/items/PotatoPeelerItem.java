package net.chilimod.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.chilimod.mod.ChiliMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PotatoPeelerItem extends Item
{
	public PotatoPeelerItem(int par1) {
		super(par1);
		this.maxStackSize = 1;
	}
	
	@Override 
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ChiliMod.modid + ":" + (this.getUnlocalizedName().substring(5)));
	
	}
}
