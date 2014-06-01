package mythology.init;

import mythology.MythologyMod;
import mythology.blocks.BlockAlloyFurnace;
import mythology.blocks.BlockBronzeBlock;
import mythology.blocks.BlockBronzeOre;
import mythology.blocks.BlockCelestialBronzeBlock;
import mythology.blocks.BlockCelestialBronzeOre;
import mythology.blocks.BlockCopperBlock;
import mythology.blocks.BlockCopperOre;
import mythology.blocks.BlockImperialGoldBlock;
import mythology.blocks.BlockImperialGoldOre;
import mythology.blocks.BlockMithrilOre;
import mythology.blocks.BlockMysticDirt;
import mythology.blocks.BlockMysticGrass;
import mythology.blocks.BlockPlatinumBlock;
import mythology.blocks.BlockPlatinumOre;
import mythology.blocks.BlockRubyBlock;
import mythology.blocks.BlockRubyOre;
import mythology.blocks.BlockSapphireBlock;
import mythology.blocks.BlockSapphireOre;
import mythology.blocks.BlockSilverBlock;
import mythology.blocks.BlockSilverOre;
import mythology.blocks.BlockTinBlock;
import mythology.blocks.BlockTinOre;
import mythology.blocks.BlockZincOre;
import mythology.blocks.underworld.BlockBlueFire;
import mythology.blocks.underworld.BlockDeadStone;
import mythology.blocks.underworld.BlockPortalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MythicalBlocks {

	private static MythologyMod m = new MythologyMod();
	
	public static Block blockPortial = new BlockPortalBlock("underworldPortal", Material.portal);
	public static Block blockBlueFire = new BlockBlueFire("underworldFire", Material.fire) ;
	
	public static Block blockDeadStone = new BlockDeadStone("deadStone", m.tabMythical, Material.rock);
	
	public static Block blockMithrilOre = new BlockMithrilOre("oreMithril", m.tabMythical, Material.rock);
	public static Block blockZincOre = new BlockZincOre("oreZinc", m.tabMythical, Material.rock);
	public static Block blockSilverOre = new BlockSilverOre("oreSilver", m.tabMythical, Material.rock);
	public static Block blockBronzeOre = new BlockBronzeOre("oreBronze", m.tabMythical, Material.rock);
	public static Block blockCopperOre = new BlockCopperOre("oreCopper", m.tabMythical, Material.rock);
	public static Block blockTinOre = new BlockTinOre("oreTin", m.tabMythical, Material.rock);
	public static Block blockPlatinumOre = new BlockPlatinumOre("orePlatinum", m.tabMythical, Material.rock);
	public static Block blockRubyOre = new BlockRubyOre("oreRuby", m.tabMythical, Material.rock);
	public static Block blockSapphireOre = new BlockSapphireOre("oreSapphire" , m.tabMythical, Material.rock);
	public static Block blockImperialGoldOre = new BlockImperialGoldOre("oreImperialGold", m.tabMythical, Material.rock);
	public static Block blockCelestialBronzeOre = new BlockCelestialBronzeOre("oreCelestialBronze", m.tabMythical, Material.rock);

	public static Block blockMysticGrass = new BlockMysticGrass("MysticGrassBlock", m.tabMythical, Material.ground);
	public static Block blockMysticDirt = new BlockMysticDirt("MysticDirtBlock", m.tabMythical, Material.ground);
	public static Block blockSilverBlock = new BlockSilverBlock("silverBlock", m.tabMythical, Material.iron);
	public static Block blockBronzeBlock = new BlockBronzeBlock("bronzeBlock", m.tabMythical, Material.iron);
	public static Block blockCopperBlock = new BlockCopperBlock("copperBlock", m.tabMythical, Material.iron);
	public static Block blockTinBlock = new BlockTinBlock("tinBlock", m.tabMythical, Material.iron);
	public static Block blockPlatinumBlock = new BlockPlatinumBlock("platinumBlock", m.tabMythical, Material.iron);
	public static Block blockImperialGoldBlock = new BlockImperialGoldBlock("imperialGoldBlock", m.tabMythical, Material.iron);
	public static Block blockCelestialBronzeBlock = new BlockCelestialBronzeBlock("celestialBronzeBlock", m.tabMythical, Material.iron);
	public static Block blockRubyBlock = new BlockRubyBlock("rubyBlock", m.tabMythical, Material.iron);
	public static Block blockSapphireBlock = new BlockSapphireBlock("sapphireBlock", m.tabMythical, Material.iron);
	public static Block alloyFurnaceActive = new BlockAlloyFurnace(true, "alloyFurnaceActive", m.tabMythical, Material.iron).setLightLevel(0.9F).setHardness(3.5F);
	public static Block alloyFurnaceIdle = new BlockAlloyFurnace(false, "alloyFurnaceIdle", m.tabMythical, Material.iron).setHardness(3.5F);
}
