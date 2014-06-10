package mythology.swervy.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mythology.MythologyMod;
import mythology.tileentities.TileEntityMagicTable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MagicWorkbenchBlock extends BlockContainer {

	@SideOnly(Side.CLIENT)
    private IIcon SurfaceTop;
    
    private static final String __OBFID = "CL_00000221";
	
	public MagicWorkbenchBlock(String name) {
		super(Material.wood);
		this.setHardness(2.5F);
		this.setStepSound(soundTypeWood);
		this.setCreativeTab(MythologyMod.tabMythical);
		this.setBlockName("MagicTable");
		GameRegistry.registerBlock(this, name);
	}

	/**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return side == 1 ? this.SurfaceTop : this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon(MythologyMod.modid + ":" + "blocks/underworld/" + "deadRack");
    }
    
	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!player.isSneaking()) {
			player.openGui(MythologyMod.instance, MythologyMod.guiMagicTable, world, x, y, z);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new TileEntityMagicTable();
	}
}
