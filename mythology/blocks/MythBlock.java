package mythology.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
import mythology.init.MythicalBlocks;
import mythology.init.MythicalIngot;
import mythology.items.MythItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MythBlock extends Block{
	
	 String unlocalname;
	
	public MythBlock (String name, Material material, int harvestLevel) {
		super(material);
		unlocalname = name;
		setBlockName(name);
		GameRegistry.registerBlock(this, name);
		
		if (name.toLowerCase().contains("ore")) {
			this.setBlockTextureName(MythologyMod.modid + ":ores/" + name);
		} else {
			this.setBlockTextureName(MythologyMod.modid + ":" + name);
		}
	}
	
	public Item getItemDropped(int par1, Random rand, int par3) {
		if (this == MythicalBlocks.blockRubyOre) {
			return MythicalIngot.itemRuby;
		} 
		else if(this == MythicalBlocks.crackedStone) {
			return Item.getItemFromBlock(Blocks.cobblestone);
		}
		else return Item.getItemFromBlock(this);
	}
}
