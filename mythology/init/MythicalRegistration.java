package mythology.init;

import mythology.swervy.common.Registration;
import mythology.MythologyMod;
import mythology.handlers.GuiHandler;
import mythology.handlers.MythEventHandler;
import mythology.mobs.hostile.EntityCentaur;
import mythology.mobs.hostile.EntityMinotaur;
import mythology.mobs.hostile.EntityUnderworldSheep;
import mythology.mobs.passive.EntityFairy;
import mythology.mobs.passive.EntityGnome;
import mythology.swervy.dimension.WorldProviderUnderworld;
import mythology.tileentities.TileEntityAlloyFurnace;
import mythology.world.MythicalWorldGen;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MythicalRegistration {
	
	private static MythologyMod m = new MythologyMod();
	private static MythicalArmor ma = new MythicalArmor();
	private static MythicalBlocks mb = new MythicalBlocks();
	private static MythicalItems mi = new MythicalItems();
	private static MythicalTools mt = new MythicalTools();
	private static MythicalIngot mii = new MythicalIngot();

	public static void load() {
		Registration.load();
		
		registerCraftingRecipes(); //Registers Crafting Recipes
		registerSmeltingRecipes(); //Registers Smelting Recipes
		registerWorldGenerator();  //Registers World Generators
		registerTileEntity(); //Registers Tite Entities
		registerHandlers(); //Registers Hanlders
		registerMob(); //Registers Mobs
	}
	
	
	
	private static void registerMob() {
		MythologyRegister.addMob(EntityGnome.class, "Gnome", EnumCreatureType.creature, BiomeGenBase.roofedForest, 0xFC0A16, 0xFCFCFC, 20, 20, 20);
		MythologyRegister.addMob(EntityCentaur.class, "Centaur", EnumCreatureType.monster, BiomeGenBase.megaTaiga, 0x1A33D6, 0x1AD63F, 20, 20, 20);
		MythologyRegister.addMob(EntityFairy.class, "Fairy", EnumCreatureType.creature, BiomeGenBase.forest, 0x07FA10, 0xE9F5E9, 20, 20, 20);
		MythologyRegister.addMob(EntityMinotaur.class, "Minotaur", EnumCreatureType.monster, BiomeGenBase.extremeHillsPlus, 0x835C3B, 0xD1D0CE, 20, 20, 20);
		MythologyRegister.addMob(EntityUnderworldSheep.class, "Underworld Sheep", EnumCreatureType.creature, MythicalBiomes.BiomeUnderworld, 0xFFFFFF, 0xFFFFFF, 20, 2, 6);
	}
	
	private static void registerArmor() {		
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
	}
	
	private static void registerWorldGenerator() {
		GameRegistry.registerWorldGenerator( new MythicalWorldGen(), 0);
	}
	
	private static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityAlloyFurnace.class, "Alloy Furnace");
	}
	
	private static void registerHandlers() {
		NetworkRegistry.INSTANCE.registerGuiHandler(MythologyMod.instance, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new MythEventHandler());
	}
	
	private static void registerSmeltingRecipes() {
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
	
	private static void registerCraftingRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.shovelBronze, 1), new Object[] { "I", "I", "S", 'I', "ingotBronze", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.pickaxeBronze, 1), new Object[] { "III", " S ", " S ", 'I', "ingotBronze", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.axeBronze, 1), new Object[] { "II", "IS", " S", 'I', "ingotBronze", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.hoeBronze, 1), new Object[] { "II", " S", " S", 'I', "ingotBronze", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.shovelBronze, 1), new Object[] { "I", "S", "S", 'I', "ingotBronze", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.swordCelestialBronze, 1), new Object[] { "I", "I", "S", 'I', "ingotCelestialBronze", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.pickaxeCelestialBronze, 1), new Object[] { "III", " S ", " S ", 'I', "ingotCelestialBronze", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.axeCelestialBronze, 1), new Object[] { "II", "IS", " S", 'I', "ingotCelestialBronze", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.hoeCelestialBronze, 1), new Object[] { "II", " S", " S", 'I', "ingotCelestialBronze", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.shovelCelestialBronze, 1), new Object[] { "I", "S", "S", 'I', "ingotCelestialBronze", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.swordImperialGold, 1), new Object[] { "I", "I", "S", 'I', "ingotImperialGold", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.pickaxeImperialGold, 1), new Object[] { "III", " S ", " S ", 'I', "ingotImperialGold", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.axeImperialGold, 1), new Object[] { "II", "IS", " S", 'I', "ingotImperialGold", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.hoeImperialGold, 1), new Object[] { "II", " S", " S", 'I', "ingotImperialGold", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.shovelImperialGold, 1), new Object[] { "I", "S", "S", 'I', "ingotImperialGold", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.swordSilver, 1), new Object[] { "I", "I", "S", 'I', "ingotSilver", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.pickaxeSilver, 1), new Object[] { "III", " S ", " S ", 'I', "ingotSilver", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.axeSilver, 1), new Object[] { "II", "IS", " S", 'I', "ingotSilver", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.hoeSilver, 1), new Object[] { "II", " S", " S", 'I', "ingotSilver", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.shovelSilver, 1), new Object[] { "I", "S", "S", 'I', "ingotSilver", 'S', Items.stick}));
		
		GameRegistry.addRecipe(new ItemStack(MythicalTools.specialSword, 1), new Object[] { "I", "I", "S", 'I', Blocks.dirt, 'S', Items.stick});

		
		
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(mi.itemMythrilNugget, 9), new Object[]{"ingotMythril"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mi.itemMythrilChain, 3), new Object[] { " I ", "I I", " I ", 'I', "nuggetMythril"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mi.itemMythrilMail, 1), new Object[] { "III", "III", "III", 'I', "materialrthrilChain"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mb.blockBronzeBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mb.blockCelestialBronzeBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotCelestialBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mb.blockImperialGoldBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotImperialGold"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mb.blockPlatinumBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotPlatinum"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mb.blockSilverBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotSilver"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mb.blockRubyBlock, 1), new Object[] { "III", "III", "III", 'I', "geruby"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mb.blockSapphireBlock, 1), new Object[] { "III", "III", "III", 'I', "gemSapphire"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.swordRuby, 1), new Object[] { "I", "I", "S", 'I', "geruby", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.pickaxeRuby, 1), new Object[] { "III", " S ", " S ", 'I', "geruby", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.axeRuby, 1), new Object[] { "II", "IS", " S", 'I', "geruby", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.hoeRuby, 1), new Object[] { "II", " S", " S", 'I', "geruby", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.shovelRuby, 1), new Object[] { "I", "S", "S", 'I', "geruby", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.swordSapphire, 1), new Object[] { "I", "I", "S", 'I', "gemSapphire", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.pickaxeSapphire, 1), new Object[] { "III", " S ", " S ", 'I', "gemSapphire", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.axeSapphire, 1), new Object[] { "II", "IS", " S", 'I', "gemSapphire", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.hoeSapphire, 1), new Object[] { "II", " S", " S", 'I', "gemSapphire", 'S', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mt.shovelSapphire, 1), new Object[] { "I", "S", "S", 'I', "gemSapphire", 'S', Items.stick}));
	}
}
