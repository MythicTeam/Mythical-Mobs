package mythology.swervy.blocks;

import mythology.MythologyMod;
import mythology.blocks.MythBlock;
import mythology.init.MythicalBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class UnderworldBlock extends MythBlock {

	MythologyMod m = new MythologyMod();

	public UnderworldBlock(String name, Material material) {
		super(material, name);
		this.setBlockTextureName(m.modid + ":underworld/" + name);
		this.setCreativeTab(m.tabMythicalUnderworld);
		this.setLightLevel(0.3F);
	}
}
