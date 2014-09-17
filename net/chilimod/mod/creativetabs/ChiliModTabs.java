package net.chilimod.mod.creativetabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.chilimod.mod.ChiliMod;
import net.minecraft.creativetab.CreativeTabs;

public class ChiliModTabs extends CreativeTabs
{
	public ChiliModTabs(int id, String par2Str) {
		super(id, par2Str);
	}

    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
	    return ChiliMod.Chili.itemID;
    }
   
    public String getTranslatedTabLabel()
    {
	 return "Chili Mod";
    }
}
