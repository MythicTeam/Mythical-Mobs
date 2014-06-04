package mythology.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
import mythology.init.MythicalArmor;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class MithrilArmor extends ItemArmor{
	
	MythologyMod m = new MythologyMod();
	MythicalArmor ma = new MythicalArmor();
	
	public MithrilArmor(ArmorMaterial material, int id, int armorslot) {
		super(material, id, armorslot);
		this.setCreativeTab(m.tabMythical);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ma.mithrilHelmet, 1), new Object[] { "III", "I I", 'I', "materialMythrilMail"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ma.mithrilChestplate, 1), new Object[] { "I I", "III", "III", 'I', "materialMythrilMail"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ma.mithrilLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "materialMythrilMail"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ma.mithrilBoots, 1), new Object[] { "I I", "I I", 'I', "materialMythrilMail"}));
	}
	public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
		if(armor.getItem() == ma.mithrilLeggings) {
			return "mythical:textures/models/armor/Mithril_armor_layer_2.png";
		} else {
			return "mythical:textures/models/armor/Mithril_armor_layer_1.png";
		}
	}
}
