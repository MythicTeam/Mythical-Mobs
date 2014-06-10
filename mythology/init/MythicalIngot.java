package mythology.init;

import mythology.MythologyMod;
import mythology.items.MythItem;
import net.minecraft.item.Item;

public class MythicalIngot {

	private static MythologyMod m = new MythologyMod();
	
	public static Item itemMithrilIngot = new MythItem("itemMithrilIngot", "").setUnlocalizedName("mithrilIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemMithrilIngot");
	public static Item itemCopperIngot = new MythItem("itemCopperIngot", "").setUnlocalizedName("copperIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemCopperIngot");
	public static Item itemTinIngot = new MythItem("itemTinIngot", "").setUnlocalizedName("tinIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemTinIngot");
	public static Item itemBronzeIngot = new MythItem("itemBronzeIngot", "").setUnlocalizedName("bronzeIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemBronzeIngot");
	public static Item itemCelestialBronzeIngot = new MythItem("itemCelestialBronzeIngot", "").setUnlocalizedName("celestialBronzeIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemCelestialBronzeIngot");
	public static Item itemImperialGoldIngot = new MythItem("itemImperialGoldIngot", "").setUnlocalizedName("imperialGoldIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemImperialGoldIngot");
	public static Item itemSilverIngot = new MythItem("itemSilverIngot", "").setUnlocalizedName("silverIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemSilverIngot");
	public static Item itemPlatinumIngot = new MythItem("itemPlatinumIngot", "").setUnlocalizedName("platinumIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemPlatinumIngot");
	public static Item itemRuby = new MythItem("itemRuby", "").setUnlocalizedName("ruby").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "ruby");
	public static Item itemSapphire = new MythItem("itemSapphire", "").setUnlocalizedName("sapphire").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "sapphire");
	
}
