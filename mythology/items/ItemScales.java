package mythology.items;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class ItemScales extends Item {
	
	public ItemScales(String string, CreativeTabs tab){
		GameRegistry.registerItem(this, string);

		MythologyMod m = new MythologyMod();
		this.setCreativeTab(tab)
		.setTextureName(m.modid + ":" + string)
		.setUnlocalizedName(string);
		
	}

}
