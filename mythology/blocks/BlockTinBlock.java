package mythology.blocks;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTinBlock extends Block{

	private MythologyMod m = new MythologyMod();

	public BlockTinBlock(String string, CreativeTabs tabMythical, Material rock) {
		super(rock);
		this.setBlockName(string);
		this.setBlockTextureName(m.modid + ":" + string);
		this.setCreativeTab(tabMythical);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(3.0F);
		this.setStepSound(soundTypeStone);
	}
}
