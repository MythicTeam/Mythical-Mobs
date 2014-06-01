package mythology.blocks.underworld;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockDeadStone extends Block {

	MythologyMod m = new MythologyMod();

	public BlockDeadStone(String string, CreativeTabs tabMythical, Material material) {
		super(material);
		this.setBlockName(string);
		this.setBlockTextureName(m.modid + ":" + "underworld/" + string);
		this.setCreativeTab(m.tabMythicalUnderworld);
		this.setHardness(5.0F);
		this.setStepSound(soundTypePiston);
		this.setResistance(10.0F);
		this.setHarvestLevel("pickaxe", 0);
	}

}