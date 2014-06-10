package mythology.blocks;

import mythology.MythologyMod;
import mythology.crafting.MagicTableCraftingManager;
import mythology.init.MythicalBlocks;
import mythology.init.MythicalItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class DeadDirtBlock extends MythBlock {

	MythologyMod m = new MythologyMod();

	public DeadDirtBlock(String name, Material material) {
		super(material, name);
		this.setBlockTextureName(m.modid + ":blocks/underworld/" + name);
		this.setCreativeTab(m.tabMythicalUnderworld);
		this.setLightLevel(0.3F);
		
		MagicTableCraftingManager.getInstance().addRecipe(new ItemStack(this, 1), new Object[] { "x", "f", 'x', Blocks.dirt, 'f', MythicalItems.underworldFlintAndBronze});
	}
}
