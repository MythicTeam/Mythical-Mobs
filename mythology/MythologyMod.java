package mythology;

import mythology.commands.HealCommand;
import mythology.handlers.MythEventHandler;
import mythology.init.MythicalRegistration;
import mythology.init.MythicalTools;
import mythology.proxy.CommonProxy;
import mythology.swervy.common.Resources;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = MythologyMod.modid, name = MythologyMod.name, version = MythologyMod.version)
public class MythologyMod {
	
	public static final int guiAlloyFurnace = 0;
	public static final int guiHelp = 2;
	public static final int guiMagicTable = 3;
	
	//Mod Info
	public static final String modid = "mythical";
	public static final String version = "1.0";
	public static final String versiobState = "indev";
	public static final String name = "Mythical Creatures";
	
	@Instance(modid)
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
		@Override
		public Item getTabIconItem() {
			return Resources.underworldFlintAndBronze;
		}
	};
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new HealCommand());
	}
	
	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event) {
		proxy.RenderEntity();
	}

	@EventHandler
	public void Load(FMLInitializationEvent event) {
		MythicalRegistration.load();
		MinecraftForge.EVENT_BUS.register(new MythEventHandler());
	}

	@EventHandler
	public void PostLoad(FMLPostInitializationEvent event) {

	}
}