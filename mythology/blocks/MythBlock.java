package mythology.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

public class MythBlock extends Block{

	protected MythBlock(Material material, String name) {
		super(material);
		GameRegistry.registerBlock(this, name);
		OreDictionary.registerOre(name, this);
		setCreativeTab(MythologyMod.tabMythical);
		setBlockName(name);
	}
}
