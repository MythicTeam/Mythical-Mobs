package mythology.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
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

public class DeadDirtBlock extends Block {

	MythologyMod m = new MythologyMod();

	public DeadDirtBlock(String name, Material material) {
		super(material);
		this.setBlockTextureName(m.modid + ":blocks/underworld/" + name);
		this.setCreativeTab(m.tabMythicalUnderworld);
		this.setLightLevel(0.3F);
		GameRegistry.registerBlock(this, name);
		
		MagicTableCraftingManager.getInstance().addRecipe(new ItemStack(this, 1), new Object[] { "x", "f", 'x', Blocks.dirt, 'f', MythicalItems.underworldFlintAndBronze});
	}
}
