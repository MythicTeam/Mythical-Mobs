package mythology.init;

import mythology.MythologyMod;
import mythology.items.CookBehemothMeat;
import mythology.items.ItemFur;
import mythology.items.ItemGnomeBeard;
import mythology.items.ItemScales;
import mythology.items.ItemWing;
import mythology.items.MythItem;
import mythology.items.RawBehemothMeat;
import net.minecraft.item.Item;

public class MythicalItems {
	
	private static MythologyMod m = new MythologyMod();
	
	public static Item itemMithrilNugget = new Item().setUnlocalizedName("mithrilNugget").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemMithrilNugget");
	public static Item itemMithrilChain = new Item().setUnlocalizedName("mithrilChain").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemMithrilChain");
	public static Item itemMithrilMail = new Item().setUnlocalizedName("mithrilMail").setCreativeTab(m.tabMythical).setTextureName("mythical" + ":" + "itemMithrilMail");
	public static Item itemFur = new ItemFur("itemFur", m.tabMythical);
	public static Item itemScales = new ItemScales("itemScales", m.tabMythical);
	public static Item rawBehemothMeat = new RawBehemothMeat(4,0.4F,true, "rawBehemothMeat", m.tabMythical);
	public static Item cookBehemothMeat = new CookBehemothMeat(8, 0.8F, true, "cookBehemothMeat", m.tabMythical);
	public static Item itemGnomeBeard = new ItemGnomeBeard("itemGnomeBeard", m.tabMythical);
	public static Item wing = new ItemWing("wing", "Wings are for flying, right?");
	public static Item flyToken = new MythItem("flyToken", "Gives the holder the ability to fly!");
	
}
