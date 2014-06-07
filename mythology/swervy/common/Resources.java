package mythology.swervy.common;

import mythology.MythologyMod;
import mythology.init.MythicalTools;
import mythology.swervy.biomes.BiomeUnderworld;
import mythology.swervy.blocks.*;
import mythology.swervy.items.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;

public class Resources {
	
	private static MythologyMod m = new MythologyMod();
	
	public static final String MineraftForgeVersion = MinecraftForge.getBrandingVersion().replace("Minecraft Forge", "");
	
	public static BiomeGenBase BiomeUnderworld = new BiomeUnderworld(154).setBiomeName("Undead Walking Land");
	
	public static Item underworldFlintAndBronze = new ItemFlintAndBronze("itemFlintAndBronze");
	
	public static Block blockPortal = new PortalBlock("underworldPortal", Material.portal);
	public static Block blockBlueFire = new BlueFireBlock("underworldFire", Material.fire) ;
	
	public static Block blockMagicWorkbench = new MagicWorkbenchBlock("Magic Table") ;
	
	//Blocks
	public static Block blockDeadGrass = new DeadGrassBlock("deadGrass", Material.grass);
	public static Block blockDeadDirt = new DeadDirtBlock("deadDirt", Material.ground).setHardness(0.6F).setStepSound(Blocks.gravel.stepSound);
	public static Block blockDeadStone = new DeadStoneBlock("deadStone", Material.rock);
	public static Block blockDeadRack = new DeadRackBlock("deadRack", Material.rock);
	
	public static Block blockDeadLog = new DeadLogBlock();
	public static Block blockDeadLeaf = new DeadLeafBlock();
	public static Block blockDeadSapling = new DeadSaplingBlock("deadSapling", Material.leaves);
	
	//Items
	public static ItemPaxel paxelBronze = new ItemPaxel("paxelBronze", MythicalTools.toolBronze);
	public static ItemPaxel paxelCelestialBronze = new ItemPaxel("paxelCelestialBronze", MythicalTools.toolCelestialBronze);
	public static ItemPaxel paxelImperialGold = new ItemPaxel("paxelImperialGold", MythicalTools.toolImperialGold);
	public static ItemPaxel paxelSilver = new ItemPaxel("paxelSilver", MythicalTools.toolSilver);
	public static ItemPaxel paxelRuby = new ItemPaxel("paxelRuby", MythicalTools.toolRuby);
	public static ItemPaxel paxelSapphire = new ItemPaxel("paxelSapphire", MythicalTools.toolSapphire);
	
}
