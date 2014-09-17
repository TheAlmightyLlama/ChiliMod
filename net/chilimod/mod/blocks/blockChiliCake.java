package net.chilimod.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.chilimod.mod.ChiliMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCake;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class blockChiliCake extends BlockCake{

	public blockChiliCake(int id, Material cake) {
		super(id);
        this.setTickRandomly(true);
	}

	@SideOnly(Side.CLIENT)
    private Icon cakeTopIcon;
    @SideOnly(Side.CLIENT)
    private Icon cakeBottomIcon;
    @SideOnly(Side.CLIENT)
    private Icon cakeSide;
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.cakeTopIcon : (par1 == 0 ? this.cakeBottomIcon : (par2 > 0 && par1 == 4 ? this.cakeSide : this.blockIcon));
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(ChiliMod.modid + ":" + "ChiliCake_side");
        this.cakeSide = par1IconRegister.registerIcon(ChiliMod.modid + ":" + "ChiliCake_inner");
        this.cakeTopIcon = par1IconRegister.registerIcon(ChiliMod.modid + ":" + "ChiliCake_top");
        this.cakeBottomIcon = par1IconRegister.registerIcon(ChiliMod.modid + ":" + "ChiliCake_bottom");
    }
}
