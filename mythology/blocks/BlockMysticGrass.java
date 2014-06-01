package mythology.blocks;

import java.util.Random;

import mythology.MythologyMod;
import mythology.init.MythicalBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMysticGrass extends Block {

	MythologyMod m = new MythologyMod();
	MythicalBlocks mb = new MythicalBlocks();
	
	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon iconBottom;
	@SideOnly(Side.CLIENT)
	protected IIcon iconTop;

	String blockname;
	
	public BlockMysticGrass(String name, Material grass) {
		super(grass);
		this.setBlockName(name);
		this.setCreativeTab(m.tabMythical);
		this.setHarvestLevel("shovel", 0);
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
        return side == 1 ? this.iconTop : (side == 0 ? mb.blockMysticDirt.getBlockTextureFromSide(side) : this.blockIcon);
    }
	
	 
	 public Item getItemDropped(int i, Random k, int l)
	    {
	        return mb.blockMysticDirt.getItemDropped(0, k, l);
	    }

	


}
