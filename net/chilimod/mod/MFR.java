package net.chilimod.mod;

import java.lang.reflect.Constructor;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.IPlantable;
import powercrystals.minefactoryreloaded.api.FactoryRegistry;
import powercrystals.minefactoryreloaded.api.IFactoryFertilizable;
import powercrystals.minefactoryreloaded.api.IFactoryHarvestable;
import powercrystals.minefactoryreloaded.api.IFactoryPlantable;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class MFR
{
	static void registerMfr() throws Exception
	{
		String[] cMaterials = { "Chili", "Tea" };
		registerMfr(cMaterials, "c");
	}
		  
	private static void registerMfr(String[] materials, String prefix) throws Exception
	{
		Constructor plantableconstructor = null;
		Constructor harvestconstructor = null;
		Constructor fertilizableconstructor = null;
		try
		{
			Class plantableClass = Class.forName("powercrystals.minefactoryreloaded.farmables.plantables.PlantableCropPlant");
		      
		    Constructor[] plantableAllConstructors = plantableClass.getDeclaredConstructors();
		    for (Constructor ctor : plantableAllConstructors)
		    {
		    	Class<?>[] pType = ctor.getParameterTypes();
		        if ((pType.length == 2) && (pType[0] == Integer.TYPE) && (pType[1] == Integer.TYPE))
		        {
		        	plantableconstructor = ctor;
		        }
		    }
		    Class harvestClass = Class.forName("powercrystals.minefactoryreloaded.farmables.harvestables.HarvestableCropPlant");
		    
		    Constructor[] harvestAllConstructors = harvestClass.getDeclaredConstructors();
		    for (Constructor ctor : harvestAllConstructors)
		    {
		    	Class<?>[] pType = ctor.getParameterTypes();
		        if ((pType.length == 2) && (pType[0] == Integer.TYPE) && (pType[1] == Integer.TYPE))
		        {
		        	harvestconstructor = ctor;
		        }
		    }
		    Class fertilizeClass = Class.forName("powercrystals.minefactoryreloaded.farmables.fertilizables.FertilizableCropPlant");
		    
		    Constructor[] fertilizeAllConstructors = fertilizeClass.getDeclaredConstructors();
		    for (Constructor ctor : fertilizeAllConstructors)
		    {
		    	Class<?>[] pType = ctor.getParameterTypes();
		        if ((pType.length == 2) && (pType[0] == Integer.TYPE) && (pType[1] == Integer.TYPE))
		        {
		        	fertilizableconstructor = ctor;
		        }
		    }
		}
		catch (ClassNotFoundException e)
		{
			throw new RuntimeException("ChiliMod Seemed to have failed to init MineFactory Reloaded Planter/Harvester/Fertilizable classes :(", e);
		}
		
		Class cropsModClass = Class.forName("net.chilimod.mod.ChiliMod");
		for (String material : materials)
		{
			String cropName = prefix + "Crop" + material;
		    String seedName = prefix.charAt(0) + "Seeds" + material;
		     
		    Block crop = (Block)cropsModClass.getField(cropName).get(null);
		    Item seed = (Item)cropsModClass.getField(seedName).get(null);
		    if ((crop == null) || (seed == null))
		    {
		    	FMLLog.warning("We could not find " + cropName, new Object[0]);
		    }
		    else
		    {
		    	if (!(seed instanceof IPlantable))
		    	{
		    		throw new IllegalArgumentException("Seed " + seed.itemID + " is not Plantable.");
		        }
		        IFactoryPlantable plantable = (IFactoryPlantable)plantableconstructor.newInstance(new Object[] { Integer.valueOf(seed.itemID), Integer.valueOf(crop.blockID) });
		        FactoryRegistry.registerPlantable(plantable);
		        

		        IFactoryHarvestable harvestable = (IFactoryHarvestable)harvestconstructor.newInstance(new Object[] { Integer.valueOf(crop.blockID), Integer.valueOf(7) });
		        FactoryRegistry.registerHarvestable(harvestable);
		        
		        IFactoryFertilizable fertilizable = (IFactoryFertilizable)fertilizableconstructor.newInstance(new Object[] { Integer.valueOf(crop.blockID), Integer.valueOf(7) });
		        FactoryRegistry.registerFertilizable(fertilizable);
		    }
		}
	}
		  
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		try
		{
		FMLLog.log(Level.INFO, "Loading ChiliMod for MFR", new Object[0]);
		registerMfr();
    }
    catch (Exception e)
    {
      throw new RuntimeException("Failed to initilize ChiliMod for MFR", e);
    }
  }
}
