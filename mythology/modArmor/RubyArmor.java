package mythology.modArmor;

import mythology.MythologyMod;
import mythology.init.MythicalArmor;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class RubyArmor extends ItemArmor{
	MythologyMod m = new MythologyMod();
	public RubyArmor(ArmorMaterial material, int id, int armorslot) {
		super(material, id, armorslot);
		this.setCreativeTab(m.tabMythical);
	}
	public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
		if(armor.getItem() == MythicalArmor.rubyLeggings) {
			return "mythical:textures/models/armor/Ruby_armor_layer_2.png";
		} else {
			return "mythical:textures/models/armor/Ruby_armor_layer_1.png";
		}
	}
}
