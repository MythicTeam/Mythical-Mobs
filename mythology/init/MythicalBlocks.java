package mythology.init;

import mythology.MythologyMod;
import mythology.blocks.BlockAlloyFurnace;
import mythology.blocks.BlueFireBlock;
import mythology.blocks.DeadDirtBlock;
import mythology.blocks.DeadGrassBlock;
import mythology.blocks.DeadLeafBlock;
import mythology.blocks.DeadLogBlock;
import mythology.blocks.DeadRackBlock;
import mythology.blocks.DeadSaplingBlock;
import mythology.blocks.DeadStoneBlock;
import mythology.blocks.MagicWorkbenchBlock;
import mythology.blocks.MythBlock;
import mythology.blocks.PortalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class MythicalBlocks {

	private static MythologyMod m = new MythologyMod();
	
	public static Block blockMithrilOre = new MythBlock("oreMithril", Material.rock, 2).setHardness(3.0F).setStepSound(Block.soundTypeStone);;
	public static Block blockZincOre = new MythBlock("oreZinc", Material.rock, 2).setHardness(3.0F).setStepSound(Block.soundTypeStone);;
	public static Block blockSilverOre = new MythBlock("oreSilver", Material.rock, 2).setHardness(3.0F).setStepSound(Block.soundTypeStone);;
	public static Block blockBronzeOre = new MythBlock("oreBronze", Material.rock, 2).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal);
	public static Block blockCopperOre = new MythBlock("oreCopper", Material.rock, 1).setHardness(3.0F).setStepSound(Block.soundTypeStone);;
	public static Block blockTinOre = new MythBlock("oreTin", Material.rock, 1).setHardness(3.0F).setStepSound(Block.soundTypeStone);
	public static Block blockPlatinumOre = new MythBlock("orePlatinum", Material.rock, 2).setHardness(3.0F).setStepSound(Block.soundTypeStone);;
	public static Block blockRubyOre = new MythBlock("oreRuby", Material.rock, 2).setHardness(3.0F).setStepSound(Block.soundTypeStone);
	public static Block blockSapphireOre = new MythBlock("oreSapphire" , Material.rock, 2).setHardness(3.0F).setStepSound(Block.soundTypeStone);
	public static Block blockImperialGoldOre = new MythBlock("oreImperialGold", Material.rock, 2).setHardness(3.0F).setStepSound(Block.soundTypeStone);;
	public static Block blockCelestialBronzeOre = new MythBlock("oreCelestialBronze", Material.rock, 2).setHardness(3.0F).setStepSound(Block.soundTypeStone);

	public static Block blockSilverBlock = new MythBlock("silverBlock", Material.iron, 2).setHardness(5.0F).setStepSound(Block.soundTypeStone).setResistance(10.0F);
	public static Block blockBronzeBlock = new MythBlock("bronzeBlock", Material.iron, 2).setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(10.0F);
	public static Block blockCopperBlock = new MythBlock("copperBlock", Material.iron, 1).setHardness(3.0F).setStepSound(Block.soundTypeStone);
	public static Block blockTinBlock = new MythBlock("tinBlock", Material.iron, 1).setHardness(3.0F).setStepSound(Block.soundTypeStone);
	public static Block blockPlatinumBlock = new MythBlock("platinumBlock", Material.iron, 2).setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(10.0F);
	public static Block blockImperialGoldBlock = new MythBlock("imperialGoldBlock", Material.iron, 2).setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(10.0F);
	public static Block blockCelestialBronzeBlock = new MythBlock("celestialBronzeBlock", Material.iron, 2).setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(10.0F);
	public static Block blockRubyBlock = new MythBlock("rubyBlock", Material.iron, 2).setHardness(5.0F).setStepSound(Block.soundTypeStone).setResistance(10.0F);
	public static Block blockSapphireBlock = new MythBlock("sapphireBlock", Material.iron, 2).setHardness(5.0F).setStepSound(Block.soundTypeStone).setResistance(10.0F);
	public static Block alloyFurnaceActive = new BlockAlloyFurnace(true, "alloyFurnaceActive", Material.iron).setLightLevel(0.9F).setHardness(3.5F);
	public static Block alloyFurnaceIdle = new BlockAlloyFurnace(false, "alloyFurnaceIdle", Material.iron).setHardness(3.5F);
	
	public static Block crackedStone = new MythBlock("crackedStone", Material.rock, 1).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston);

	public static Block blockDeadGrass = new DeadGrassBlock("deadGrass", Material.grass);
	public static Block blockDeadDirt = new DeadDirtBlock("deadDirt", Material.ground).setHardness(0.6F).setStepSound(Blocks.gravel.stepSound);
	public static Block blockDeadStone = new DeadStoneBlock("deadStone", Material.rock);
	public static Block blockDeadRack = new DeadRackBlock("deadRack", Material.rock);
	public static Block blockDeadLog = new DeadLogBlock();
	public static Block blockDeadLeaf = new DeadLeafBlock();
	public static Block blockDeadSapling = new DeadSaplingBlock("deadSapling", Material.leaves);
	public static Block blockPortal = new PortalBlock("underworldPortal", Material.portal);
	public static Block blockBlueFire = new BlueFireBlock("underworldFire", Material.fire) ;
	public static Block blockMagicWorkbench = new MagicWorkbenchBlock("Magic Table") ;
}
