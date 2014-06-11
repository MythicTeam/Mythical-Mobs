package mythology.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
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
	
	 String string_name;
	
	public MythBlock (String name, CreativeTabs tab, Material material, int harventLevel) {
		super(material);
		string_name = name;
		setBlockName(name);
		GameRegistry.registerBlock(this, name);
		setCreativeTab(tab);
		
		if (name.contains("ore")) {
			this.setBlockTextureName(MythologyMod.modid + ":ores/" + name);
		} else if(name.toLowerCase().contains("block")) {
			this.setBlockTextureName(MythologyMod.modid + ":blocks/" + name);
		}
		
		if(harventLevel == 0) {
			this.setHarvestLevel("pickaxe", 0);
		}else if(harventLevel == 1) {
			this.setHarvestLevel("pickaxe", 1);
		} else if(harventLevel == 2) {
			this.setHarvestLevel("pickaxe", 2);
		} else if(harventLevel == 3) {
			this.setHarvestLevel("pickaxe", 3);
		}
	}
	
	public Item getItemDropped(int par1, Random rand, int par3) {
		if (string_name == "oreRuby") {
			return MythicalIngot.itemRuby;
		} else if(string_name == "crackedStone") {
			return Item.getItemFromBlock(Blocks.cobblestone);
		}
		
		return Item.getItemFromBlock(this);
	}
}
