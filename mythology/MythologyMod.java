package mythology;

import mythology.init.*;
import mythology.proxy.CommonProxy;
import mythology.world.MythicalWorldGen;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = MythologyMod.modid, name = MythologyMod.name, version = MythologyMod.version)
public class MythologyMod {
	@Instance("mythical")
	public static MythologyMod m;
	@SidedProxy(clientSide = "mythology.proxy.ClientProxy", serverSide = "mythology.proxy.CommonProxy")
	public static CommonProxy proxy;
	//Mod Info
	public static final String modid = "mythical";
	public static final String version = "1.0.0";
	public static final String name = "Mythical Creatures";
	
	//Our Mod Blocks

	
	// Creative Tabs
	public static CreativeTabs tabMythical = new CreativeTabs("tabMythical") {
		@Override
		public Item getTabIconItem() {
			return MythicalTools.swordImperialGold;
		}
	};
	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event) {
		
		MythicalBlocks.add();
		MythicalBlocks.register();
		
		MythicalItems.add();
		MythicalItems.register();
		
		MythicalArmor.add();
		MythicalArmor.register();
		
		MythicalTools.add();
		MythicalTools.register();
		
		MythicalMobs.register();
		
		MythicalDictionary.oreRegistration();
		
		GameRegistry.registerWorldGenerator(new MythicalWorldGen(), 0);
		
		MythicalRecipes.addMythicalRecipes();
		
		proxy.RenderEntity();
	}

	@EventHandler
	public void Load(FMLInitializationEvent event) {

	}

	@EventHandler
	public void PostLoad(FMLPostInitializationEvent event) {

	}
}
