package mythology.init;

import mythology.MythologyMod;
import mythology.items.CookBehemothMeat;
import mythology.items.ItemFur;
import mythology.items.ItemGnomeBeard;
import mythology.items.ItemScales;
import mythology.items.RawBehemothMeat;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class MythicalItems {
	
	//Our Mod Items
		public static Item itemFur;
		public static Item itemScales;
		public static ItemFood rawBehemothMeat;
		public static ItemFood cookBehemothMeat;
		public static Item itemGnomeBeard;
		public static Item itemTinIngot;
		public static Item itemCopperIngot;
		public static Item itemBronzeIngot;
		public static Item itemCelestialBronzeIngot;
		public static Item itemImperialGoldIngot;
		public static Item itemSilverIngot;
		public static Item itemPlatinumIngot;
		public static Item itemRuby;
		public static Item itemSapphire;
		public static Item itemMithrilIngot;
		public static Item itemMithrilNugget;
		public static Item itemMithrilChain;
		public static Item itemMithrilMail;
		
	private static MythologyMod m = new MythologyMod();
	public static void add(){
		//My ingots
		itemCopperIngot = new Item().setUnlocalizedName("copperIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemCopperIngot");
		itemTinIngot = new Item().setUnlocalizedName("tinIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemTinIngot");
		itemBronzeIngot = new Item().setUnlocalizedName("bronzeIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemBronzeIngot");
		itemCelestialBronzeIngot = new Item().setUnlocalizedName("celestialBronzeIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemCelestialBronzeIngot");
		itemImperialGoldIngot = new Item().setUnlocalizedName("imperialGoldIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemImperialGoldIngot");
		itemSilverIngot = new Item().setUnlocalizedName("silverIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemSilverIngot");
		itemPlatinumIngot = new Item().setUnlocalizedName("platinumIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemPlatinumIngot");
		itemRuby = new Item().setUnlocalizedName("ruby").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "ruby");
		itemSapphire = new Item().setUnlocalizedName("sapphire").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "sapphire");
		
		//mithril shizzle
		itemMithrilIngot = new Item().setUnlocalizedName("mithrilIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemMithrilIngot");
		itemMithrilNugget = new Item().setUnlocalizedName("mithrilNugget").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemMithrilNugget");
		itemMithrilChain = new Item().setUnlocalizedName("mithrilChain").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemMithrilChain");
		itemMithrilMail = new Item().setUnlocalizedName("mithrilMail").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemMithrilMail");
		itemFur = new ItemFur("itemFur", m.tabMythical);
		itemScales = new ItemScales("itemScales", m.tabMythical);
		rawBehemothMeat = new RawBehemothMeat(4,0.4F,true, "rawBehemothMeat", m.tabMythical);
		cookBehemothMeat = new CookBehemothMeat(8, 0.8F, true, "cookBehemothMeat", m.tabMythical);
		itemGnomeBeard = new ItemGnomeBeard("itemGnomeBeard", m.tabMythical);
				
	}
	public static void register(){
		GameRegistry.registerItem(itemCopperIngot, "copperIngot");
    	GameRegistry.registerItem(itemTinIngot, "tinIngot");
    	GameRegistry.registerItem(itemBronzeIngot, "bronzeIngot"); 
    	GameRegistry.registerItem(itemCelestialBronzeIngot, "celestialBronzeIngot"); 
    	GameRegistry.registerItem(itemImperialGoldIngot, "imperialGoldIngot"); 
    	GameRegistry.registerItem(itemSilverIngot, "silverIngot");
    	GameRegistry.registerItem(itemGnomeBeard, "itemGnomeBeard");
    	GameRegistry.registerItem(itemFur, "itemFur");
    	GameRegistry.registerItem(rawBehemothMeat, "rawBehemothMeat");
    	GameRegistry.registerItem(cookBehemothMeat, "cookBehemothMeat");
    	GameRegistry.registerItem(itemScales, "itemScales");
    	GameRegistry.registerItem(itemMithrilIngot, "itemMithrilIngot");
    	GameRegistry.registerItem(itemMithrilNugget, "itemMithrilNugget");
    	GameRegistry.registerItem(itemMithrilChain, "itemMithrilChain");
    	GameRegistry.registerItem(itemMithrilMail, "itemMithrilMail");
    	GameRegistry.registerItem(itemPlatinumIngot, "itemPlatinumIngot");
		GameRegistry.registerItem(itemRuby, "itemRuby");
		GameRegistry.registerItem(itemSapphire, "itemSapphire");
		
	}
}
