package mythology.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class DeadRackBlock extends Block {

	MythologyMod m = new MythologyMod();
	
	public DeadRackBlock(String string, Material material) {
		super(material);
		GameRegistry.registerBlock(this, string);
		this.setBlockName(string);
		this.setBlockTextureName(m.modid + ":" + "blocks/underworld/" + string);
		this.setCreativeTab(m.tabMythicalUnderworld);
		this.setHardness(50.0F);
		this.setResistance(2000.0F);
		this.setStepSound(soundTypePiston);
		
		this.setHarvestLevel("pickaxe", 3);
	}
}
