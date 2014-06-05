package mythology.items;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
import net.minecraft.item.Item;

public class MythUnobtainableItem extends Item {
	public MythUnobtainableItem(String name){
		setTextureName(MythologyMod.modid + ":" + name);
		setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
	}
}
