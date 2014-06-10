package mythology.swervy.blocks;

import mythology.MythologyMod;
import mythology.blocks.MythBlock;
import mythology.init.MythicalBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class DeadDirtBlock extends MythBlock {

	MythologyMod m = new MythologyMod();

	public DeadDirtBlock(String name, Material material) {
		super(name, material);
		this.setBlockTextureName(m.modid + ":blocks/underworld/" + name);
		this.setCreativeTab(m.tabMythicalUnderworld);
		this.setLightLevel(0.3F);
	}
}
