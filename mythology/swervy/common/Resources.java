package mythology.swervy.common;

import mythology.MythologyMod;
import mythology.init.MythicalTools;
import mythology.swervy.biomes.BiomeUnderworld;
import mythology.swervy.blocks.BlockBlueFire;
import mythology.swervy.blocks.BlockDeadGrass;
import mythology.swervy.blocks.BlockDeadLeaf;
import mythology.swervy.blocks.BlockDeadLog;
import mythology.swervy.blocks.BlockDeadRack;
import mythology.swervy.blocks.BlockDeadSapling;
import mythology.swervy.blocks.BlockDeadStone;
import mythology.swervy.blocks.BlockPortalBlock;
import mythology.swervy.blocks.UnderworldBlock;
import mythology.swervy.items.ItemFlintAndBronze;
import mythology.swervy.items.ItemPaxel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;

public class Resources {
	
	private static MythologyMod m = new MythologyMod();
	
	public static BiomeGenBase BiomeUnderworld = new BiomeUnderworld(154).setBiomeName("Undead Walking Land");
	
	public static Item underworldFlintAndBronze = new ItemFlintAndBronze("itemFlintAndBronze");
	
	public static Block blockPortal = new BlockPortalBlock("underworldPortal", Material.portal);
	public static Block blockBlueFire = new BlockBlueFire("underworldFire", Material.fire) ;
	
	//Blocks
	public static Block blockDeadGrass = new BlockDeadGrass("deadGrass", Material.grass);
	public static Block blockDeadDirt = new UnderworldBlock("deadDirt", Material.ground).setHardness(0.6F).setStepSound(Blocks.gravel.stepSound);
	public static Block blockDeadStone = new BlockDeadStone("deadStone", Material.rock);
	public static Block blockDeadRack = new BlockDeadRack("deadRack", Material.rock);
	
	//Items
	public static ItemPaxel paxelBronze = new ItemPaxel("paxelBronze", MythicalTools.toolBronze);
	public static ItemPaxel paxelCelestialBronze = new ItemPaxel("paxelCelestialBronze", MythicalTools.toolCelestialBronze);
	public static ItemPaxel paxelImperialGold = new ItemPaxel("paxelImperialGold", MythicalTools.toolImperialGold);
	public static ItemPaxel paxelSilver = new ItemPaxel("paxelSilver", MythicalTools.toolSilver);
	public static ItemPaxel paxelRuby = new ItemPaxel("paxelRuby", MythicalTools.toolRuby);
	public static ItemPaxel paxelSapphire = new ItemPaxel("paxelSapphire", MythicalTools.toolSapphire);
	

	
}
