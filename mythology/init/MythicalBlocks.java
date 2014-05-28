package mythology.init;

import mythology.MythologyMod;
import mythology.modBlocks.BlockBronzeBlock;
import mythology.modBlocks.BlockCelestialBronzeBlock;
import mythology.modBlocks.BlockCelestialBronzeOre;
import mythology.modBlocks.BlockCopperOre;
import mythology.modBlocks.BlockImperialGoldBlock;
import mythology.modBlocks.BlockImperialGoldOre;
import mythology.modBlocks.BlockMithrilOre;
import mythology.modBlocks.BlockMysticDirt;
import mythology.modBlocks.BlockMysticGrass;
import mythology.modBlocks.BlockPlatinumBlock;
import mythology.modBlocks.BlockPlatinumOre;
import mythology.modBlocks.BlockRubyBlock;
import mythology.modBlocks.BlockRubyOre;
import mythology.modBlocks.BlockSapphireBlock;
import mythology.modBlocks.BlockSapphireOre;
import mythology.modBlocks.BlockSilverBlock;
import mythology.modBlocks.BlockSilverOre;
import mythology.modBlocks.BlockTinOre;
import mythology.modBlocks.BlockZincOre;
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

	}
}
