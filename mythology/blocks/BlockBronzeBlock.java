package mythology.blocks;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBronzeBlock extends MythBlock {
	MythologyMod m = new MythologyMod();
	public BlockBronzeBlock(String string, CreativeTabs tabMythical, Material material) {
		super(string, material);
		this.setBlockName(string);
		this.setCreativeTab(tabMythical);
		this.setHardness(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setResistance(10.0F);
	}

}
