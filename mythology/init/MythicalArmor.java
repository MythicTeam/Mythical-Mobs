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
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class MythicalArmor {
	
	public static Item bronzeHelmet;
	public static Item bronzeChestplate;
	public static Item bronzeLeggings;
	public static Item bronzeBoots;
	public static Item celestialBronzeHelmet;
	public static Item celestialBronzeChestplate;
	public static Item celestialBronzeLeggings;
	public static Item celestialBronzeBoots;
	public static Item imperialGoldHelmet;
	public static Item imperialGoldChestplate;
	public static Item imperialGoldLeggings;
	public static Item imperialGoldBoots;
	public static Item silverHelmet;
	public static Item silverChestplate;
	public static Item silverLeggings;
	public static Item silverBoots;
	public static Item mithrilHelmet;
	public static Item mithrilChestplate;
	public static Item mithrilLeggings;
	public static Item mithrilBoots;
	public static Item rubyHelmet;
	public static Item rubyChestplate;
	public static Item rubyLeggings;
	public static Item rubyBoots;
	public static Item sapphireHelmet;
	public static Item sapphireChestplate;
	public static Item sapphireLeggings;
	public static Item sapphireBoots;
	
	private static MythologyMod m = new MythologyMod();
	
	public static void add(){
		ArmorMaterial armorBronze = EnumHelper.addArmorMaterial("BRONZE", 15, new int[]{2, 6, 5, 2}, 15);
		ArmorMaterial armorCelestialBronze = EnumHelper.addArmorMaterial("CELESTIALBRONZE", 25, new int[]{3, 6, 5, 3}, 9);
		ArmorMaterial armorImperialGold = EnumHelper.addArmorMaterial("IMPERIALGOLD", 25, new int[]{3, 6, 5, 3}, 9);
		ArmorMaterial armorSilver = EnumHelper.addArmorMaterial("SILVER", 20, new int[]{3, 6, 5, 2}, 20);
		ArmorMaterial armorMithril = EnumHelper.addArmorMaterial("MITHRIL", 100, new int[]{3, 8, 6, 3}, 10);
		ArmorMaterial armorRuby = EnumHelper.addArmorMaterial("RUBY", 15, new int[]{2, 6, 5, 2}, 20);
		ArmorMaterial armorSapphire = EnumHelper.addArmorMaterial("SAPPHIRE", 15, new int[]{2, 6, 5, 2}, 20);
		
		bronzeHelmet = new BronzeArmor(armorBronze, 4, 0).setUnlocalizedName("bronzeHelmet").setTextureName(MythologyMod.modid + ":" + "bronzeHelmet");
		bronzeChestplate = new BronzeArmor(armorBronze, 4, 1).setUnlocalizedName("bronzeChestplate").setTextureName(MythologyMod.modid + ":" + "bronzeChestplate");
		bronzeLeggings = new BronzeArmor(armorBronze, 4, 2).setUnlocalizedName("bronzeLeggings").setTextureName(MythologyMod.modid + ":" + "bronzeLeggings");
		bronzeBoots = new BronzeArmor(armorBronze, 4, 3).setUnlocalizedName("bronzeBoots").setTextureName(MythologyMod.modid + ":" + "bronzeBoots");
		celestialBronzeHelmet = new CelestialBronzeArmor(armorCelestialBronze, 4, 0).setUnlocalizedName("celestialBronzeHelmet").setTextureName(MythologyMod.modid + ":" + "celestialBronzeHelmet");
		celestialBronzeChestplate = new CelestialBronzeArmor(armorCelestialBronze, 4, 1).setUnlocalizedName("celestialBronzeChestplate").setTextureName(MythologyMod.modid + ":" + "celestialBronzeChestplate");
		celestialBronzeLeggings = new CelestialBronzeArmor(armorCelestialBronze, 4, 2).setUnlocalizedName("celestialBronzeLeggings").setTextureName(MythologyMod.modid + ":" + "celestialBronzeLeggings");
		celestialBronzeBoots = new CelestialBronzeArmor(armorCelestialBronze, 4, 3).setUnlocalizedName("celestialBronzeBoots").setTextureName(MythologyMod.modid + ":" + "celestialBronzeBoots");
		imperialGoldHelmet = new ImperialGoldArmor(armorImperialGold, 4, 0).setUnlocalizedName("imperialGoldHelmet").setTextureName(MythologyMod.modid + ":" + "imperialGoldHelmet");
		imperialGoldChestplate = new ImperialGoldArmor(armorImperialGold, 4, 1).setUnlocalizedName("imperialGoldChestplate").setTextureName(MythologyMod.modid + ":" + "imperialGoldChestplate");
		imperialGoldLeggings = new ImperialGoldArmor(armorImperialGold, 4, 2).setUnlocalizedName("imperialGoldLeggings").setTextureName(MythologyMod.modid + ":" + "imperialGoldLeggings");
		imperialGoldBoots = new ImperialGoldArmor(armorImperialGold, 4, 3).setUnlocalizedName("imperialGoldBoots").setTextureName(MythologyMod.modid + ":" + "imperialGoldBoots");
		silverHelmet = new SilverArmor(armorSilver, 4, 0).setUnlocalizedName("silverHelmet").setTextureName(MythologyMod.modid + ":" + "silverHelmet");
		silverChestplate = new SilverArmor(armorSilver, 4, 1).setUnlocalizedName("silverChestplate").setTextureName(MythologyMod.modid + ":" + "silverChestplate");
		silverLeggings = new SilverArmor(armorSilver, 4, 2).setUnlocalizedName("silverLeggings").setTextureName(MythologyMod.modid + ":" + "silverLeggings");
		silverBoots = new SilverArmor(armorSilver, 4, 3).setUnlocalizedName("silverBoots").setTextureName(MythologyMod.modid + ":" + "silverBoots");
		mithrilHelmet = new MithrilArmor(armorMithril, 4, 0).setUnlocalizedName("mithrilHelmet").setTextureName(MythologyMod.modid + ":" + "mithrilHelmet");
		mithrilChestplate = new MithrilArmor(armorMithril, 4, 1).setUnlocalizedName("mithrilChestplate").setTextureName(MythologyMod.modid + ":" + "mithrilChestplate");
		mithrilLeggings = new MithrilArmor(armorMithril, 4, 2).setUnlocalizedName("mithrilLeggings").setTextureName(MythologyMod.modid + ":" + "mithrilLeggings");
		mithrilBoots = new MithrilArmor(armorMithril, 4, 3).setUnlocalizedName("mithrilBoots").setTextureName(MythologyMod.modid + ":" + "mithrilBoots");
		rubyHelmet = new RubyArmor(armorRuby, 4, 0).setUnlocalizedName("rubyHelmet").setTextureName(MythologyMod.modid + ":" + "rubyHelmet");
		rubyChestplate = new RubyArmor(armorRuby, 4, 1).setUnlocalizedName("rubyChestplate").setTextureName(MythologyMod.modid + ":" + "rubyChestplate");
		rubyLeggings = new RubyArmor(armorRuby, 4, 2).setUnlocalizedName("rubyLeggings").setTextureName(MythologyMod.modid + ":" + "rubyLeggings");
		rubyBoots = new RubyArmor(armorRuby, 4, 3).setUnlocalizedName("rubyBoots").setTextureName(MythologyMod.modid + ":" + "rubyBoots");
		sapphireHelmet = new SapphireArmor(armorSapphire, 4, 0).setUnlocalizedName("sapphireHelmet").setTextureName(MythologyMod.modid + ":" + "sapphireHelmet");
		sapphireChestplate = new SapphireArmor(armorSapphire, 4, 1).setUnlocalizedName("sapphireChestplate").setTextureName(MythologyMod.modid + ":" + "sapphireChestplate");
		sapphireLeggings = new SapphireArmor(armorSapphire, 4, 2).setUnlocalizedName("sapphireLeggings").setTextureName(MythologyMod.modid + ":" + "sapphireLeggings");
		sapphireBoots = new SapphireArmor(armorSapphire, 4, 3).setUnlocalizedName("sapphireBoots").setTextureName(MythologyMod.modid + ":" + "sapphireBoots");
		
	}
	
	public static void register(){
		GameRegistry.registerItem(bronzeHelmet, "bronzeHelmet");
    	GameRegistry.registerItem(bronzeChestplate, "bronzeChestplate");
    	GameRegistry.registerItem(bronzeLeggings, "bronzeLeggings");
    	GameRegistry.registerItem(bronzeBoots, "bronzeBoots");
    	GameRegistry.registerItem(celestialBronzeHelmet, "celestialBronzeHelmet");
    	GameRegistry.registerItem(celestialBronzeChestplate, "celestialBronzeChestplate");
    	GameRegistry.registerItem(celestialBronzeLeggings, "celestialBronzeLeggings");
    	GameRegistry.registerItem(celestialBronzeBoots, "celestialBronzeBoots");
    	GameRegistry.registerItem(imperialGoldHelmet, "imperialGoldHelmet");
    	GameRegistry.registerItem(imperialGoldChestplate, "imperialGoldChestplate");
    	GameRegistry.registerItem(imperialGoldLeggings, "imperialGoldLeggings");
    	GameRegistry.registerItem(imperialGoldBoots, "imperialGoldBoots");
    	GameRegistry.registerItem(silverHelmet, "silverHelmet");
    	GameRegistry.registerItem(silverChestplate, "silverChestplate");
    	GameRegistry.registerItem(silverLeggings, "silverLeggings");
    	GameRegistry.registerItem(silverBoots, "silverBoots");
    	GameRegistry.registerItem(mithrilHelmet, "mithrilHelmet");
    	GameRegistry.registerItem(mithrilChestplate, "mithrilChestplate");
    	GameRegistry.registerItem(mithrilLeggings, "mithrilLeggings");
    	GameRegistry.registerItem(mithrilBoots, "mithrilBoots");
    	GameRegistry.registerItem(rubyHelmet, "rubyHelmet");
    	GameRegistry.registerItem(rubyChestplate, "rubyChestplate");
    	GameRegistry.registerItem(rubyLeggings, "rubyLeggings");
    	GameRegistry.registerItem(rubyBoots, "rubyBoots");
    	GameRegistry.registerItem(sapphireHelmet, "sapphireHelmet");
    	GameRegistry.registerItem(sapphireChestplate, "sapphireChestplate");
    	GameRegistry.registerItem(sapphireLeggings, "sapphireLeggings");
    	GameRegistry.registerItem(sapphireBoots, "sapphireBoots");
    	
	}
}
