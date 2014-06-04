package mythology.blocks;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class BlockTinOre extends MythBlock {
	
	MythologyMod m = new MythologyMod();

	public BlockTinOre(String string, CreativeTabs tabMythical, Material rock) {
		super(rock, string);
		this.setBlockName(string);
		this.setBlockTextureName(m.modid + ":ores/" + string);
		this.setCreativeTab(tabMythical);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(3.0F);
		this.setStepSound(soundTypeStone);
	}

}
