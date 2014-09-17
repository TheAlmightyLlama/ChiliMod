package net.chilimod.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.chilimod.mod.ChiliMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class DrinkTea extends ItemSoup
{
	public DrinkTea(int par1, int par2, float f, boolean b) {
		super(par1, par2);
		this.setMaxStackSize(1);
		this.setPotionEffect(Potion.damageBoost.id, 15, 0, 1F); // Damage boost
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ChiliMod.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
    }
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
        return new ItemStack(ChiliMod.Cup);
    }
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        return false;
    }

}
