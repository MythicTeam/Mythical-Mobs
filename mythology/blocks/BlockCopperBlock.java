package mythology.blocks;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCopperBlock extends MythBlock{

	private MythologyMod m = new MythologyMod();

	public BlockCopperBlock(String string, CreativeTabs tabMythical, Material material) {
		super(string, material);
		this.setBlockName(string);
		this.setBlockTextureName(m.modid + ":blocks/" + string);
		this.setCreativeTab(tabMythical);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(3.0F);
		this.setStepSound(soundTypeStone);
	}
}
