package mythology.items;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class ItemFur extends Item {
	
	public ItemFur(String string, CreativeTabs tabMythical){
		GameRegistry.registerItem(this, string);
		MythologyMod m = new MythologyMod();
		this.setUnlocalizedName(string)
		.setCreativeTab(m.tabMythical)
		.setTextureName(m.modid + ":" + string);		
	}
}
