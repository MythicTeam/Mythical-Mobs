package baubles.common;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import baubles.common.event.EventHandlerEntity;
import baubles.common.network.EventHandlerNetwork;
import baubles.common.network.PacketPipeline;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Baubles.MODID, name = Baubles.MODNAME, version = Baubles.VERSION, dependencies="required-after:Forge@[10.12.0.1056,);")

public class Baubles {
	
	public static final String MODID = "Baubles";
	public static final String MODNAME = "Baubles";
	public static final String VERSION = "1.0.0.15";

	@SidedProxy(clientSide = "baubles.client.ClientProxy", serverSide = "baubles.common.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(value=Baubles.MODID)
	public static Baubles instance;
	
	
	public EventHandlerNetwork networkEventHandler;
	public EventHandlerEntity entityEventHandler;
	public File modDir;
	
	public static final PacketPipeline packetPipeline = new PacketPipeline();
	public static final Logger log = LogManager.getLogger("Baubles");
	public static final int GUI = 0;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		event.getModMetadata().version = Baubles.VERSION;
		modDir = event.getModConfigurationDirectory();		
		
		try {
			Config.initialize(event.getSuggestedConfigurationFile());
		} catch (Exception e) {
			Baubles.log.error("BAUBLES has a problem loading it's configuration");
		} finally {
			if (Config.config!=null) Config.save();
		}
		
		entityEventHandler = new EventHandlerEntity();
		
		MinecraftForge.EVENT_BUS.register(entityEventHandler);
		FMLCommonHandler.instance().bus().register(new EventHandlerNetwork());
		proxy.registerHandlers();
		
		/////////////////////
			
		Config.save();
	}

	@EventHandler
	public void init(FMLInitializationEvent evt) {
		packetPipeline.initialise();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
  		proxy.registerKeyBindings();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {
		Config.initRecipe();
		packetPipeline.postInitialise();
	}
		
}
