package mythology.blocks;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCelestialBronzeBlock extends MythBlock {
	MythologyMod m = new MythologyMod();
	public BlockCelestialBronzeBlock(String string, CreativeTabs tabMythical, Material material) {
		super(material, string);
		this.setBlockName(string);
		this.setBlockTextureName(m.modid + ":" + string);
		this.setCreativeTab(tabMythical);
		this.setHardness(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setResistance(10.0F);
	}
}
