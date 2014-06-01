package mythology.init;

import mythology.MythologyMod;
import net.minecraft.item.Item;

public class MythicalIngot {

	private static MythologyMod m = new MythologyMod();
	
	public static Item itemMithrilIngot = new Item().setUnlocalizedName("mithrilIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemMithrilIngot");
	public static Item itemCopperIngot = new Item().setUnlocalizedName("copperIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemCopperIngot");
	public static Item itemTinIngot = new Item().setUnlocalizedName("tinIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemTinIngot");
	public static Item itemBronzeIngot = new Item().setUnlocalizedName("bronzeIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemBronzeIngot");
	public static Item itemCelestialBronzeIngot = new Item().setUnlocalizedName("celestialBronzeIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemCelestialBronzeIngot");
	public static Item itemImperialGoldIngot = new Item().setUnlocalizedName("imperialGoldIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemImperialGoldIngot");
	public static Item itemSilverIngot = new Item().setUnlocalizedName("silverIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemSilverIngot");
	public static Item itemPlatinumIngot = new Item().setUnlocalizedName("platinumIngot").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemPlatinumIngot");
	public static Item itemRuby = new Item().setUnlocalizedName("ruby").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "ruby");
	public static Item itemSapphire = new Item().setUnlocalizedName("sapphire").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "sapphire");
}
