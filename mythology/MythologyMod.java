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
	
	public static final int guiAlloyFurnace = 0;
	
	//Mod Info
	public static final String modid = "mythical";
	public static final String version = "1.0.0";
	public static final String name = "Mythical Creatures";
	
	@Instance("mythical")
	public static MythologyMod instance;
	
	@SidedProxy(clientSide = "mythology.proxy.ClientProxy", serverSide = "mythology.proxy.CommonProxy")
	public static CommonProxy proxy;
	// Creative Tabs
	
	public static CreativeTabs tabMythical = new CreativeTabs("tabMythical") {
		@Override
		public Item getTabIconItem() {
			return MythicalTools.swordImperialGold;
		}
	};
	
	public static CreativeTabs tabMythicalUnderworld = new CreativeTabs("tabMythicalUnderworld") {
		
		public Item getTabIconItem() {
			return MythicalItems.underworldFlintAndBronze;
		}
	};
	
	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event) {
		
		MythicalRegistration.load();
		
		proxy.RenderEntity();
	}

	@EventHandler
	public void Load(FMLInitializationEvent event) {

	}

	@EventHandler
	public void PostLoad(FMLPostInitializationEvent event) {

	}
}