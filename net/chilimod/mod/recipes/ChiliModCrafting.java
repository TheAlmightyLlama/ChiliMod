package net.chilimod.mod.recipes;

import net.chilimod.mod.ChiliMod;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ChiliModCrafting
{
	public static void loadRecipes()
	{
		// Shapeless Recipes
		
			// Chili Soup
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ChiliMod.ChiliSoup), new Object[]{
			new ItemStack(Item.bowlEmpty), "cropChili"
		}));
		
			// Chili Mushroom Soup
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ChiliMod.ChiliMushroomSoup), new Object[]{
			new ItemStack(Item.bowlEmpty), "cropChili", new ItemStack(Block.mushroomBrown)
		}));
		
			// Chili Chicken Soup
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ChiliMod.ChiliChickenSoup), new Object[]{
			new ItemStack(Item.bowlEmpty), "cropChili", new ItemStack(Item.chickenCooked)
		}));
		
			// Cup of Tea
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ChiliMod.CupOfTea), new Object[]{
			new ItemStack(ChiliMod.Cup), new ItemStack(ChiliMod.TeaLeaf), new ItemStack(Item.bucketWater.setContainerItem(Item.bucketEmpty))
		}));
		
			// Cup of Chili Tea
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ChiliMod.CupOfChiliTea), new Object[]{
			new ItemStack(ChiliMod.Cup), new ItemStack(ChiliMod.TeaLeaf), new ItemStack(Item.bucketWater.setContainerItem(Item.bucketEmpty)), "cropChili"
		}));
		
			// Chili Steak
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ChiliMod.ChiliSteak), new Object[]{
			new ItemStack(Item.beefCooked), "cropChili"
		}));
		
			// Peeled Potato
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ChiliMod.PeeledPotato), new Object[]{
			new ItemStack(ChiliMod.PotatoPeeler.setContainerItem(ChiliMod.PotatoPeeler)), new ItemStack(Item.potato)
		}));
		
			// Uncooked Chips
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ChiliMod.UncookedChips), new Object[]{
			new ItemStack(ChiliMod.KitchenKnife.setContainerItem(ChiliMod.KitchenKnife)), new ItemStack(ChiliMod.PeeledPotato)
		}));
		
			// Uncooked Chili Chips
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ChiliMod.UncookedChiliChips), new Object[]{
			new ItemStack(ChiliMod.UncookedChips), "cropChili"
		}));
		
		// Shaped Recipes
		
			// Chili Bread
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiliMod.ChiliBread), true, new Object[]{
			"WCW",
			'W', Item.wheat, Character.valueOf('C'), "cropChili"
		}));
		
			// Chili Chocolate
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiliMod.ChiliChocolate), true, new Object[]{
			"BCB",
			'B', new ItemStack(Item.dyePowder, 1, 3), 'C', "cropChili"
		}));
		
			// ChiliDog
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiliMod.ChiliDog), true, new Object[]{
			"C",
			"P",
			"B",
			'B', Item.bread, 'P', Item.porkCooked, 'C', "cropChili" 
		}));
		
			// Chili Cake
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiliMod.ChiliCake), true, new Object[]{
			"CMC",
			"SES",
			"WWW",
			'C', "cropChili", 'M', Item.bucketMilk.setContainerItem(Item.bucketEmpty), 'S', Item.sugar, 'E', Item.egg, 'W', Item.wheat 
		}));
		
			// Chili Burger
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiliMod.ChiliBurger), true, new Object[]{
			"B",
			"S",
			"B",
			'B', Item.bread, 'S', ChiliMod.ChiliSteak
		}));
		
		
		
		
		
			// Cup
		GameRegistry.addRecipe(new ItemStack(ChiliMod.Cup, 3), new Object[]{
			"CC ",
			"CCC",
			"CC ",
			'C', Item.clay
		});
		
			// Potato Peeler
		GameRegistry.addRecipe(new ItemStack(ChiliMod.PotatoPeeler), new Object[]{
			"III",
			"WIW",
			"W W",
			'I', Item.ingotIron, 'W', Block.planks
		});
		
			// Kitchen Knife
		GameRegistry.addRecipe(new ItemStack(ChiliMod.KitchenKnife), new Object[]{
			" I ",
			"WIW",
			" W ",
			'I', Item.ingotIron, 'W', Block.planks
		});
		
			// Chili Ingot
		GameRegistry.addRecipe(new ItemStack(ChiliMod.ChiliIngot), new Object[]{
			"NNN",
			'N', ChiliMod.ChiliNugget
		});
		
			// Chili Nugget
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiliMod.ChiliNugget), true, new Object[]{
			"CCC",
			"CCC",
			"CCC",
			'C', "cropChili"
		}));
		
			// Chili Sword
		ItemStack ChiliSword = new ItemStack(ChiliMod.ChiliSword);
		//ChiliSword.addEnchantment(Enchantment.fireAspect, 2);
		CraftingManager.getInstance().addRecipe(ChiliSword, new Object[] 
		{
			"C",
			"C",
			"S",
			'S', Item.stick, 'C', ChiliMod.ChiliIngot	
		});
		
		
			// Banish Rain Chili
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiliMod.BanishRainChili), true, new Object[]{
			" D ",
			" C ",
			"GLG",
			'D', Item.diamond, 'C', "ingotChili", 'G', Item.ingotGold, 'L', Item.bucketLava.setContainerItem(Item.bucketEmpty)
		}));
		
			// Instant Health Chili
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiliMod.InstantHealChili), true, new Object[]{
			"MMM",
			" C ",
			"G G",
			'M', Item.speckledMelon, 'C', "ingotChili", 'G', Item.ingotGold
		}));
		
			// Flight Chili
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiliMod.FlightChili), true, new Object[]{
			"G",
			"C",
			"G",
			'G', Item.ingotGold, 'C', ChiliMod.ChiliNugget
		}));
		
			// Flight Ring
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiliMod.CMFlightRing), true, new Object[]{
			"CDC",
			"C C",
			"CCC",
			'C', "ingotChili", 'D', Item.diamond
		}));
		
			// Almighty Chili
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiliMod.AlmightyChili), true, new Object[]{
			" O ",
			" C ",
			"M F",
			'O', Block.obsidian, 'C', "ingotChili", 'M', Item.magmaCream, 'F', Item.feather
		}));
		
		//Furnace Recipes
		
			// Chips
		FurnaceRecipes.smelting().addSmelting(ChiliMod.UncookedChips.itemID, new ItemStack(ChiliMod.Chips), 0.1F);
		
			// Chili Chips
		FurnaceRecipes.smelting().addSmelting(ChiliMod.UncookedChiliChips.itemID, new ItemStack(ChiliMod.ChiliChips), 0.1F);
	}
}
