package mythology.swervy.common;

import mythology.MythologyMod;
import mythology.init.MythicalArmor;
import mythology.init.MythicalBiomes;
import mythology.init.MythicalBlocks;
import mythology.init.MythicalIngot;
import mythology.init.MythicalItems;
import mythology.init.MythicalTools;
import mythology.init.MythologyRegister;
import mythology.swervy.dimension.WorldProviderUnderworld;
import mythology.world.MythicalWorldGen;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Registration {

	public static final int underworld = 8;
	
	private static Resources r = new Resources();
	
	public static void load() {
		registerDimension();
		registerBiome();
		registerCraftingRecipes();
		registerWorldGenerator();
	}
	
	private static void registerDimension() {
		//Dimension
		LanguageRegistry.addName(r.blockPortal, "Underworld Portal");
		
		//Dimension
		DimensionManager.registerProviderType(underworld, WorldProviderUnderworld.class, false);
		DimensionManager.registerDimension(underworld, underworld);
	}
	
	public static void registerBiome() {
		BiomeDictionary.registerBiomeType(r.BiomeUnderworld, Type.FOREST);
		
	}
	
	private static void registerCraftingRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(r.blockDeadRack, 7), new Object[] { "xxx", "xsx", "xxx", 'x', Blocks.obsidian, 's', Blocks.stone}));
	}
	
	private static void registerWorldGenerator() {
		
	}
}
