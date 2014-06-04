package mythology.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import mythology.MythologyMod;
import mythology.init.MythicalArmor;

public class BronzeArmor extends ItemArmor{
	MythologyMod m = new MythologyMod();
	MythicalArmor ma = new MythicalArmor();
	public BronzeArmor(ArmorMaterial material, int id, int armorslot) {
		super(material, id, armorslot);
		this.setCreativeTab(m.tabMythical);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ma.bronzeHelmet, 1), new Object[] { "III", "I I", 'I', "ingotBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ma.bronzeChestplate, 1), new Object[] { "I I", "III", "III", 'I', "ingotBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ma.bronzeLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "ingotBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ma.bronzeBoots, 1), new Object[] { "I I", "I I", 'I', "ingotBronze"}));
		
	}
	public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
		if(armor.getItem() == ma.bronzeLeggings) {
			return "mythical:textures/models/armor/Bronze_armor_layer_2.png";
		} else {
			return "mythical:textures/models/armor/Bronze_armor_layer_1.png";
		}
	}
	
	
	
	
	
	
}
