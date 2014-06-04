package mythology.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
import mythology.init.MythicalArmor;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class SilverArmor extends ItemArmor{
	
	MythologyMod m = new MythologyMod();
	MythicalArmor ma = new MythicalArmor();
	
	public SilverArmor(ArmorMaterial material, int id, int armorslot) {
		super(material, id, armorslot);
		this.setCreativeTab(m.tabMythical);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ma.silverHelmet, 1), new Object[] { "III", "I I", 'I', "ingotSilver"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ma.silverChestplate, 1), new Object[] { "I I", "III", "III", 'I', "ingotSilver"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ma.silverLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "ingotSilver"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ma.silverBoots, 1), new Object[] { "I I", "I I", 'I', "ingotSilver"}));
	}
	public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
		if(armor.getItem() == ma.silverLeggings) {
			return "mythical:textures/models/armor/Silver_armor_layer_2.png";
		} else {
			return "mythical:textures/models/armor/Silver_armor_layer_1.png";
		}
	}
}
