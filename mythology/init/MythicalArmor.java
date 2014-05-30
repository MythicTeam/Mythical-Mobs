package mythology.init;

import mythology.MythologyMod;
import mythology.armor.BronzeArmor;
import mythology.armor.CelestialBronzeArmor;
import mythology.armor.ImperialGoldArmor;
import mythology.armor.MithrilArmor;
import mythology.armor.RubyArmor;
import mythology.armor.SapphireArmor;
import mythology.armor.SilverArmor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MythicalArmor {

	private static ArmorMaterial armorBronze = EnumHelper.addArmorMaterial("BRONZE", 15, new int[]{2, 6, 5, 2}, 15);
	private static ArmorMaterial armorCelestialBronze = EnumHelper.addArmorMaterial("CELESTIALBRONZE", 25, new int[]{3, 6, 5, 3}, 9);
	private static ArmorMaterial armorImperialGold = EnumHelper.addArmorMaterial("IMPERIALGOLD", 25, new int[]{3, 6, 5, 3}, 9);
	private static ArmorMaterial armorSilver = EnumHelper.addArmorMaterial("SILVER", 20, new int[]{3, 6, 5, 2}, 20);
	private static ArmorMaterial armorMithril = EnumHelper.addArmorMaterial("MITHRIL", 100, new int[]{3, 8, 6, 3}, 10);
	private static ArmorMaterial armorRuby = EnumHelper.addArmorMaterial("RUBY", 15, new int[]{2, 6, 5, 2}, 20);
	private static ArmorMaterial armorSapphire = EnumHelper.addArmorMaterial("SAPPHIRE", 15, new int[]{2, 6, 5, 2}, 20);
	
	public static Item bronzeHelmet = new BronzeArmor(armorBronze, 4, 0).setUnlocalizedName("bronzeHelmet").setTextureName(MythologyMod.modid + ":" + "bronzeHelmet");
	public static Item bronzeChestplate = new BronzeArmor(armorBronze, 4, 1).setUnlocalizedName("bronzeChestplate").setTextureName(MythologyMod.modid + ":" + "bronzeChestplate");
	public static Item bronzeLeggings = new BronzeArmor(armorBronze, 4, 2).setUnlocalizedName("bronzeLeggings").setTextureName(MythologyMod.modid + ":" + "bronzeLeggings");
	public static Item bronzeBoots = new BronzeArmor(armorBronze, 4, 3).setUnlocalizedName("bronzeBoots").setTextureName(MythologyMod.modid + ":" + "bronzeBoots");
	public static Item celestialBronzeHelmet = new CelestialBronzeArmor(armorCelestialBronze, 4, 0).setUnlocalizedName("celestialBronzeHelmet").setTextureName(MythologyMod.modid + ":" + "celestialBronzeHelmet");
	public static Item celestialBronzeChestplate = new CelestialBronzeArmor(armorCelestialBronze, 4, 1).setUnlocalizedName("celestialBronzeChestplate").setTextureName(MythologyMod.modid + ":" + "celestialBronzeChestplate");
	public static Item celestialBronzeLeggings = new CelestialBronzeArmor(armorCelestialBronze, 4, 2).setUnlocalizedName("celestialBronzeLeggings").setTextureName(MythologyMod.modid + ":" + "celestialBronzeLeggings");
	public static Item celestialBronzeBoots = new CelestialBronzeArmor(armorCelestialBronze, 4, 3).setUnlocalizedName("celestialBronzeBoots").setTextureName(MythologyMod.modid + ":" + "celestialBronzeBoots");
	public static Item imperialGoldHelmet = new ImperialGoldArmor(armorImperialGold, 4, 0).setUnlocalizedName("imperialGoldHelmet").setTextureName(MythologyMod.modid + ":" + "imperialGoldHelmet");
	public static Item imperialGoldChestplate = new ImperialGoldArmor(armorImperialGold, 4, 1).setUnlocalizedName("imperialGoldChestplate").setTextureName(MythologyMod.modid + ":" + "imperialGoldChestplate");
	public static Item imperialGoldLeggings = new ImperialGoldArmor(armorImperialGold, 4, 2).setUnlocalizedName("imperialGoldLeggings").setTextureName(MythologyMod.modid + ":" + "imperialGoldLeggings");
	public static Item imperialGoldBoots = new ImperialGoldArmor(armorImperialGold, 4, 3).setUnlocalizedName("imperialGoldBoots").setTextureName(MythologyMod.modid + ":" + "imperialGoldBoots");
	public static Item silverHelmet = new SilverArmor(armorSilver, 4, 0).setUnlocalizedName("silverHelmet").setTextureName(MythologyMod.modid + ":" + "silverHelmet");
	public static Item silverChestplate = new SilverArmor(armorSilver, 4, 1).setUnlocalizedName("silverChestplate").setTextureName(MythologyMod.modid + ":" + "silverChestplate");
	public static Item silverLeggings = new SilverArmor(armorSilver, 4, 2).setUnlocalizedName("silverLeggings").setTextureName(MythologyMod.modid + ":" + "silverLeggings");
	public static Item silverBoots = new SilverArmor(armorSilver, 4, 3).setUnlocalizedName("silverBoots").setTextureName(MythologyMod.modid + ":" + "silverBoots");
	public static Item mithrilHelmet = new MithrilArmor(armorMithril, 4, 0).setUnlocalizedName("mithrilHelmet").setTextureName(MythologyMod.modid + ":" + "mithrilHelmet");
	public static Item mithrilChestplate = new MithrilArmor(armorMithril, 4, 1).setUnlocalizedName("mithrilChestplate").setTextureName(MythologyMod.modid + ":" + "mithrilChestplate");
	public static Item mithrilLeggings = new MithrilArmor(armorMithril, 4, 2).setUnlocalizedName("mithrilLeggings").setTextureName(MythologyMod.modid + ":" + "mithrilLeggings");
	public static Item mithrilBoots = new MithrilArmor(armorMithril, 4, 3).setUnlocalizedName("mithrilBoots").setTextureName(MythologyMod.modid + ":" + "mithrilBoots");
	public static Item rubyHelmet = new RubyArmor(armorRuby, 4, 0).setUnlocalizedName("rubyHelmet").setTextureName(MythologyMod.modid + ":" + "rubyHelmet");
	public static Item rubyChestplate = new RubyArmor(armorRuby, 4, 1).setUnlocalizedName("rubyChestplate").setTextureName(MythologyMod.modid + ":" + "rubyChestplate");
	public static Item rubyLeggings = new RubyArmor(armorRuby, 4, 2).setUnlocalizedName("rubyLeggings").setTextureName(MythologyMod.modid + ":" + "rubyLeggings");
	public static Item rubyBoots = new RubyArmor(armorRuby, 4, 3).setUnlocalizedName("rubyBoots").setTextureName(MythologyMod.modid + ":" + "rubyBoots");
	public static Item sapphireHelmet = new SapphireArmor(armorSapphire, 4, 0).setUnlocalizedName("sapphireHelmet").setTextureName(MythologyMod.modid + ":" + "sapphireHelmet");
	public static Item sapphireChestplate = new SapphireArmor(armorSapphire, 4, 1).setUnlocalizedName("sapphireChestplate").setTextureName(MythologyMod.modid + ":" + "sapphireChestplate");
	public static Item sapphireLeggings = new SapphireArmor(armorSapphire, 4, 2).setUnlocalizedName("sapphireLeggings").setTextureName(MythologyMod.modid + ":" + "sapphireLeggings");
	public static Item sapphireBoots = new SapphireArmor(armorSapphire, 4, 3).setUnlocalizedName("sapphireBoots").setTextureName(MythologyMod.modid + ":" + "sapphireBoots");
	
}
