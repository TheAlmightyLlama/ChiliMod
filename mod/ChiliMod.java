package net.chilimod.mod;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import net.chilimod.mod.blocks.ChiliPlant;
import net.chilimod.mod.blocks.TeaPlant;
import net.chilimod.mod.blocks.blockChiliCake;
import net.chilimod.mod.creativetabs.ChiliModTabs;
import net.chilimod.mod.items.AlmightyChili;
import net.chilimod.mod.items.BanishRainChili;
import net.chilimod.mod.items.CMInvincibilityPotion;
import net.chilimod.mod.items.ChiliFoods;
import net.chilimod.mod.items.ChiliItem;
import net.chilimod.mod.items.ChiliSoup;
import net.chilimod.mod.items.ChiliSword;
import net.chilimod.mod.items.CupItem;
import net.chilimod.mod.items.DrinkChiliTea;
import net.chilimod.mod.items.DrinkTea;
import net.chilimod.mod.items.FlightChili;
import net.chilimod.mod.items.FlightRing;
import net.chilimod.mod.items.FlightRingActive;
import net.chilimod.mod.items.InstantHealChili;
import net.chilimod.mod.items.KitchenKnifeItem;
import net.chilimod.mod.items.NormalFood;
import net.chilimod.mod.items.PotatoPeelerItem;
import net.chilimod.mod.proxy.CommonProxy;
import net.chilimod.mod.recipes.ChiliModCrafting;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

// Mod & NetworkMod
@Mod(modid = ChiliMod.modid, name = "ChiliMod", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


public class ChiliMod
{
	// Define Modid
	
	public static final String version = "1.0";
	public static final String modid = "ChiliMod";
	
	public static CreativeTabs ChiliModTab = new ChiliModTabs(12, "ChiliModTab");
	
	public static EnumToolMaterial toolMaterialChiliIngot;
	
	@SidedProxy(clientSide="net.chilimod.mod.proxy.ClientProxy", serverSide="net.chilimod.mod.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	// Define Variables
	public static boolean enableAllSpecialChilis = true;
	public static boolean enableFlightSpecialChili = true;
	public static boolean enableInstantHealSpecialChili = true;
	public static boolean enableBanishRainSpecialChili = true;
	public static boolean enableAlmightySpecialChili = true;
	
	public static boolean enableMessages = true;
	public static boolean enableSpecialChiliSounds = true;
	
	public static boolean enableModPackRecipes = false;
	
	// Define Blocks
	public static Block cCropChili;
	public static int ChiliCropID;
	
	public static Block cCropTea;
	public static int TeaCropID;
	
	public static Block ChiliCake;
	public static int ChiliCakeID;
	
	// Define Item
	public static Item ChiliIngot;
	public static int ChiliIngotID;
	
	public static Item ChiliNugget;
	public static int ChiliNuggetID;
	
	public static Item Cup;
	public static int CupID;
	
	public static Item TeaLeaf;
	public static int TeaLeafID;
	
	public static Item PotatoPeeler;
	public static int PotatoPeelerID;
	
	public static Item KitchenKnife;
	public static int KitchenKnifeID;
	
	// Define Food
	public static Item Chili;
	public static int ChiliID;
	
	public static Item ChiliBread;
	public static int ChiliBreadID;
	
	public static Item ChiliChocolate;
	public static int ChiliChocolateID;
	
	public static Item ChiliDog;
	public static int ChiliDogID;
	
	public static Item ChiliSoup;
	public static int ChiliSoupID;
	
	public static Item ChiliMushroomSoup;
	public static int ChiliMushroomSoupID;
	
	public static Item ChiliChickenSoup;
	public static int ChiliChickenSoupID;
	
	public static Item ChiliSteak;
	public static int ChiliSteakID;
	
	public static Item ChiliBurger;
	public static int ChiliBurgerID;
	
	public static Item PeeledPotato;
	public static int PeeledPotatoID;
	
	public static Item UncookedChips;
	public static int UncookedChipsID;
	
	public static Item Chips;
	public static int ChipsID;
	
	public static Item UncookedChiliChips;
	public static int UncookedChiliChipsID;
	
	public static Item ChiliChips;
	public static int ChiliChipsID;
	
	// Define Special Food
	
	public static Item BanishRainChili;
	public static int BanishRainChiliID;
	
	public static Item InstantHealChili;
	public static int InstantHealChiliID;
	
	public static Item CMFlightRing;
	public static int CMFlightRingID;
	
	public static Item CMFlightRingActive;
	public static int CMFlightRingActiveID;
	
	public static Item FlightChili;
	public static int FlightChiliID;
	
	public static Item AlmightyChili;
	public static int AlmightyChiliID;
	
	// Define Drinks
	
	public static Item CupOfTea;
	public static int CupOfTeaID;
	
	public static Item CupOfChiliTea;
	public static int CupOfChiliTeaID;
	
	// Define Seeds
	public static Item cSeedsChili;
	public static int ChiliSeedsID;
	
	public static Item cSeedsTea;
	public static int TeaSeedsID;
	
	// Define Weapons
	public static Item ChiliSword;
	public static int ChiliSwordID;
	
	// Define Potions
	
	public static Potion CMInvincibilityPotion;
	
	@EventHandler
	public void load(FMLPreInitializationEvent event)
	{
		newPotionInit();

		MinecraftForge.EVENT_BUS.register(new ChiliModEventHooks());
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
			// Blocks use Ids 3830-3890
			ChiliCropID = config.get(config.CATEGORY_BLOCK, "cChiliCropID", 3830).getInt();
			TeaCropID = config.get(config.CATEGORY_BLOCK, "TeaCropID", 3831).getInt();
			
			ChiliCakeID = config.get(config.CATEGORY_BLOCK, "ChiliCakeID", 3832).getInt();
			
			// Items - use Ids 24500 +
			ChiliID = config.get(config.CATEGORY_ITEM, "ChiliID", 24500).getInt();
			ChiliBreadID = config.get(config.CATEGORY_ITEM, "ChiliBreadID", 24501).getInt();
			ChiliChocolateID = config.get(config.CATEGORY_ITEM, "ChiliChocolateID", 24502).getInt();
			ChiliDogID = config.get(config.CATEGORY_ITEM, "ChiliDogID", 24504).getInt();
			ChiliSoupID = config.get(config.CATEGORY_ITEM, "ChiliSoupID", 24505).getInt();
			ChiliMushroomSoupID = config.get(config.CATEGORY_ITEM, "ChiliMushroomSoupID", 24506).getInt();
			ChiliChickenSoupID = config.get(config.CATEGORY_ITEM, "ChiliChickenSoupID", 24507).getInt();
			TeaLeafID = config.get(config.CATEGORY_ITEM, "TeaLeafID", 24508).getInt();
			ChiliSteakID = config.get(config.CATEGORY_ITEM, "ChiliSteakID", 24509).getInt();
			ChiliBurgerID = config.get(config.CATEGORY_ITEM, "ChiliBurgerID", 24510).getInt();
			PeeledPotatoID = config.get(config.CATEGORY_ITEM, "PeeledPotatoID", 24511).getInt();
			UncookedChipsID = config.get(config.CATEGORY_ITEM, "UncookedChipsID", 24512).getInt();
			ChipsID = config.get(config.CATEGORY_ITEM, "ChipsID", 24513).getInt();
			UncookedChiliChipsID = config.get(config.CATEGORY_ITEM, "UncookedChiliChipsID", 24514).getInt();
			ChiliChipsID = config.get(config.CATEGORY_ITEM, "ChiliChipsID", 24515).getInt();
			
			BanishRainChiliID = config.get(config.CATEGORY_ITEM, "BanishRainChiliID", 24516).getInt();
			InstantHealChiliID = config.get(config.CATEGORY_ITEM, "InstantHealChiliID", 24517).getInt();
			CMFlightRingID = config.get(config.CATEGORY_ITEM, "CMFlightRingID", 24518).getInt();
			CMFlightRingActiveID = config.get(config.CATEGORY_ITEM, "CMFlightRingActiveID", 24519).getInt();
			FlightChiliID = config.get(config.CATEGORY_ITEM, "FlightChiliID", 24520).getInt();
			AlmightyChiliID = config.get(config.CATEGORY_ITEM, "AlmightyChiliID", 24521).getInt();
			
			CupOfTeaID = config.get(config.CATEGORY_ITEM, "CupOfTeaID", 24537).getInt();
			CupOfChiliTeaID = config.get(config.CATEGORY_ITEM, "CupOfChiliTeaID", 24538).getInt();
			
			ChiliSeedsID = config.get(config.CATEGORY_ITEM, "ChiliSeedsID", 24539).getInt();
			TeaSeedsID = config.get(config.CATEGORY_ITEM, "TeaSeedsID", 24540).getInt();
			
			ChiliIngotID = config.get(config.CATEGORY_ITEM, "ChiliIngotID", 24541).getInt();
			ChiliNuggetID = config.get(config.CATEGORY_ITEM, "ChiliNuggetID", 24542).getInt();
			
			CupID =  config.get(config.CATEGORY_ITEM, "CupID", 24543).getInt();
			PotatoPeelerID = config.get(config.CATEGORY_ITEM, "PotatoPeelerID", 24544).getInt();
			KitchenKnifeID = config.get(config.CATEGORY_ITEM, "KitchenKnifeID", 24545).getInt();
			
			
			ChiliSwordID = config.get(config.CATEGORY_ITEM, "ChiliSwordID", 24546).getInt();
			
			//Settings
			
			config.addCustomCategoryComment("General", "Enabling All Special Chili's Overrides Settings For Individual Special Chili's.");
			enableAllSpecialChilis = config.get(config.CATEGORY_GENERAL, "enableAllSpecialChilis", true).getBoolean(true);
			enableFlightSpecialChili = config.get(config.CATEGORY_GENERAL, "enableFlightSpecialChili", true).getBoolean(true);
			enableInstantHealSpecialChili = config.get(config.CATEGORY_GENERAL, "enableInstantHealSpecialChili", true).getBoolean(true);
			enableBanishRainSpecialChili = config.get(config.CATEGORY_GENERAL, "enableBanishRainSpecialChili", true).getBoolean(true);
			enableAlmightySpecialChili = config.get(config.CATEGORY_GENERAL, "enableAlmightySpecialChili", true).getBoolean(true);
			
			enableMessages = config.get(config.CATEGORY_GENERAL, "enableMessages", true).getBoolean(true);
			Property someProperty = config.get(Configuration.CATEGORY_GENERAL, "enableMessages", "nothing");
            someProperty.comment = "Allows Chili Mod Messages when using certain items. Will only be sent to the player using the item.";
            
            enableSpecialChiliSounds = config.get(config.CATEGORY_GENERAL, "enableSpecialChiliSounds", true).getBoolean(true);
            Property someProperty2 = config.get(Configuration.CATEGORY_GENERAL, "enableSpecialChiliSounds", "nothing");
            someProperty2.comment = "Enables sound effects for when special chilis are used.";
            
//            enableModPackRecipes = config.get(config.CATEGORY_GENERAL, "enableModPackRecipes", false).getBoolean(false);
//            Property someProperty3 = config.get(Configuration.CATEGORY_GENERAL, "enableModPackRecipes", "nothing");
//            someProperty3.comment = "Enable this if you use the ChiliMod with other mods that makes getting resources easy. This will quadruple the resources needed to craft Special Chilis.";
		config.save();
		
		LanguageRegistry.instance().addStringLocalization("CMInvincibilityPotion", "Invincibility");
		LanguageRegistry.instance().addStringLocalization("death.attack.kitchenknifedmg", "\u00A7a%1$s \u00A7fwas \u00A76shanked \u00A7fto death"); //This shouldn't happen, but add anyway.
		LanguageRegistry.instance().addStringLocalization("death.attack.kitchenknifedmg.player", "\u00A7a%1$s \u00A7fwas \u00A76shanked \u00A7fby \u00A7c%2$s"); //Death from the damagesource, because of a player. Should always be this.
		LanguageRegistry.instance().addStringLocalization("death.attack.kitchenknifedmg.item", "\u00A7a%1$s \u00A7fwas \u00A76shanked \u00A7fby \u00A7c%2$s"); //Death from the damagesource of they renamed the sword
		
		proxy.registerChiliProxy();
		proxy.registerServerTickHandler();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) throws Exception
	{
		if(enableAllSpecialChilis == true)
		{
			enableFlightSpecialChili = true;
			enableInstantHealSpecialChili = true;
			enableBanishRainSpecialChili = true;
			enableAlmightySpecialChili = true;
		}
		
		toolMaterialChiliIngot = EnumHelper.addToolMaterial("ChiliIngot", 1, 200, 9.0F, 4.0F, 15);
			
		// Initialize Plants 
		cCropChili = new ChiliPlant(ChiliCropID).setUnlocalizedName("cCropChili");
		cCropTea = new TeaPlant(TeaCropID).setUnlocalizedName("cCropTea");
		
		// Initialize Items
		ChiliIngot = new ChiliItem(ChiliIngotID).setUnlocalizedName("ChiliIngot").setCreativeTab(ChiliModTab);
		ChiliNugget = new ChiliItem(ChiliNuggetID).setUnlocalizedName("ChiliNugget").setCreativeTab(ChiliModTab);
		Cup = new CupItem(CupID).setUnlocalizedName("Cup").setCreativeTab(ChiliModTab);
		TeaLeaf = new ChiliItem(TeaLeafID).setUnlocalizedName("TeaLeaf").setCreativeTab(ChiliModTab);
		PotatoPeeler = new PotatoPeelerItem(PotatoPeelerID).setUnlocalizedName("PotatoPeeler").setCreativeTab(ChiliModTab);
		KitchenKnife = new KitchenKnifeItem(KitchenKnifeID).setUnlocalizedName("KitchenKnife").setCreativeTab(ChiliModTab);
		
		// Initialize Foods
		Chili = new ChiliFoods(ChiliID, 2, 0.2F, false).setUnlocalizedName("Chili").setCreativeTab(ChiliModTab).setTextureName(modid + ":" + "Chili");
		ChiliBread = new ChiliFoods(ChiliBreadID, 4, 0.4F, false).setUnlocalizedName("ChiliBread").setCreativeTab(ChiliModTab);
		ChiliChocolate = new ChiliFoods(ChiliChocolateID, 3, 0.3F, false).setUnlocalizedName("ChiliChocolate").setCreativeTab(ChiliModTab);
		ChiliDog = new ChiliFoods(ChiliDogID, 15, 1.2F, false).setUnlocalizedName("ChiliDog").setCreativeTab(ChiliModTab);
		ChiliSoup = new ChiliSoup(ChiliSoupID, 5, 0.4F, false).setUnlocalizedName("ChiliSoup").setCreativeTab(ChiliModTab);
		ChiliMushroomSoup = new ChiliSoup(ChiliMushroomSoupID, 6, 0.6F, false).setUnlocalizedName("ChiliMushroomSoup").setCreativeTab(ChiliModTab);
		ChiliChickenSoup = new ChiliSoup(ChiliChickenSoupID, 12, 1F, false).setUnlocalizedName("ChiliChickenSoup").setCreativeTab(ChiliModTab);
		ChiliSteak = new ChiliFoods(ChiliSteakID, 12, 1.3F, false).setUnlocalizedName("ChiliSteak").setCreativeTab(ChiliModTab);
		ChiliBurger = new ChiliFoods(ChiliBurgerID, 20, 1.6F, false).setUnlocalizedName("ChiliBurger").setCreativeTab(ChiliModTab);
		PeeledPotato = new ChiliItem(PeeledPotatoID).setUnlocalizedName("PeeledPotato").setCreativeTab(ChiliModTab);
		UncookedChips = new ChiliItem(UncookedChipsID).setUnlocalizedName("UncookedChips").setCreativeTab(ChiliModTab);
		Chips = new NormalFood(ChipsID, 8, 0.9F, false).setUnlocalizedName("Chips").setCreativeTab(ChiliModTab);
		UncookedChiliChips = new ChiliItem(UncookedChiliChipsID).setUnlocalizedName("UncookedChiliChips").setCreativeTab(ChiliModTab);
		ChiliChips = new ChiliFoods(ChiliChipsID, 10, 1F, false).setUnlocalizedName("ChiliChips").setCreativeTab(ChiliModTab);
		
		ChiliCake = new blockChiliCake(ChiliCakeID, Material.cake).setUnlocalizedName("ChiliCake").setCreativeTab(ChiliModTab).setHardness(0.5F).setStepSound(Block.soundClothFootstep); 
		
		// Initialize Drinks
		CupOfTea = new DrinkTea(CupOfTeaID, 2, 0.5F, false).setUnlocalizedName("CupOfTea").setCreativeTab(ChiliModTab);
		CupOfChiliTea = new DrinkChiliTea(CupOfChiliTeaID, 4, 0.7F, false).setUnlocalizedName("CupOfChiliTea").setCreativeTab(ChiliModTab);
		
		// Initialize Seeds 
		cSeedsChili = new ItemSeeds(ChiliSeedsID, cCropChili.blockID, Block.tilledField.blockID).setUnlocalizedName("cSeedsChili").setTextureName(modid + ":cSeedsChili").setCreativeTab(ChiliModTab);
		cSeedsTea = new ItemSeeds(TeaSeedsID, cCropTea.blockID, Block.tilledField.blockID).setUnlocalizedName("cSeedsTea").setTextureName(modid + ":cSeedsTea").setCreativeTab(ChiliModTab);
		
		/// Initialize Weapons
		ChiliSword = new ChiliSword(ChiliSwordID, toolMaterialChiliIngot).setUnlocalizedName("ChiliSword");
		
		// Initialize Potions
		
		CMInvincibilityPotion = (new CMInvincibilityPotion(32, false, 0)).setIconIndex(6, 1).setPotionName("CMInvincibilityPotion");
		
		// Register Crops		
		GameRegistry.registerBlock(cCropChili, modid + cCropChili.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(cCropChili, "Chili Crop");
		
		GameRegistry.registerBlock(cCropTea, modid + cCropTea.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(cCropTea, "Tea Crop");
		
		//Register Blocks
		GameRegistry.registerBlock(ChiliCake, modid + ChiliCake.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliCake, "Chili Cake");
		
		// Register Items
		GameRegistry.registerItem(ChiliIngot, modid + ChiliIngot.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliIngot, "Chili Ingot");
		
		GameRegistry.registerItem(ChiliNugget, modid + ChiliNugget.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliNugget, "Chili Nugget");
		
		GameRegistry.registerItem(Cup, modid + Cup.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(Cup, "Cup");
		
		GameRegistry.registerItem(TeaLeaf, modid + TeaLeaf.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(TeaLeaf, "Tea Leaf");
		
		GameRegistry.registerItem(PotatoPeeler, modid + PotatoPeeler.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(PotatoPeeler, "Potato Peeler");
		
		GameRegistry.registerItem(KitchenKnife, modid + KitchenKnife.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(KitchenKnife, "Kitchen Knife");
		
		GameRegistry.registerItem(PeeledPotato, modid + PeeledPotato.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(PeeledPotato, "Peeled Potato");
		
		GameRegistry.registerItem(UncookedChips, modid + UncookedChips.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(UncookedChips, "Uncooked Chips");
		
		GameRegistry.registerItem(UncookedChiliChips, modid + UncookedChiliChips.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(UncookedChiliChips, "Uncooked ChiliChips");
		
		// Register Food
		GameRegistry.registerItem(Chili, modid + Chili.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(Chili, "Chili");
		
		GameRegistry.registerItem(ChiliBread, modid + ChiliBread.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliBread, "Chili Bread");
		
		GameRegistry.registerItem(ChiliChocolate, modid + ChiliChocolate.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliChocolate, "Chili Chocolate");
		
		GameRegistry.registerItem(ChiliDog, modid + ChiliDog.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliDog, "ChiliDog");
		
		GameRegistry.registerItem(ChiliSoup, modid + ChiliSoup.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliSoup, "Chili Soup");
		
		GameRegistry.registerItem(ChiliMushroomSoup, modid + ChiliMushroomSoup.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliMushroomSoup, "Chili and Mushroom Soup");
		
		GameRegistry.registerItem(ChiliChickenSoup, modid + ChiliChickenSoup.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliChickenSoup, "Chili and Chicken Soup");
		
		GameRegistry.registerItem(ChiliSteak, modid + ChiliSteak.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliSteak, "Chili Steak");
		
		GameRegistry.registerItem(ChiliBurger, modid + ChiliBurger.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliBurger, "Chili Burger");
		
		GameRegistry.registerItem(Chips, modid + Chips.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(Chips, "Chips");
		
		GameRegistry.registerItem(ChiliChips, modid + ChiliChips.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliChips, "ChiliChips");
		
		
		// Register Drinks
		GameRegistry.registerItem(CupOfTea, modid + CupOfTea.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(CupOfTea, "Cup of Tea");

		GameRegistry.registerItem(CupOfChiliTea, modid + CupOfChiliTea.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(CupOfChiliTea, "Cup of Chili Tea");
		
		// Register Seeds
		GameRegistry.registerItem(cSeedsChili, modid + cSeedsChili.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(cSeedsChili, "Chili Seeds");
		
		GameRegistry.registerItem(cSeedsTea, modid + cSeedsTea.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(cSeedsTea, "Tea Seeds");
		
		// Register Weapons
		GameRegistry.registerItem(ChiliSword, modid + ChiliSword.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(ChiliSword, "Chili Sword");
		
		// Special Food				
		if(enableBanishRainSpecialChili == true)
		{
			BanishRainChili = new BanishRainChili(BanishRainChiliID).setUnlocalizedName("BanishRainChili").setCreativeTab(ChiliModTab);
			GameRegistry.registerItem(BanishRainChili, modid + BanishRainChili.getUnlocalizedName().substring(5));
			LanguageRegistry.addName(BanishRainChili, "Banish Rain Chili");
		}
		if(enableInstantHealSpecialChili == true)
		{
			InstantHealChili = new InstantHealChili(InstantHealChiliID).setUnlocalizedName("InstantHealChili").setCreativeTab(ChiliModTab);
			GameRegistry.registerItem(InstantHealChili, modid + InstantHealChili.getUnlocalizedName().substring(5));
			LanguageRegistry.addName(InstantHealChili, "Instant Heal Chili");
		}
		if(enableFlightSpecialChili == true)
		{
			CMFlightRing = new FlightRing(CMFlightRingID).setUnlocalizedName("CMFlightRing").setCreativeTab(ChiliModTab);
			GameRegistry.registerItem(CMFlightRing, modid + CMFlightRing.getUnlocalizedName().substring(5));
			LanguageRegistry.addName(CMFlightRing, "Flight Ring \u00A7c\u00A7oInactive");
			CMFlightRingActive = new FlightRingActive(CMFlightRingActiveID).setUnlocalizedName("CMFlightRingActive").setCreativeTab(ChiliModTab);
			GameRegistry.registerItem(CMFlightRingActive, modid + CMFlightRingActive.getUnlocalizedName().substring(5));
			LanguageRegistry.addName(CMFlightRingActive, "Flight Ring \u00A7a\u00A7oActive");
			FlightChili = new FlightChili(FlightChiliID).setUnlocalizedName("FlightChili").setCreativeTab(ChiliModTab);
			GameRegistry.registerItem(FlightChili, modid + FlightChili.getUnlocalizedName().substring(5));
			LanguageRegistry.addName(FlightChili, "Flight Chili");
		}
		if(enableAlmightySpecialChili == true)
		{
			AlmightyChili = new AlmightyChili(AlmightyChiliID).setUnlocalizedName("AlmightyChili").setCreativeTab(ChiliModTab);
			GameRegistry.registerItem(AlmightyChili, modid + AlmightyChili.getUnlocalizedName().substring(5));
			LanguageRegistry.addName(AlmightyChili, "Almighty Chili");
		}
		
		if ((Loader.isModLoaded("MineFactoryReloaded")))
	    {
	      MFR.registerMfr();
	    }
		
	    oreRegistration();
		
		ChiliModCrafting.loadRecipes();
		
		MinecraftForge.addGrassSeed(new ItemStack(cSeedsChili), 10);
		MinecraftForge.addGrassSeed(new ItemStack(cSeedsTea), 10);
		
	}
	
	@EventHandler
	public void Post(FMLPostInitializationEvent event) throws Exception
	{
		VersionCheck.CheckVersion();
	}
	
    
    public static void oreRegistration()
    {
    	OreDictionary.registerOre("cropChili", Chili);
    	OreDictionary.registerOre("seedsChili", cSeedsChili);
    	OreDictionary.registerOre("ingotChili", ChiliIngot);
    }
    
    public static void newPotionInit()
    {
    	Potion[] potionTypes = null;

    	for (Field f : Potion.class.getDeclaredFields())
    	{
    		f.setAccessible(true);
    		try
    		{
    			if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a"))
    			{
    				Field modfield = Field.class.getDeclaredField("modifiers");
			    	modfield.setAccessible(true);
			    	modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);
			
			    	potionTypes = (Potion[])f.get(null);
			    	final Potion[] newPotionTypes = new Potion[256];
			    	System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
			    	f.set(null, newPotionTypes);
    			}
	    	}
	    	catch (Exception e)
			{
	    		System.err.println("Severe error, please report this to the mod author:");
	    		System.err.println(e);
			}
		}
    }

}



