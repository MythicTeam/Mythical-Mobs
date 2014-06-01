package mythology.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MythBlock extends Block{

	protected MythBlock(Material material, String name) {
		super(material);
		GameRegistry.registerBlock(this, name);
		setCreativeTab(MythologyMod.tabMythical);
		setBlockName(name);
		setBlockTextureName(MythologyMod.modid + ":" + name);
	}
}
