package mythology.init;

import mythology.MythologyMod;
import mythology.items.AdmintoolDamageChanger;
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
	
	public static Item itemMythrilNugget = new MythItem("itemMythrilNugget", "A nugget made of Mythril.");
	public static Item itemMythrilChain = new MythItem("itemMythrilChain", "Probably used for crafting.");
	public static Item itemMythrilMail = new MythItem("itemMythrilMail", "Not sure what this does...");
	public static Item itemFur = new ItemFur("itemFur", m.tabMythical);
	public static Item itemScales = new ItemScales("itemScales", m.tabMythical);
	public static Item rawBehemothMeat = new RawBehemothMeat(4,0.4F,true, "rawBehemothMeat", m.tabMythical);
	public static Item cookBehemothMeat = new CookBehemothMeat(8, 0.8F, true, "cookBehemothMeat", m.tabMythical);
	public static Item itemGnomeBeard = new ItemGnomeBeard("itemGnomeBeard", m.tabMythical);	
	public static Item wing = new ItemWing("wing", "Wings are for flying, right?");
	
	//Tokens
	public static Item flyToken = new MythItem("flyToken", "Gives the holder the ability to fly!");	
	public static Item noclipToken = new MythItem("noclipToken", "Gives the holder the ability to pass through blocks!");	
	public static Item tier1GmBreakToken = new MythItem("tier1GmBreakToken", "Doubles the holders breakspeed!");
	public static Item tier2GmBreakToken = new MythItem("tier2GmBreakToken", "Quadrouples the holders breakspeed!");
	public static Item tier3GmBreakToken = new MythItem("tier3GmBreakToken", "Octuples the holders breakspeed!");
	public static Item mineToken = new MythItem("mineToken", "Increases your skills with a pick by 30%!");
	public static Item woodcuttingToken = new MythItem("woodcuttingToken", "Increases your lumberjack lumberness by 30%!");
	public static Item digToken = new MythItem("digToken", "Increases your dig bick effiency by 30%!");
	public static Item breakToken = new MythItem("breakToken", "Increases your breakspeed by 20%!");
}
