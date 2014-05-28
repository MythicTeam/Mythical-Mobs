package mythology;

import mythology.init.MythicalBlocks;
import mythology.init.MythicalItems;
import net.minecraftforge.oredict.OreDictionary;

public class MythicalDictionary {

    public static void oreRegistration()
    {
    	MythologyMod m = new MythologyMod();
    	MythicalItems mi = new MythicalItems();
    	MythicalBlocks mb = new MythicalBlocks();

    	//OreDictionaryBlocks
    	OreDictionary.registerOre("oreZinc", mb.blockZincOre);
    	OreDictionary.registerOre("oreMythril", mb.blockMithrilOre);
    	OreDictionary.registerOre("oreMithril", mb.blockMithrilOre);
    	OreDictionary.registerOre("oreCopper", mb.blockCopperOre);
    	OreDictionary.registerOre("oreTin", mb.blockTinOre);
    	OreDictionary.registerOre("oreSilver", mb.blockSilverOre);
    	OreDictionary.registerOre("orePlatinum", mb.blockPlatinumOre);
    	OreDictionary.registerOre("oreRuby", mb.blockRubyOre);
    	OreDictionary.registerOre("oreSapphire", mb.blockSapphireOre);
    	OreDictionary.registerOre("oreCelestialBronze", mb.blockCelestialBronzeOre);
    	OreDictionary.registerOre("oreImperialGold", mb.blockImperialGoldOre);



    	//OreDictionaryItems
    	OreDictionary.registerOre("ingotCopper", mi.itemCopperIngot);
    	OreDictionary.registerOre("ingotTin", mi.itemTinIngot);
    	OreDictionary.registerOre("ingotBronze", mi.itemBronzeIngot);
    	OreDictionary.registerOre("ingotCelestialBronze", mi.itemCelestialBronzeIngot);
    	OreDictionary.registerOre("ingotImperialGold", mi.itemImperialGoldIngot);
    	OreDictionary.registerOre("ingotPlatinum", mi.itemPlatinumIngot);
    	OreDictionary.registerOre("ingotMythril", mi.itemMithrilIngot);
    	OreDictionary.registerOre("ingotMithril", mi.itemMithrilIngot);
    	OreDictionary.registerOre("gemRuby", mi.itemRuby);
    	OreDictionary.registerOre("gemSapphire", mi.itemSapphire);
    	OreDictionary.registerOre("nuggetMythril", mi.itemMithrilNugget);
    	OreDictionary.registerOre("nuggetMithril", mi.itemMithrilNugget);
    	OreDictionary.registerOre("materialMithrilChiain", mi.itemMithrilChain);
    	OreDictionary.registerOre("materialMythrilChain", mi.itemMithrilChain);
    	OreDictionary.registerOre("materialMithrilMail", mi.itemMithrilMail);
    	OreDictionary.registerOre("materialMythrilMail", mi.itemMithrilMail);
    	

    }

}
