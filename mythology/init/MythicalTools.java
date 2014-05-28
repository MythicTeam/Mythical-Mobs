package mythology.init;

import mythology.MythologyMod;
import mythology.modItems.ItemAxe;
import mythology.modItems.ItemHoe;
import mythology.modItems.ItemHoeIG;
import mythology.modItems.ItemPickaxe;
import mythology.modItems.ItemShovel;
import mythology.modItems.ItemSwordCB;
import mythology.modItems.ItemSwordIG;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class MythicalTools {
	
	public static Item swordBronze;
	public static Item swordCelestialBronze;
	public static Item swordImperialGold;
	public static Item swordSilver;
	public static Item swordRuby;
	public static Item swordSapphire;
	
	public static Item pickaxeBronze;
	public static Item pickaxeCelestialBronze;
	public static Item pickaxeImperialGold;
	public static Item pickaxeSilver;
	public static Item pickaxeRuby;
	public static Item pickaxeSapphire;
	
	public static Item shovelBronze;
	public static Item shovelCelestialBronze;
	public static Item shovelImperialGold;
	public static Item shovelSilver;
	public static Item shovelRuby;
	public static Item shovelSapphire;
	
	public static Item axeBronze;
	public static Item axeCelestialBronze;
	public static Item axeImperialGold;
	public static Item axeSilver;
	public static Item axeRuby;
	public static Item axeSapphire;
	
	public static Item hoeBronze;
	public static Item hoeCelestialBronze;
	public static Item hoeImperialGold;
	public static Item hoeSilver;
	public static Item hoeRuby;
	public static Item hoeSapphire;
	
	private static MythologyMod m = new MythologyMod();
	
	public static void add(){
		ToolMaterial toolBronze = EnumHelper.addToolMaterial("BRONZE", 2, 341, 5.0F, 2F, 14);
		ToolMaterial toolCelestialBronze = EnumHelper.addToolMaterial("CELESTIALBRONZE", 2, 453, 6.4F, 3F, 10);
		ToolMaterial toolImperialGold = EnumHelper.addToolMaterial("IMPERIALGOLD", 2, 532, 8F, 5F, 10);
		ToolMaterial toolSilver = EnumHelper.addToolMaterial("SILVER", 2, 332, 5.8F, 4F, 14);
		ToolMaterial toolRuby = EnumHelper.addToolMaterial("RUBY", 2, 330, 5.0F, 2F, 14);
		ToolMaterial toolSapphire = EnumHelper.addToolMaterial("SAPPHIRE", 2, 330, 5.0F, 2F, 14);
		
		swordBronze = new ItemSword(toolBronze).setUnlocalizedName("swordBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "swordBronze");
		swordCelestialBronze = new ItemSwordCB(toolCelestialBronze).setUnlocalizedName("swordCelestialBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "swordCelestialBronze");
		swordImperialGold = new ItemSwordIG(toolImperialGold).setUnlocalizedName("swordImperialGold").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "swordImperialGold");
		swordSilver = new ItemSword(toolSilver).setUnlocalizedName("swordSilver").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "swordSilver");
		swordRuby = new ItemSword(toolRuby).setUnlocalizedName("swordRuby").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "swordRuby");
		swordSapphire = new ItemSword(toolSapphire).setUnlocalizedName("swordSapphire").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "swordSapphire");
		
		pickaxeBronze = new ItemPickaxe(toolBronze).setUnlocalizedName("pickaxeBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "pickaxeBronze");
		pickaxeCelestialBronze = new ItemPickaxe(toolCelestialBronze).setUnlocalizedName("pickaxeCelestialBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "pickaxeCelestialBronze");
		pickaxeImperialGold = new ItemPickaxe(toolImperialGold).setUnlocalizedName("pickaxeImperialGold").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "pickaxeImperialGold");
		pickaxeSilver = new ItemPickaxe(toolSilver).setUnlocalizedName("pickaxeSilver").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "pickaxeSilver");
		pickaxeRuby = new ItemPickaxe(toolRuby).setUnlocalizedName("pickaxeRuby").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "pickaxeRuby");
		pickaxeSapphire = new ItemPickaxe(toolSapphire).setUnlocalizedName("pickaxeSapphire").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "pickaxeSapphire");
		
		shovelBronze = new ItemShovel(toolBronze).setUnlocalizedName("shovelBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "shovelBronze");
		shovelCelestialBronze = new ItemShovel(toolCelestialBronze).setUnlocalizedName("shovelCelestialBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "shovelCelestialBronze");
		shovelImperialGold = new ItemShovel(toolImperialGold).setUnlocalizedName("shovelImperialGold").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "shovelImperialGold");
		shovelSilver = new ItemShovel(toolSilver).setUnlocalizedName("shovelSilver").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "shovelSilver");
		shovelRuby = new ItemShovel(toolRuby).setUnlocalizedName("shovelRuby").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "shovelRuby");
		shovelSapphire = new ItemShovel(toolSapphire).setUnlocalizedName("shovelSapphire").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "shovelSapphire");
		
		axeBronze = new ItemAxe(toolBronze).setUnlocalizedName("axeBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "axeBronze");
		axeCelestialBronze = new ItemAxe(toolCelestialBronze).setUnlocalizedName("axeCelestialBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "axeCelestialBronze");
		axeImperialGold = new ItemAxe(toolImperialGold).setUnlocalizedName("axeImperialGold").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "axeImperialGold");
		axeSilver = new ItemAxe(toolSilver).setUnlocalizedName("axeSilver").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "axeSilver");
		axeRuby = new ItemAxe(toolRuby).setUnlocalizedName("axeRuby").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "axeRuby");
		axeSapphire = new ItemAxe(toolSapphire).setUnlocalizedName("axeSapphire").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "axeSapphire");
		
		hoeBronze = new ItemHoe(toolBronze).setUnlocalizedName("hoeBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "hoeBronze");
		hoeCelestialBronze = new ItemHoe(toolCelestialBronze).setUnlocalizedName("hoeCelestialBronze").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "hoeCelestialBronze");
		hoeImperialGold = new ItemHoeIG(toolImperialGold).setUnlocalizedName("hoeImperialGold").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "hoeImperialGold");
		hoeSilver = new ItemHoe(toolSilver).setUnlocalizedName("hoeSilver").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "hoeSilver");
		hoeRuby = new ItemHoe(toolRuby).setUnlocalizedName("hoeRuby").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "hoeRuby");
		hoeSapphire = new ItemHoe(toolSapphire).setUnlocalizedName("hoeSapphire").setCreativeTab(m.tabMythical).setTextureName(MythologyMod.modid + ":" + "hoeSapphire");
		
	}
	public static void register(){
		GameRegistry.registerItem(swordBronze, "swordBronze"); 
    	GameRegistry.registerItem(swordCelestialBronze, "swordCelestialBronze"); 
    	GameRegistry.registerItem(swordImperialGold, "swordImperialGold"); 
    	GameRegistry.registerItem(swordSilver, "swordSilver"); 
    	GameRegistry.registerItem(swordRuby, "swordRuby");
    	GameRegistry.registerItem(swordSapphire, "swordSapphire");
    	GameRegistry.registerItem(pickaxeBronze, "pickaxeBronze"); 
    	GameRegistry.registerItem(pickaxeCelestialBronze, "CelestialBronze"); 
    	GameRegistry.registerItem(pickaxeImperialGold, "pickaxeImperialGold"); 
    	GameRegistry.registerItem(pickaxeSilver, "pickaxeSilver"); 
    	GameRegistry.registerItem(pickaxeRuby, "pickaxeRuby");
    	GameRegistry.registerItem(pickaxeSapphire, "pickaxeSapphire");
    	GameRegistry.registerItem(shovelBronze, "shovelBronze"); 
    	GameRegistry.registerItem(shovelCelestialBronze, "shovelCelestialBronze"); 
    	GameRegistry.registerItem(shovelImperialGold, "shovelImperialGold"); 
    	GameRegistry.registerItem(shovelSilver, "shovelSilver"); 
    	GameRegistry.registerItem(shovelRuby, "shovelRuby");
    	GameRegistry.registerItem(shovelSapphire, "shovelSapphire");
    	GameRegistry.registerItem(axeBronze, "axeBronze"); 
    	GameRegistry.registerItem(axeCelestialBronze, "axeCelestialBronze"); 
    	GameRegistry.registerItem(axeImperialGold, "axeImperialGold"); 
    	GameRegistry.registerItem(axeSilver, "axeSilver"); 
    	GameRegistry.registerItem(axeRuby, "axeRuby");
    	GameRegistry.registerItem(axeSapphire, "axeSapphire");
    	GameRegistry.registerItem(hoeBronze, "hoeBronze"); 
    	GameRegistry.registerItem(hoeCelestialBronze, "hoeCelestialBronze"); 
    	GameRegistry.registerItem(hoeImperialGold, "hoeImperialGold"); 
    	GameRegistry.registerItem(hoeSilver, "hoeSilver"); 
    	GameRegistry.registerItem(hoeRuby, "hoeRuby");
    	GameRegistry.registerItem(hoeSapphire, "hoeSapphire");
    	
	}
}
