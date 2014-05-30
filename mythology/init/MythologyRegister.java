package mythology.init;

import mythology.MythologyMod;
import mythology.mobs.passive.EntityGnome;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MythologyRegister {

	public static void addMob(Class entityClass, String name, EnumCreatureType typeMob, int primColor, int secColor, BiomeGenBase biome, int arg1, int arg2, int arg3){
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		EntityRegistry.registerModEntity(entityClass, name, entityID, MythologyMod.instance, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, arg1, arg2, arg3, typeMob, biome);
        EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primColor, secColor));
	}
	
	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	public static void registerBlock(Block block)
    {
    	GameRegistry.registerBlock(block, block.getUnlocalizedName());
    }
	
	public static void registerOreBlock(Block block)
    {
    	GameRegistry.registerBlock(block, block.getUnlocalizedName());
        OreDictionary.registerOre(block.getUnlocalizedName(), block);
    }
	
	public static void registerOreItem(Item item)
    {
    	GameRegistry.registerItem(item, item.getUnlocalizedName());
        OreDictionary.registerOre(item.getUnlocalizedName(), item);
    }
}
