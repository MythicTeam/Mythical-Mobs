package mythology.init;

import mythology.MythologyMod;
import mythology.mobs.passive.EntityGnome;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.projectile.EntityEgg;
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

	public static void addMob(Class entityClass, String name, EnumCreatureType typeMob, BiomeGenBase biome, int arg1, int arg2, int arg3){
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		EntityRegistry.registerModEntity(entityClass, name, entityID, MythologyMod.instance, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, arg1, arg2, arg3, typeMob, biome);
        //EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primColor, secColor));
	}
	
	public static void registerItem(Item item) {
		String name = item.getUnlocalizedName().replace("item.", "");
		GameRegistry.registerItem(item, name);
	}
	
	public static void registerBlock(Block block)
    {
		String name = block.getUnlocalizedName().replace("block.", "");
    	GameRegistry.registerBlock(block, name);
    }
	
	public static void registerOreBlock(Block block)
    {
		String name = block.getUnlocalizedName().replace("block.", "");
    	GameRegistry.registerBlock(block, name);
        OreDictionary.registerOre(name, block);
    }
	
	public static void registerOreItem(Item item)
    {
		String name = item.getUnlocalizedName().replace("item.", "");
    	GameRegistry.registerItem(item, name);
        OreDictionary.registerOre(name, item);
    }
}
