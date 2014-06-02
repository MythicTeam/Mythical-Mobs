package mythology.init;

import mythology.MythologyMod;
import mythology.items.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MythicalTools {
	
	private static MythologyMod m = new MythologyMod();
	
	public static ToolMaterial toolBronze = EnumHelper.addToolMaterial("BRONZE", 2, 341, 5.0F, 2F, 14);
	public static ToolMaterial toolCelestialBronze = EnumHelper.addToolMaterial("CELESTIALBRONZE", 2, 453, 6.4F, 3F, 10);
	public static ToolMaterial toolImperialGold = EnumHelper.addToolMaterial("IMPERIALGOLD", 2, 532, 8F, 5F, 10);
	public static ToolMaterial toolSilver = EnumHelper.addToolMaterial("SILVER", 2, 332, 5.8F, 4F, 14);
	public static ToolMaterial toolRuby = EnumHelper.addToolMaterial("RUBY", 2, 330, 5.0F, 2F, 14);
	public static ToolMaterial toolSapphire = EnumHelper.addToolMaterial("SAPPHIRE", 2, 330, 5.0F, 2F, 14);
	
	public static Item swordBronze = new ItemSword(toolBronze).setUnlocalizedName("swordBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "swordBronze");
	public static Item swordCelestialBronze = new ItemSwordCB(toolCelestialBronze, "swordCelestialBronze").setUnlocalizedName("swordCelestialBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "swordCelestialBronze");
	public static Item swordImperialGold = new ItemSwordIG(toolImperialGold, "swordImperialGold").setUnlocalizedName("swordImperialGold").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "swordImperialGold");
	public static Item swordSilver = new ItemSword(toolSilver).setUnlocalizedName("swordSilver").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "swordSilver");
	public static Item swordRuby = new ItemSword(toolRuby).setUnlocalizedName("swordRuby").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "swordRuby");
	public static Item swordSapphire = new ItemSword(toolSapphire).setUnlocalizedName("swordSapphire").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "swordSapphire");
	
	public static Item pickaxeBronze = new ItemPickaxe(toolBronze, "pickaxeBronze").setUnlocalizedName("pickaxeBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "pickaxeBronze");
	public static Item pickaxeCelestialBronze = new ItemPickaxe(toolCelestialBronze, "pickaxeCelestialBronze").setUnlocalizedName("pickaxeCelestialBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "pickaxeCelestialBronze");
	public static Item pickaxeImperialGold = new ItemPickaxe(toolImperialGold, "pickaxeImperialGold").setUnlocalizedName("pickaxeImperialGold").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "pickaxeImperialGold");
	public static Item pickaxeSilver = new ItemPickaxe(toolSilver, "pickaxeSilver").setUnlocalizedName("pickaxeSilver").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "pickaxeSilver");
	public static Item pickaxeRuby = new ItemPickaxe(toolRuby, "pickaxeRuby").setUnlocalizedName("pickaxeRuby").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "pickaxeRuby");
	public static Item pickaxeSapphire = new ItemPickaxe(toolSapphire, "pickaxeSapphire").setUnlocalizedName("pickaxeSapphire").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "pickaxeSapphire");
	
	public static Item shovelBronze = new ItemShovel(toolBronze, "shovelBronze").setUnlocalizedName("shovelBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "shovelBronze");
	public static Item shovelCelestialBronze = new ItemShovel(toolCelestialBronze, "shovelCelestialBronze").setUnlocalizedName("shovelCelestialBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "shovelCelestialBronze");
	public static Item shovelImperialGold = new ItemShovel(toolImperialGold, "shovelImperialGold").setUnlocalizedName("shovelImperialGold").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "shovelImperialGold");
	public static Item shovelSilver = new ItemShovel(toolSilver, "shovelSilver").setUnlocalizedName("shovelSilver").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "shovelSilver");
	public static Item shovelRuby = new ItemShovel(toolRuby, "shovelRuby").setUnlocalizedName("shovelRuby").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "shovelRuby");
	public static Item shovelSapphire = new ItemShovel(toolSapphire, "shovelSapphire").setUnlocalizedName("shovelSapphire").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "shovelSapphire");
	
	public static Item axeBronze = new ItemAxe(toolBronze, "axeBronze").setUnlocalizedName("axeBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "axeBronze");
	public static Item axeCelestialBronze = new ItemAxe(toolCelestialBronze, "axeCelestialBronze").setUnlocalizedName("axeCelestialBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "axeCelestialBronze");
	public static Item axeImperialGold = new ItemAxe(toolImperialGold, "axeImperialGold").setUnlocalizedName("axeImperialGold").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "axeImperialGold");
	public static Item axeSilver = new ItemAxe(toolSilver, "axeSilver").setUnlocalizedName("axeSilver").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "axeSilver");
	public static Item axeRuby = new ItemAxe(toolRuby, "axeRuby").setUnlocalizedName("axeRuby").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "axeRuby");
	public static Item axeSapphire = new ItemAxe(toolSapphire, "axeSapphire").setUnlocalizedName("axeSapphire").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "axeSapphire");
	
	public static Item hoeBronze = new ItemHoe(toolBronze, "hoeBronze").setUnlocalizedName("hoeBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "hoeBronze");
	public static Item hoeCelestialBronze = new ItemHoe(toolCelestialBronze, "hoeCelestialBronze").setUnlocalizedName("hoeCelestialBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "hoeCelestialBronze");
	public static Item hoeImperialGold = new ItemHoeIG(toolImperialGold, "hoeImperialGold").setUnlocalizedName("hoeImperialGold").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "hoeImperialGold");
	public static Item hoeSilver = new ItemHoe(toolSilver, "hoeSilver").setUnlocalizedName("hoeSilver").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "hoeSilver");
	public static Item hoeRuby = new ItemHoe(toolRuby, "hoeRuby").setUnlocalizedName("hoeRuby").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "hoeRuby");
	public static Item hoeSapphire = new ItemHoe(toolSapphire, "hoeSapphire").setUnlocalizedName("hoeSapphire").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "hoeSapphire");
	
	public static Item ironWarhammer = new ItemWarhammer(ToolMaterial.IRON, "ironWarhammer", "Warhammers are useful for crushing weak bones!");
}
