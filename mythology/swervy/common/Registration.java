package mythology.swervy.common;

import mythology.MythologyMod;
import mythology.crafting.MagicTableCraftingManager;
import mythology.dimension.WorldProviderUnderworld;
import mythology.init.MythicalArmor;
import mythology.init.MythicalBiomes;
import mythology.init.MythicalBlocks;
import mythology.init.MythicalIngot;
import mythology.init.MythicalItems;
import mythology.init.MythicalTools;
import mythology.init.MythologyRegister;
import mythology.rendering.blocks.RenderMagicWorkbench;
import mythology.tileentities.TileEntityMagicTable;
import mythology.world.MythicalWorldGen;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Registration {

	public static final int underworld = -30;
	
	
	public static void load() {
		registerDimension();
		registerBiome();
		registerCraftingRecipes();
		registerWorldGenerator();
		registerTileEntity();
	}
	
	private static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityMagicTable.class, "MagicWorkbench");
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagicTable.class, new RenderMagicWorkbench());
	}
	
	private static void registerDimension() {
		//Dimension
		LanguageRegistry.addName(MythicalBlocks.blockPortal, "Underworld Portal");
		
		//Dimension
		DimensionManager.registerProviderType(underworld, WorldProviderUnderworld.class, false);
		DimensionManager.registerDimension(underworld, underworld);
	}
	
	public static void registerBiome() {
		BiomeDictionary.registerBiomeType(MythicalBiomes.BiomeUnderworld, Type.FOREST);
		
	}
	
	private static void registerCraftingRecipes() {
		MagicTableCraftingManager.getInstance().addRecipe(new ItemStack(MythicalBlocks.blockDeadGrass, 1), new Object[] { "x", 'x', Items.stick});
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MythicalBlocks.blockDeadRack, 7), new Object[] { "xxx", "xsx", "xxx", 'x', Blocks.obsidian, 's', Blocks.stone}));
	}
	
	private static void registerWorldGenerator() {
		
	}
	
}
