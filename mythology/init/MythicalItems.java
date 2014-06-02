package mythology.init;

import mythology.MythologyMod;
import mythology.items.CookBehemothMeat;
import mythology.items.ItemFur;
import mythology.items.ItemGnomeBeard;
import mythology.items.ItemScales;
import mythology.items.ItemWarhammer;
import mythology.items.ItemWing;
import mythology.items.MythItem;
import mythology.items.RawBehemothMeat;
import mythology.swervy.items.ItemFlintAndBronze;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

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
	public static Item noclipToken = new MythItem("noclipToken", "Gives the holder the ability to pass through blocks!");	
	public static Item tier1MineToken = new MythItem("tier1MineToken", "Doubles the holders breakspeed!");
	public static Item tier2MineToken = new MythItem("tier2MineToken", "Quadrouples the holders breakspeed!");
	public static Item tier3MineToken = new MythItem("tier3MineToken", "Octuples the holders breakspeed!");

	public static Item ironWarhammer = new ItemWarhammer(ToolMaterial.IRON, "ironWarhammer", "Warhammers are useful for crushing weak bones!");
}
