package mythology.init;

import mythology.MythologyMod;
import mythology.items.MythItem;
import net.minecraft.item.Item;

public class MythicalIngot {

	private static MythologyMod m = new MythologyMod();
	
	public static Item itemMithrilIngot = new MythItem("itemMithrilIngot", "Used to craft various Mythril items.").setUnlocalizedName("mithrilIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemMithrilIngot");
	public static Item itemCopperIngot = new MythItem("itemCopperIngot", "Used to craft various Copper items.").setUnlocalizedName("copperIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemCopperIngot");
	public static Item itemTinIngot = new MythItem("itemTinIngot", "Used to craft various Tin items.").setUnlocalizedName("tinIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemTinIngot");
	public static Item itemBronzeIngot = new MythItem("itemBronzeIngot", "Used to craft various Bronze items.").setUnlocalizedName("bronzeIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemBronzeIngot");
	public static Item itemCelestialBronzeIngot = new MythItem("itemCelestialBronzeIngot", "Used to craft various Bronze items.").setUnlocalizedName("celestialBronzeIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemCelestialBronzeIngot");
	public static Item itemImperialGoldIngot = new MythItem("itemImperialGoldIngot", "Used to craft various Imperial Gold items.").setUnlocalizedName("imperialGoldIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemImperialGoldIngot");
	public static Item itemSilverIngot = new MythItem("itemSilverIngot", "Used to craft various Silver items.").setUnlocalizedName("silverIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemSilverIngot");
	public static Item itemPlatinumIngot = new MythItem("itemPlatinumIngot", "Used to craft various Platinum items.").setUnlocalizedName("platinumIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemPlatinumIngot");
	public static Item itemRuby = new MythItem("itemRuby", "Used to craft various Ruby items.").setUnlocalizedName("ruby").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "ruby");
	public static Item itemSapphire = new MythItem("itemSapphire", "Used to craft various Sapphire items.").setUnlocalizedName("sapphire").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "sapphire");
	
}
