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
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Registration {

	public static final int underworld = 8;
	
	private static Resources r = new Resources();
	
	public static void load() {
		registerBlocks();
		registerItem();
		registerDimension();
		registerBiome();
	}
	
	private static void registerBlocks() {
		MythologyRegister.registerBlock(r.blockDeadStone);
		MythologyRegister.registerBlock(r.blockBlueFire);
	}
	
	private static void registerItem() {
		MythologyRegister.registerItem(r.underworldFlintAndBronze);
	}
	
	private static void registerDimension() {
		//Dimension
		GameRegistry.registerBlock(r.blockPortial, "underworldPortal");
		LanguageRegistry.addName(r.blockPortial, "Underworld Portal");
		
		//Dimension
		DimensionManager.registerProviderType(underworld, WorldProviderUnderworld.class, false);
		DimensionManager.registerDimension(underworld, underworld);
	}
	
	public static void registerBiome() {
		BiomeDictionary.registerBiomeType(r.BiomeUnderworld, Type.FOREST);
		
	}
	
	
}
