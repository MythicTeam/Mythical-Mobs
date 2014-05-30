package mythology.init;

import mythology.MythologyMod;
import mythology.handlers.GuiHandler;
import mythology.mobs.hostile.EntityCentaur;
import mythology.mobs.hostile.EntityMinotaur;
import mythology.mobs.passive.EntityFairy;
import mythology.mobs.passive.EntityGnome;
import mythology.tileentities.TileEntityAlloyFurnace;
import mythology.world.MythicalWorldGen;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registration {
	
	private static MythologyMod m = new MythologyMod();
	private static MythicalArmor ma = new MythicalArmor();
	private static MythicalBlocks mb = new MythicalBlocks();
	private static MythicalItems mi = new MythicalItems();
	private static MythicalTools mt = new MythicalTools();
	private static MythicalIngot mii = new MythicalIngot();

	public static void load() {
		registerBlock();
		registerItem();
		registerOre();
		registerOreDictionary();
		registerCraftingRecipes();
		registerSmeltingRecipes();
		registerWorldGenerator();
		registerTileEntity();
		registerHandlers();
	}
	
	private static void registerMob() {
		MythologyRegister.addMob(EntityGnome.class, "mobGnome", EnumCreatureType.creature, 0xFC0A16, 0xFCFCFC, BiomeGenBase.roofedForest, 200, 200, 200);
		MythologyRegister.addMob(EntityCentaur.class, "mobCentaur", EnumCreatureType.monster, 0x1A33D6, 0x1AD63F, BiomeGenBase.megaTaiga, 200, 200, 200);
		MythologyRegister.addMob(EntityFairy.class, "mobFairy", EnumCreatureType.creature, 0x07FA10, 0xE9F5E9, BiomeGenBase.forest, 200, 200, 200);
		MythologyRegister.addMob(EntityMinotaur.class, "mobrnotaur", EnumCreatureType.monster, 0x835C3B, 0xD1D0CE, BiomeGenBase.extremeHillsPlus, 200, 200, 200);
	}
	
	private static void registerBlock() {
		MythologyRegister.registerBlock(mb.blockMysticGrass);
		MythologyRegister.registerBlock(mb.blockMysticDirt);
		MythologyRegister.registerBlock(mb.blockBronzeBlock);
		MythologyRegister.registerBlock(mb.blockCelestialBronzeBlock);
		MythologyRegister.registerBlock(mb.blockImperialGoldBlock);
		MythologyRegister.registerBlock(mb.blockPlatinumBlock);
		MythologyRegister.registerBlock(mb.blockSilverBlock);
		MythologyRegister.registerBlock(mb.blockRubyBlock);
		MythologyRegister.registerBlock(mb.blockSapphireBlock);
		MythologyRegister.registerBlock(mb.blockCopperBlock);
		MythologyRegister.registerBlock(mb.blockTinBlock);
		MythologyRegister.registerBlock(mb.alloyFurnaceIdle);
	}
	
	private static void registerItem() {
		
		//Armor
		MythologyRegister.registerItem(ma.bronzeHelmet);
    	MythologyRegister.registerItem(ma.bronzeChestplate);
    	MythologyRegister.registerItem(ma.bronzeLeggings);
    	MythologyRegister.registerItem(ma.bronzeBoots);
    	MythologyRegister.registerItem(ma.celestialBronzeHelmet);
    	MythologyRegister.registerItem(ma.celestialBronzeChestplate);
    	MythologyRegister.registerItem(ma.celestialBronzeLeggings);
    	MythologyRegister.registerItem(ma.celestialBronzeBoots);
    	MythologyRegister.registerItem(ma.imperialGoldHelmet);
    	MythologyRegister.registerItem(ma.imperialGoldChestplate);
    	MythologyRegister.registerItem(ma.imperialGoldLeggings);
    	MythologyRegister.registerItem(ma.imperialGoldBoots);
    	MythologyRegister.registerItem(ma.silverHelmet);
    	MythologyRegister.registerItem(ma.silverChestplate);
    	MythologyRegister.registerItem(ma.silverLeggings);
    	MythologyRegister.registerItem(ma.silverBoots);
    	MythologyRegister.registerItem(ma.mithrilHelmet);
    	MythologyRegister.registerItem(ma.mithrilChestplate);
    	MythologyRegister.registerItem(ma.mithrilLeggings);
    	MythologyRegister.registerItem(ma.mithrilBoots);
    	MythologyRegister.registerItem(ma.rubyHelmet);
    	MythologyRegister.registerItem(ma.rubyChestplate);
    	MythologyRegister.registerItem(ma.rubyLeggings);
    	MythologyRegister.registerItem(ma.rubyBoots);
    	MythologyRegister.registerItem(ma.sapphireHelmet);
    	MythologyRegister.registerItem(ma.sapphireChestplate);
    	MythologyRegister.registerItem(ma.sapphireLeggings);
    	MythologyRegister.registerItem(ma.sapphireBoots);
		
		//Sword
		MythologyRegister.registerItem(mt.swordBronze); 
    	MythologyRegister.registerItem(mt.shovelCelestialBronze); 
    	MythologyRegister.registerItem(mt.shovelImperialGold); 
    	MythologyRegister.registerItem(mt.swordSilver); 
    	MythologyRegister.registerItem(mt.swordRuby);
    	MythologyRegister.registerItem(mt.swordSapphire);
    	
    	//Pickaxe
    	MythologyRegister.registerItem(mt.pickaxeBronze); 
    	MythologyRegister.registerItem(mt.pickaxeCelestialBronze); 
    	MythologyRegister.registerItem(mt.pickaxeImperialGold); 
    	MythologyRegister.registerItem(mt.pickaxeSilver); 
    	MythologyRegister.registerItem(mt.pickaxeRuby);
    	MythologyRegister.registerItem(mt.pickaxeSapphire);
    	
    	//Shovel
    	MythologyRegister.registerItem(mt.shovelBronze); 
    	MythologyRegister.registerItem(mt.shovelCelestialBronze); 
    	MythologyRegister.registerItem(mt.shovelImperialGold); 
    	MythologyRegister.registerItem(mt.shovelSilver); 
    	MythologyRegister.registerItem(mt.shovelRuby);
    	MythologyRegister.registerItem(mt.shovelSapphire);
    	
    	//Axe
    	MythologyRegister.registerItem(mt.axeBronze); 
    	MythologyRegister.registerItem(mt.axeCelestialBronze); 
    	MythologyRegister.registerItem(mt.axeImperialGold); 
    	MythologyRegister.registerItem(mt.axeSilver); 
    	MythologyRegister.registerItem(mt.axeRuby);
    	MythologyRegister.registerItem(mt.axeSapphire);
    	
    	//Hoe
    	MythologyRegister.registerItem(mt.hoeBronze); 
    	MythologyRegister.registerItem(mt.hoeCelestialBronze); 
    	MythologyRegister.registerItem(mt.hoeImperialGold); 
    	MythologyRegister.registerItem(mt.hoeSilver); 
    	MythologyRegister.registerItem(mt.hoeRuby);
    	MythologyRegister.registerItem(mt.hoeSapphire);
    	
    	//Ingots
    	MythologyRegister.registerItem(mii.itemCopperIngot);
    	MythologyRegister.registerItem(mii.itemTinIngot);
    	MythologyRegister.registerItem(mii.itemBronzeIngot); 
    	MythologyRegister.registerItem(mii.itemCelestialBronzeIngot); 
    	MythologyRegister.registerItem(mii.itemImperialGoldIngot); 
    	MythologyRegister.registerItem(mii.itemSilverIngot);
    	MythologyRegister.registerItem(mii.itemMithrilIngot);
    	MythologyRegister.registerItem(mii.itemPlatinumIngot);
    	MythologyRegister.registerItem(mii.itemRuby);
		MythologyRegister.registerItem(mii.itemSapphire);
    	
    	//mithril shizzle
    	MythologyRegister.registerItem(mi.itemGnomeBeard);
    	MythologyRegister.registerItem(mi.itemFur);
    	MythologyRegister.registerItem(mi.rawBehemothMeat);
    	MythologyRegister.registerItem(mi.cookBehemothMeat);
    	MythologyRegister.registerItem(mi.itemScales);
		
		MythologyRegister.registerItem(mi.itemMithrilNugget);
    	MythologyRegister.registerItem(mi.itemMithrilChain);
    	MythologyRegister.registerItem(mi.itemMithrilMail);
	}
	
	private static void registerOre() {
		MythologyRegister.registerBlock(mb.blockZincOre);
		MythologyRegister.registerBlock(mb.blockMithrilOre);
		MythologyRegister.registerBlock(mb.blockSilverOre);
		MythologyRegister.registerBlock(mb.blockCopperOre);
		MythologyRegister.registerBlock(mb.blockBronzeOre);
		MythologyRegister.registerBlock(mb.blockTinOre);
		MythologyRegister.registerBlock(mb.blockPlatinumOre);
		MythologyRegister.registerBlock(mb.blockRubyOre);
		MythologyRegister.registerBlock(mb.blockSapphireOre);
		MythologyRegister.registerBlock(mb.blockImperialGoldOre);
		MythologyRegister.registerBlock(mb.blockCelestialBronzeOre);
	}
	
	private static void registerOreDictionary() {
		
    	//Blocks
    	OreDictionary.registerOre("oreZinc", mb.blockZincOre);
    	OreDictionary.registerOre("oreMythril", mb.blockMithrilOre);
    	OreDictionary.registerOre("orerthril", mb.blockMithrilOre);
    	OreDictionary.registerOre("oreCopper", mb.blockCopperOre);
    	OreDictionary.registerOre("oreTin", mb.blockTinOre);
    	OreDictionary.registerOre("oreSilver", mb.blockSilverOre);
    	OreDictionary.registerOre("orePlatinum", mb.blockPlatinumOre);
    	OreDictionary.registerOre("oreRuby", mb.blockRubyOre);
    	OreDictionary.registerOre("oreSapphire", mb.blockSapphireOre);
    	OreDictionary.registerOre("oreCelestialBronze", mb.blockCelestialBronzeOre);
    	OreDictionary.registerOre("oreImperialGold", mb.blockImperialGoldOre);

    	//Items
    	OreDictionary.registerOre("ingotCopper", mii.itemCopperIngot);
    	OreDictionary.registerOre("ingotTin", mii.itemTinIngot);
    	OreDictionary.registerOre("ingotBronze", mii.itemBronzeIngot);
    	OreDictionary.registerOre("ingotCelestialBronze", mii.itemCelestialBronzeIngot);
    	OreDictionary.registerOre("ingotImperialGold", mii.itemImperialGoldIngot);
    	OreDictionary.registerOre("ingotPlatinum", mii.itemPlatinumIngot);
    	OreDictionary.registerOre("ingotMithril", mii.itemMithrilIngot);
    	OreDictionary.registerOre("itemRuby", mii.itemRuby);
    	OreDictionary.registerOre("gemSapphire", mii.itemSapphire);
    	OreDictionary.registerOre("nuggetMythril", mi.itemMithrilNugget);
    	OreDictionary.registerOre("nuggetrthril", mi.itemMithrilNugget);
    	OreDictionary.registerOre("materialrthrilChiain", mi.itemMithrilChain);
    	OreDictionary.registerOre("materialMythrilMail", mi.itemMithrilMail);
	}
	
	private static void registerWorldGenerator() {
		GameRegistry.registerWorldGenerator(new MythicalWorldGen(), 0);
	}
	
	private static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityAlloyFurnace.class, "Alloy Furnace");
	}
	
	private static void registerHandlers() {
		NetworkRegistry.INSTANCE.registerGuiHandler(MythologyMod.instance, new GuiHandler());
	}
	
	private static void registerCraftingRecipes() {
		GameRegistry.addSmelting(mb.blockCopperOre, new ItemStack(mii.itemCopperIngot, 1), 0.7F);
		GameRegistry.addSmelting(mb.blockTinOre, new ItemStack(mii.itemTinIngot, 1), 0.7F);
		GameRegistry.addSmelting(mb.blockCelestialBronzeOre, new ItemStack(mii.itemCelestialBronzeIngot, 1), 1.0F);
		GameRegistry.addSmelting(mb.blockImperialGoldOre, new ItemStack(mii.itemImperialGoldIngot, 1), 1.0F);
		GameRegistry.addSmelting(mb.blockSilverOre, new ItemStack(mii.itemSilverIngot, 1), 0.9F);
		GameRegistry.addSmelting(mi.rawBehemothMeat, new ItemStack(mi.cookBehemothMeat, 1), 1.0F);
		GameRegistry.addSmelting(mb.blockMithrilOre, new ItemStack(mii.itemMithrilIngot, 1), 3.0F);
		GameRegistry.addSmelting(mb.blockPlatinumOre, new ItemStack(mii.itemPlatinumIngot, 1), 0.9F);
		GameRegistry.addSmelting(mb.blockRubyOre, new ItemStack(mii.itemRuby, 2), 0.7F);
		GameRegistry.addSmelting(mb.blockSapphireOre, new ItemStack(mii.itemSapphire, 2), 0.7F);
	}
	
	private static void registerSmeltingRecipes() {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelBronze, 1), new Object[] { "I", "I", "S", 'I', "ingotBronze", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.pickaxeBronze, 1), new Object[] { "III", " S ", " S ", 'I', "ingotBronze", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.axeBronze, 1), new Object[] { "II", "IS", " S", 'I', "ingotBronze", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.hoeBronze, 1), new Object[] { "II", " S", " S", 'I', "ingotBronze", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelBronze, 1), new Object[] { "I", "S", "S", 'I', "ingotBronze", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.swordCelestialBronze, 1), new Object[] { "I", "I", "S", 'I', "ingotCelestialBronze", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.pickaxeCelestialBronze, 1), new Object[] { "III", " S ", " S ", 'I', "ingotCelestialBronze", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.axeCelestialBronze, 1), new Object[] { "II", "IS", " S", 'I', "ingotCelestialBronze", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.hoeCelestialBronze, 1), new Object[] { "II", " S", " S", 'I', "ingotCelestialBronze", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelCelestialBronze, 1), new Object[] { "I", "S", "S", 'I', "ingotCelestialBronze", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.swordImperialGold, 1), new Object[] { "I", "I", "S", 'I', "ingotImperialGold", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.pickaxeImperialGold, 1), new Object[] { "III", " S ", " S ", 'I', "ingotImperialGold", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.axeImperialGold, 1), new Object[] { "II", "IS", " S", 'I', "ingotImperialGold", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.hoeImperialGold, 1), new Object[] { "II", " S", " S", 'I', "ingotImperialGold", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelImperialGold, 1), new Object[] { "I", "S", "S", 'I', "ingotImperialGold", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.swordSilver, 1), new Object[] { "I", "I", "S", 'I', "ingotSilver", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.pickaxeSilver, 1), new Object[] { "III", " S ", " S ", 'I', "ingotSilver", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.axeSilver, 1), new Object[] { "II", "IS", " S", 'I', "ingotSilver", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.hoeSilver, 1), new Object[] { "II", " S", " S", 'I', "ingotSilver", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelSilver, 1), new Object[] { "I", "S", "S", 'I', "ingotSilver", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.bronzeHelmet, 1), new Object[] { "III", "I I", 'I', "ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.bronzeChestplate, 1), new Object[] { "I I", "III", "III", 'I', "ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.bronzeLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.bronzeBoots, 1), new Object[] { "I I", "I I", 'I', "ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.celestialBronzeHelmet, 1), new Object[] { "III", "I I", 'I', "ingotCelestialBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.celestialBronzeChestplate, 1), new Object[] { "I I", "III", "III", 'I', "ingotCelestialBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.celestialBronzeLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "ingotCelestialBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.celestialBronzeBoots, 1), new Object[] { "I I", "I I", 'I', "ingotCelestialBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.imperialGoldHelmet, 1), new Object[] { "III", "I I", 'I', "ingotImperialGold"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.imperialGoldChestplate, 1), new Object[] { "I I", "III", "III", 'I', "ingotImperialGold"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.imperialGoldLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "ingotImperialGold"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.imperialGoldBoots, 1), new Object[] { "I I", "I I", 'I', "ingotImperialGold"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.silverHelmet, 1), new Object[] { "III", "I I", 'I', "ingotSilver"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.silverChestplate, 1), new Object[] { "I I", "III", "III", 'I', "ingotSilver"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.silverLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "ingotSilver"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.silverBoots, 1), new Object[] { "I I", "I I", 'I', "ingotSilver"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.mithrilHelmet, 1), new Object[] { "III", "I I", 'I', "materialMythrilMail"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.mithrilChestplate, 1), new Object[] { "I I", "III", "III", 'I', "materialMythrilMail"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.mithrilLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "materialMythrilMail"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ma.mithrilBoots, 1), new Object[] { "I I", "I I", 'I', "materialMythrilMail"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(mi.itemMithrilNugget, 9), new Object[]{"ingotMythril"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mi.itemMithrilChain, 3), new Object[] { " I ", "I I", " I ", 'I', "nuggetMythril"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mi.itemMithrilMail, 1), new Object[] { "III", "III", "III", 'I', "materialrthrilChain"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockBronzeBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockCelestialBronzeBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotCelestialBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockImperialGoldBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotImperialGold"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockPlatinumBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotPlatinum"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockSilverBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotSilver"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockRubyBlock, 1), new Object[] { "III", "III", "III", 'I', "geruby"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockSapphireBlock, 1), new Object[] { "III", "III", "III", 'I', "gemSapphire"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.swordRuby, 1), new Object[] { "I", "I", "S", 'I', "geruby", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.pickaxeRuby, 1), new Object[] { "III", " S ", " S ", 'I', "geruby", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.axeRuby, 1), new Object[] { "II", "IS", " S", 'I', "geruby", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.hoeRuby, 1), new Object[] { "II", " S", " S", 'I', "geruby", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelRuby, 1), new Object[] { "I", "S", "S", 'I', "geruby", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.swordSapphire, 1), new Object[] { "I", "I", "S", 'I', "gemSapphire", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.pickaxeSapphire, 1), new Object[] { "III", " S ", " S ", 'I', "gemSapphire", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.axeSapphire, 1), new Object[] { "II", "IS", " S", 'I', "gemSapphire", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.hoeSapphire, 1), new Object[] { "II", " S", " S", 'I', "gemSapphire", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelSapphire, 1), new Object[] { "I", "S", "S", 'I', "gemSapphire", 'S', Items.stick}));
	}
}
