package mythology.init;

import mythology.MythologyMod;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class MythologyRegister {

	public static void addMob(Class entityClass, String entityName, EnumCreatureType typeMob, BiomeGenBase biome, int primColor, int secColor, int weightedProb, int min, int max){
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, entityID);
		EntityRegistry.registerModEntity(entityClass, entityName, entityID, MythologyMod.instance, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, weightedProb, min, max, typeMob, biome);
		EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primColor, secColor));
	}
	
	public static void addProjectileEntity(Class<? extends EntityThrowable> entityClass, String entityName){
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerModEntity(entityClass, entityName, entityID, MythologyMod.instance, 64, 1, true);
	}

	public static void registerItem(Item item) {
		String name = item.getUnlocalizedName().substring(5);
		GameRegistry.registerItem(item, name);
	}
}
