package mythology.swervy.blocks;

import java.util.Random;

import mythology.MythologyMod;
import mythology.init.MythicalBlocks;
import mythology.swervy.common.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDeadGrass extends UnderworldBlock implements IGrowable {

	MythologyMod m = new MythologyMod();
	MythicalBlocks mb = new MythicalBlocks();
	
	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon iconBottom;
	@SideOnly(Side.CLIENT)
	protected IIcon iconTop;

	String blockname;
	
	public BlockDeadGrass(String name, Material material) {
		super(name, material);
		this.setHardness(0.6F);
		this.setStepSound(soundTypeGrass);
        this.setTickRandomly(true);
        blockname = name;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		
		this.blockIcon = iconRegister.registerIcon(m.modid + ":underworld/" + blockname + "_side");
		this.iconTop = iconRegister.registerIcon(m.modid + ":underworld/" + blockname + "_top"); 
		
	}

	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return side == 1 ? this.iconTop : (side == 0 ? Resources.blockDeadDirt.getBlockTextureFromSide(side) : this.blockIcon);
    }
	
	 
	 public Item getItemDropped(int i, Random k, int l)
	    {
	        return Item.getItemFromBlock(Resources.blockDeadDirt);
	    }
	 
	    /**
	     * Ticks the block if it's been scheduled
	     */
	 public void updateTick(World world, int x, int y, int z, Random p_149674_5_)
	 {
		 if (!world.isRemote)
		 {
			 if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
			 {
				 world.setBlock(x, y, z, Resources.blockDeadDirt);
			 }	
			 else if (world.getBlockLightValue(x, y + 1, z) >= 9)
			 {
				 for (int l = 0; l < 4; ++l)
				 {
					 int i1 = x + p_149674_5_.nextInt(3) - 1;
					 int j1 = y + p_149674_5_.nextInt(5) - 3;
					 int k1 = z + p_149674_5_.nextInt(3) - 1;
					 Block block = world.getBlock(i1, j1 + 1, k1);

					 if ((world.getBlock(i1, j1, k1) == Resources.blockDeadDirt || world.getBlock(i1, j1, k1) == Blocks.dirt || world.getBlock(i1, j1, k1) == Blocks.grass) && world.getBlockMetadata(i1, j1, k1) == 0 && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
					 {
						 world.setBlock(i1, j1, k1, Resources.blockDeadGrass);
					 }
				 }
			 }
		 }
	 }

	@Override
	public boolean func_149851_a(World w, int var2, int var3, int var4,	boolean var5) {
		return true;
	}

	@Override
	public boolean func_149852_a(World var1, Random var2, int var3, int var4, int var5) {
		return true;
	}

	@Override
	public void func_149853_b(World var1, Random var2, int var3, int var4, int var5) {
		
	}
}
