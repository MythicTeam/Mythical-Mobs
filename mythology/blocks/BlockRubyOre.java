package mythology.blocks;

import java.util.Random;

import mythology.MythologyMod;
import mythology.init.MythicalBlocks;
import mythology.init.MythicalIngot;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class BlockRubyOre extends MythBlock {
	
	MythologyMod m = new MythologyMod();
	MythicalIngot mii = new MythicalIngot();

	public BlockRubyOre(String name, CreativeTabs tabMythical, Material material) {
		super(name, material);
		this.setBlockName(name);
		this.setBlockTextureName(m.modid + ":ores/" + name);
		this.setCreativeTab(tabMythical);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(3.0F);
		this.setStepSound(soundTypeStone);
	}
	@Override
	public Item getItemDropped(int par1, Random par2, int par3)
	{
		return mii.itemRuby;
		
	}
}
