package mythology.blocks;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class BlockPlatinumOre extends MythBlock {

	MythologyMod m = new MythologyMod();
	
	public BlockPlatinumOre(String string, CreativeTabs tabMythical, Material material) {
		super(string, material);
		this.setBlockName(string);
		this.setBlockTextureName(m.modid + ":ores/" + string);
		this.setCreativeTab(tabMythical);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(3.0F);
		this.setStepSound(soundTypeStone);
	}

}
