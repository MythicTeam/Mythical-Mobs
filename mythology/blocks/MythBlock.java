package mythology.blocks;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MythBlock extends Block{
	
	public MythBlock (String name, Material material) {
		super(material);
		setBlockName(name);
		setBlockTextureName(MythologyMod.modid + ":" + name);
		GameRegistry.registerBlock(this, name);
		setCreativeTab(MythologyMod.tabMythical);
		setHardness(1.0F);
	}
}
