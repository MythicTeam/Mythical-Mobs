package mythology.swervy.common;

import mythology.MythologyMod;
import mythology.swervy.biomes.BiomeUnderworld;
import mythology.swervy.blocks.BlockBlueFire;
import mythology.swervy.blocks.BlockDeadStone;
import mythology.swervy.blocks.BlockPortalBlock;
import mythology.swervy.items.ItemFlintAndBronze;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;

public class Resources {

	private static MythologyMod m = new MythologyMod();
	
	public static BiomeGenBase BiomeUnderworld = new BiomeUnderworld(154).setBiomeName("Apple Forest");
	
	public static Item underworldFlintAndBronze = new ItemFlintAndBronze("itemFlintAndBronze");
	
	public static Block blockPortal = new BlockPortalBlock("underworldPortal", Material.portal);
	public static Block blockBlueFire = new BlockBlueFire("underworldFire", Material.fire) ;
	
	public static Block blockDeadStone = new BlockDeadStone("deadStone", m.tabMythical, Material.rock);
}