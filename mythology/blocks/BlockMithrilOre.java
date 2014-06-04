/**
 * 
 */
package mythology.blocks;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


/**
 * @author Paul Onderisin
 *
 */
public class BlockMithrilOre extends MythBlock {
	
	MythologyMod m = new MythologyMod();

	public BlockMithrilOre(String string, CreativeTabs tabMythical, Material rock) {
		super(rock, string);
		this.setBlockName(string);
		this.setBlockTextureName(m.modid + ":oresblocks//" + string);
		this.setCreativeTab(tabMythical);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(3.0F);
		this.setStepSound(soundTypeStone);
	}

}
