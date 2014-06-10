package mythology.blocks;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTinBlock extends MythBlock{

	private MythologyMod m = new MythologyMod();

	public BlockTinBlock(String string, CreativeTabs tabMythical, Material material) {
		super(string, material);
		this.setBlockName(string);
		this.setBlockTextureName(m.modid + ":blocks/" + string);
		this.setCreativeTab(tabMythical);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(3.0F);
		this.setStepSound(soundTypeStone);
	}
}
