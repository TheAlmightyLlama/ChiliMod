package net.chilimod.mod.items;

import net.minecraft.potion.Potion;

public class CMInvincibilityPotion extends Potion
{
	public CMInvincibilityPotion(int par1, boolean par2, int par3) {
		super(par1, par2, par3);
	}
	
	public Potion setIconIndex(int par1, int par2) {
		super.setIconIndex(par1, par2);
		return this;
	}
}