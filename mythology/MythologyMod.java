package mythology;

import mythology.handlers.GuiHandler;
import mythology.init.*;
import mythology.proxy.CommonProxy;
import mythology.tileentities.TileEntityAlloyFurnace;
import mythology.world.MythicalWorldGen;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = MythologyMod.modid, name = MythologyMod.name, version = MythologyMod.version)
public class MythologyMod {
	//Mod Info
	public static final String modid = "mythical";
	public static final String version = "1.0.0";
	public static final String name = "Mythical Creatures";
	
	public static final int guiAlloyFurnace = 0;
	
	@Instance(MythologyMod.modid)
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
	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event) {
		
	    GameRegistry.registerTileEntity(TileEntityAlloyFurnace.class, "Alloy Furnace");
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
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
