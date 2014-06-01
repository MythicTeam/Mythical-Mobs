package mythology.blocks;

import mythology.MythologyMod;
import mythology.init.MythicalBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class UnderworldBlock extends MythBlock {

	MythologyMod m = new MythologyMod();

	public UnderworldBlock(String name) {
		super(Material.ground, name);
		this.setBlockTextureName(m.modid + ":underworld/" + name);
		this.setCreativeTab(m.tabMythical);
	}
}
