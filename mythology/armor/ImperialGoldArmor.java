package mythology.armor;

import mythology.MythologyMod;
import mythology.init.MythicalArmor;
import mythology.init.MythicalItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.ISpecialArmor;
public class ImperialGoldArmor extends ItemArmor implements ISpecialArmor{
	MythologyMod m = new MythologyMod();
	public ImperialGoldArmor(ArmorMaterial armormaterial, int armorid, int armorslot) {
		super(armormaterial, armorid, armorslot);
		this.setCreativeTab(m.tabMythical);
	}
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
	  if(source == source.inFire || source == source.lava || source == source.onFire) {
		  return new ArmorProperties(1, 1, MathHelper.floor_double(damage * 7.5D)); //the damage * double is the resistance to the damage above
	  }
	  return new ArmorProperties(0, 0, 0);
	}
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 4;
	}
	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		stack.damageItem(damage * 0, entity);
	}

	@Override
	public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
		if(armor.getItem() == MythicalArmor.imperialGoldLeggings) {
			return "mythical:textures/models/armor/ImperialGold_armor_layer_2.png";
		} else {
			return "mythical:textures/models/armor/ImperialGold_armor_layer_1.png";
		}
	}

	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
	  return stack.getItem() == MythicalItems.itemImperialGoldIngot;
	}


}
