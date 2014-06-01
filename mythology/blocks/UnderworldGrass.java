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

public class UnderworldGrass extends UnderworldBlock {

	MythologyMod m = new MythologyMod();
	MythicalBlocks mb = new MythicalBlocks();
	
	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon iconBottom;
	@SideOnly(Side.CLIENT)
	protected IIcon iconTop;

	String blockname;
	
	public UnderworldGrass(String name, Material material) {
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
        return side == 1 ? this.iconTop : (side == 0 ? mb.underworldDirt.getBlockTextureFromSide(side) : this.blockIcon);
    }
	
	 
	 public Item getItemDropped(int i, Random k, int l)
	    {
	        return Item.getItemFromBlock(mb.underworldDirt);
	    }
}
