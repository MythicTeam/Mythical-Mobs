package mythology.blocks;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSilverBlock extends MythBlock {
	MythologyMod m = new MythologyMod();
	public BlockSilverBlock(String string, CreativeTabs tabMythical, Material material) {
		super(string, material);
		this.setBlockName(string);
		this.setBlockTextureName(m.modid + ":blocks/" + string);
		this.setCreativeTab(tabMythical);
		this.setHardness(5.0F);
		this.setStepSound(soundTypeStone);
		this.setResistance(10.0F);
	}

}
