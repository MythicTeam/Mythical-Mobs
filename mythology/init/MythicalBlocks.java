package mythology.init;

import mythology.MythologyMod;
import mythology.blocks.BlockAlloyFurnace;
import mythology.blocks.BlockBronzeBlock;
import mythology.blocks.BlockCelestialBronzeBlock;
import mythology.blocks.BlockCelestialBronzeOre;
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
import mythology.blocks.BlockTinOre;
import mythology.blocks.BlockZincOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class MythicalBlocks {
	
	public static Block blockZincOre;
	public static Block blockMithrilOre;
	public static Block blockSilverOre;
	public static Block blockCopperOre;
	public static Block blockTinOre;
	public static Block blockPlatinumOre;
	public static Block blockRubyOre;
	public static Block blockSapphireOre;
	public static Block blockImperialGoldOre;
	public static Block blockCelestialBronzeOre;
	public static Block blockMysticGrass;
	public static Block blockMysticDirt;
	public static Block blockSilverBlock;
	public static Block blockBronzeBlock;
	public static Block blockPlatinumBlock;
	public static Block blockImperialGoldBlock;
	public static Block blockCelestialBronzeBlock;
	public static Block blockRubyBlock;
	public static Block blockSapphireBlock;
	public static Block blockCopperBlock;
	public static Block blockTinBlock;
	public static Block alloyFurnaceIdle;
	public static Block alloyFurnaceActive;

	
	private static MythologyMod m = new MythologyMod();
	
	public static void add(){

		blockMithrilOre = new BlockMithrilOre("oreMithril", m.tabMythical, Material.rock);
		blockZincOre = new BlockZincOre("oreZinc", m.tabMythical, Material.rock);
		blockSilverOre = new BlockSilverOre("oreSilver", m.tabMythical, Material.rock);
		blockCopperOre = new BlockCopperOre("oreCopper", m.tabMythical, Material.rock);
		blockTinOre = new BlockTinOre("oreTin", m.tabMythical, Material.rock);
		blockPlatinumOre = new BlockPlatinumOre("orePlatinum", m.tabMythical, Material.rock);
		blockRubyOre = new BlockRubyOre("oreRuby", m.tabMythical, Material.rock);
		blockSapphireOre = new BlockSapphireOre("oreSapphire" , m.tabMythical, Material.rock);
		blockImperialGoldOre = new BlockImperialGoldOre("oreImperialGold", m.tabMythical, Material.rock);
		blockCelestialBronzeOre = new BlockCelestialBronzeOre("oreCelestialBronze", m.tabMythical, Material.rock);
		blockMysticGrass = new BlockMysticGrass("blockMysticGrass", m.tabMythical, Material.grass);
		blockMysticDirt = new BlockMysticDirt("blockMysticDirt", m.tabMythical, Material.ground);
		blockSilverBlock = new BlockSilverBlock("silverBlock", m.tabMythical, Material.iron);
		blockBronzeBlock = new BlockBronzeBlock("bronzeBlock", m.tabMythical, Material.iron);
		blockCopperBlock = new BlockSilverBlock("copperBlock", m.tabMythical, Material.iron);
		blockTinBlock = new BlockBronzeBlock("tinBlock", m.tabMythical, Material.iron);
		blockPlatinumBlock = new BlockPlatinumBlock("platinumBlock", m.tabMythical, Material.iron);
		blockImperialGoldBlock = new BlockImperialGoldBlock("imperialGoldBlock", m.tabMythical, Material.iron);
		blockCelestialBronzeBlock = new BlockCelestialBronzeBlock("celestialBronzeBlock", m.tabMythical, Material.iron);
		blockRubyBlock = new BlockRubyBlock("rubyBlock", m.tabMythical, Material.iron);
		blockSapphireBlock = new BlockSapphireBlock("sapphireBlock", m.tabMythical, Material.iron);
		alloyFurnaceActive = new BlockAlloyFurnace(true, "alloyFurnaceActive", m.tabMythical, Material.iron).setLightLevel(0.9F).setHardness(3.5F);
		alloyFurnaceIdle = new BlockAlloyFurnace(false, "alloyFurnaceIdle", m.tabMythical, Material.iron).setHardness(3.5F);

	}
	public static void register(){
		GameRegistry.registerBlock(blockZincOre, "oreZinc");
		GameRegistry.registerBlock(blockMithrilOre, "oreMithril");
		GameRegistry.registerBlock(blockSilverOre, "oreSilver");
		GameRegistry.registerBlock(blockCopperOre, "oreCopper");
		GameRegistry.registerBlock(blockTinOre, "oreTin");
		GameRegistry.registerBlock(blockPlatinumOre, "orePlatinum");
		GameRegistry.registerBlock(blockRubyOre, "oreRuby");
		GameRegistry.registerBlock(blockSapphireOre, "oreSapphire");
		GameRegistry.registerBlock(blockImperialGoldOre, "oreImperialGold");
		GameRegistry.registerBlock(blockCelestialBronzeOre, "oreCelestialBronze");
		GameRegistry.registerBlock(blockMysticGrass, "blockMysticGrass");
		GameRegistry.registerBlock(blockMysticDirt, "blockMysticDirt");
		GameRegistry.registerBlock(blockBronzeBlock, "blockBronzeBlock");
		GameRegistry.registerBlock(blockCelestialBronzeBlock, "blockCelestialBronzeBlock");
		GameRegistry.registerBlock(blockImperialGoldBlock, "blockImperialGoldBlock");
		GameRegistry.registerBlock(blockPlatinumBlock, "blockPlatinumBlock");
		GameRegistry.registerBlock(blockSilverBlock, "blockSilverBlock");
		GameRegistry.registerBlock(blockRubyBlock, "blockRubyBlock");
		GameRegistry.registerBlock(blockSapphireBlock, "blockSapphireBlock");
		GameRegistry.registerBlock(blockCopperBlock, "blockCopperBlock");
		GameRegistry.registerBlock(blockTinBlock, "blockTinBlock");
		GameRegistry.registerBlock(alloyFurnaceActive, "alloyFurnaceActive");
		GameRegistry.registerBlock(alloyFurnaceIdle, "alloyFurnaceIdle");

	}
}
