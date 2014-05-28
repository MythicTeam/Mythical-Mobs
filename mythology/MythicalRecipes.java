package mythology;

import mythology.init.MythicalArmor;
import mythology.init.MythicalBlocks;
import mythology.init.MythicalItems;
import mythology.init.MythicalTools;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
public class MythicalRecipes {
	
	public static void addMythicalRecipes(){
		
		MythologyMod m = new MythologyMod();
		MythicalItems mi = new MythicalItems();
		MythicalBlocks mb = new MythicalBlocks();
		MythicalTools mt = new MythicalTools();
		MythicalArmor mr = new MythicalArmor();
		
		//Smelting recipes
		GameRegistry.addSmelting(mb.blockCopperOre, new ItemStack(mi.itemCopperIngot, 1), 0.7F);
		GameRegistry.addSmelting(mb.blockTinOre, new ItemStack(mi.itemTinIngot, 1), 0.7F);
		GameRegistry.addSmelting(mb.blockCelestialBronzeOre, new ItemStack(mi.itemCelestialBronzeIngot, 1), 1.0F);
		GameRegistry.addSmelting(mb.blockImperialGoldOre, new ItemStack(mi.itemImperialGoldIngot, 1), 1.0F);
		GameRegistry.addSmelting(mb.blockSilverOre, new ItemStack(mi.itemSilverIngot, 1), 0.9F);
		GameRegistry.addSmelting(mi.rawBehemothMeat, new ItemStack(mi.cookBehemothMeat, 1), 1.0F);
		GameRegistry.addSmelting(mb.blockMithrilOre, new ItemStack(mi.itemMithrilIngot, 1), 3.0F);
		GameRegistry.addSmelting(mb.blockPlatinumOre, new ItemStack(mi.itemPlatinumIngot, 1), 0.9F);
		GameRegistry.addSmelting(mb.blockRubyOre, new ItemStack(mi.itemRuby, 2), 0.7F);
		GameRegistry.addSmelting(mb.blockSapphireOre, new ItemStack(mi.itemSapphire, 2), 0.7F);
		
		//Crafting recipes
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.swordBronze, 1), new Object[] { "I", "I", "S", 'I', "ingotBronze", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.pickaxeBronze, 1), new Object[] { "III", " S ", " S ", 'I', "ingotBronze", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.axeBronze, 1), new Object[] { "II", "IS", " S", 'I', "ingotBronze", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.hoeBronze, 1), new Object[] { "II", " S", " S", 'I', "ingotBronze", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelBronze, 1), new Object[] { "I", "S", "S", 'I', "ingotBronze", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.swordCelestialBronze, 1), new Object[] { "I", "I", "S", 'I', "ingotCelestialBronze", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.pickaxeCelestialBronze, 1), new Object[] { "III", " S ", " S ", 'I', "ingotCelestialBronze", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.axeCelestialBronze, 1), new Object[] { "II", "IS", " S", 'I', "ingotCelestialBronze", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.hoeCelestialBronze, 1), new Object[] { "II", " S", " S", 'I', "ingotCelestialBronze", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelCelestialBronze, 1), new Object[] { "I", "S", "S", 'I', "ingotCelestialBronze", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.swordImperialGold, 1), new Object[] { "I", "I", "S", 'I', "ingotImperialGold", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.pickaxeImperialGold, 1), new Object[] { "III", " S ", " S ", 'I', "ingotImperialGold", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.axeImperialGold, 1), new Object[] { "II", "IS", " S", 'I', "ingotImperialGold", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.hoeImperialGold, 1), new Object[] { "II", " S", " S", 'I', "ingotImperialGold", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelImperialGold, 1), new Object[] { "I", "S", "S", 'I', "ingotImperialGold", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.swordSilver, 1), new Object[] { "I", "I", "S", 'I', "ingotSilver", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.pickaxeSilver, 1), new Object[] { "III", " S ", " S ", 'I', "ingotSilver", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.axeSilver, 1), new Object[] { "II", "IS", " S", 'I', "ingotSilver", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.hoeSilver, 1), new Object[] { "II", " S", " S", 'I', "ingotSilver", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelSilver, 1), new Object[] { "I", "S", "S", 'I', "ingotSilver", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.bronzeHelmet, 1), new Object[] { "III", "I I", 'I', "ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.bronzeChestplate, 1), new Object[] { "I I", "III", "III", 'I', "ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.bronzeLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.bronzeBoots, 1), new Object[] { "I I", "I I", 'I', "ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.celestialBronzeHelmet, 1), new Object[] { "III", "I I", 'I', "ingotCelestialBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.celestialBronzeChestplate, 1), new Object[] { "I I", "III", "III", 'I', "ingotCelestialBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.celestialBronzeLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "ingotCelestialBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.celestialBronzeBoots, 1), new Object[] { "I I", "I I", 'I', "ingotCelestialBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.imperialGoldHelmet, 1), new Object[] { "III", "I I", 'I', "ingotImperialGold"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.imperialGoldChestplate, 1), new Object[] { "I I", "III", "III", 'I', "ingotImperialGold"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.imperialGoldLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "ingotImperialGold"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.imperialGoldBoots, 1), new Object[] { "I I", "I I", 'I', "ingotImperialGold"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.silverHelmet, 1), new Object[] { "III", "I I", 'I', "ingotSilver"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.silverChestplate, 1), new Object[] { "I I", "III", "III", 'I', "ingotSilver"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.silverLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "ingotSilver"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.silverBoots, 1), new Object[] { "I I", "I I", 'I', "ingotSilver"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.mithrilHelmet, 1), new Object[] { "III", "I I", 'I', "materialMythrilMail"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.mithrilChestplate, 1), new Object[] { "I I", "III", "III", 'I', "materialMythrilMail"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.mithrilLeggings, 1), new Object[] { "III", "I I", "I I", 'I', "materialMythrilMail"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mr.mithrilBoots, 1), new Object[] { "I I", "I I", 'I', "materialMythrilMail"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(mi.itemMithrilNugget, 9), new Object[]{"ingotMythril"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mi.itemMithrilChain, 3), new Object[] { " I ", "I I", " I ", 'I', "nuggetMythril"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mi.itemMithrilMail, 1), new Object[] { "III", "III", "III", 'I', "materialMithrilChain"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockBronzeBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockCelestialBronzeBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotCelestialBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockImperialGoldBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotImperialGold"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockPlatinumBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotPlatinum"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockSilverBlock, 1), new Object[] { "III", "III", "III", 'I', "ingotSilver"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockRubyBlock, 1), new Object[] { "III", "III", "III", 'I', "gemRuby"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mb.blockSapphireBlock, 1), new Object[] { "III", "III", "III", 'I', "gemSapphire"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.swordRuby, 1), new Object[] { "I", "I", "S", 'I', "gemRuby", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.pickaxeRuby, 1), new Object[] { "III", " S ", " S ", 'I', "gemRuby", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.axeRuby, 1), new Object[] { "II", "IS", " S", 'I', "gemRuby", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.hoeRuby, 1), new Object[] { "II", " S", " S", 'I', "gemRuby", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelRuby, 1), new Object[] { "I", "S", "S", 'I', "gemRuby", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.swordSapphire, 1), new Object[] { "I", "I", "S", 'I', "gemSapphire", 'S', Items.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.pickaxeSapphire, 1), new Object[] { "III", " S ", " S ", 'I', "gemSapphire", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.axeSapphire, 1), new Object[] { "II", "IS", " S", 'I', "gemSapphire", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.hoeSapphire, 1), new Object[] { "II", " S", " S", 'I', "gemSapphire", 'S', Items.stick }));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mt.shovelSapphire, 1), new Object[] { "I", "S", "S", 'I', "gemSapphire", 'S', Items.stick}));
		
	}
}
