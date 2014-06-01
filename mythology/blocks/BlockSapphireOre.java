package mythology.blocks;

import java.util.Random;

import mythology.MythologyMod;
import mythology.init.MythicalIngot;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class BlockSapphireOre extends MythBlock {

	MythologyMod m = new MythologyMod();
	MythicalIngot mii = new MythicalIngot();

	public BlockSapphireOre(String string, CreativeTabs tabMythical, Material rock) {
		super(rock, string);
		this.setBlockName(string);
		this.setBlockTextureName(m.modid + ":" + string);
		this.setCreativeTab(tabMythical);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(3.0F);
		this.setStepSound(soundTypeStone);
	}
	@Override
	public Item getItemDropped(int par1, Random par2, int par3)
	{
		return mii.itemSapphire;
		
	}
	
}
