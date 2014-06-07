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

	public BlockCopperBlock(String string, CreativeTabs tabMythical, Material rock) {
		super(rock, string);
		this.setBlockName(string);
		this.setBlockTextureName(m.modid + ":blocks/" + string);
		this.setCreativeTab(tabMythical);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(3.0F);
		this.setStepSound(soundTypeStone);
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
        TileEntity tile_entity = world.getTileEntity(x, y, z);
        
        player.openGui(MythologyMod.instance, MythologyMod.guiHelp, world, x, y, z);
        return true;
    }
}
