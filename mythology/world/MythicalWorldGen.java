package mythology.world;

import java.util.Random;

import mythology.MythologyMod;
import mythology.init.MythicalBlocks;
import mythology.swervy.common.Registration;
import mythology.swervy.world.WorldGenDeadTrees;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;


public class MythicalWorldGen implements IWorldGenerator{
	
	MythicalBlocks mb = new MythicalBlocks();
	
	int spawn;
	
	@Override
	public void generate(Random rand, int x, int z, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(rand, x * 16, z * 16, world);
			break;
		case 0:
			generateSurface(rand, x * 16, z * 16, world);
			break;
		case 1:
			generateEnd(rand, x * 16, z * 16, world);
			break;
		case 8:
			generateUnder(rand, x * 16, z * 16, world);
			break;
		default:
			;
		}
	}

	private void generateNether(Random rand, int i, int j, World world) {

	}

	private void generateEnd(Random rand, int i, int j, World world) {
		
	}

	private void generateSurface(Random rand, int i, int j, World world) {
		
		//addOre(block, blockSpawn, random, world, posX, posZ, minY, maxY, minVeinSize, maxVeinSize, spawnChance);
		
		//Like Coal
		addOre(mb.blockCopperOre, Blocks.stone, rand, world, i, j, 1, 126, 5, 7, (int) 1.19); // 1.19% Chance of Spawning
		addOre(mb.blockSilverOre, Blocks.stone, rand, world, i, j, 1, 126, 5, 7, (int) 1.10); // 1.10% Chance of Spawning
		
		//Like Iron
		addOre(mb.blockZincOre, Blocks.stone, rand, world, i, j, 1, 65, 4, 6, (int) 0.68); // 0.68% Chance of Spawning
        addOre(mb.blockTinOre, Blocks.stone, rand, world, i, j, 1, 65, 4, 6, (int) 0.68); // 0.68% Chance of Spawning
        
        addOceanOre(mb.blockCelestialBronzeOre, Blocks.gravel, rand, world, i, j, 1, 65, 3, 5, (int) 0.66); // 0.66% Chance of Spawning
        addOceanOre(mb.blockCelestialBronzeOre, Blocks.stone, rand, world, i, j, 1, 65, 3, 5, (int) 0.66); // 0.66% Chance of Spawning
		
		//Like Gold
		addDesertOre(mb.blockImperialGoldOre, Blocks.stone, rand, world, i, j, 1, 33, 5, 7, (int) 0.13); // 0.13% Chance of Spawning
		
		//Like Redstone
		
		
		//Like Lapis Lazuli
		
		
		//Like Diamond
		addOre(mb.blockPlatinumOre, Blocks.stone, rand, world, i, j, 1, 19, 3, 5, (int) 0.12); // 0.14% Chance of Spawning
		addOre(mb.blockRubyOre, Blocks.stone, rand, world, i, j, 1, 19, 3, 5, (int) 0.12); // 0.14% Chance of Spawning
        addOre(mb.blockSapphireOre, Blocks.stone, rand, world, i, j, 1, 19, 3, 5, (int) 0.12); // 0.14% Chance of Spawning
		addOre(mb.blockMithrilOre, Blocks.stone, rand, world, i, j, 1, 15, 1, 4, (int) 0.9);  // 0.9% Chance of Spawning

		BiomeGenBase biome = world.getBiomeGenForCoords(i, j);
		if(biome.biomeID == 1){
			
			if(rand.nextInt(5) == 1){
				
				for(int a =0; a < 1; a++){
					int RandPosX = i + rand.nextInt(16);
					int RandPosY = rand.nextInt(150);
					int RandPosZ = j + rand.nextInt(16);
					(new GnomeVillage()).generate(world, rand, RandPosX, RandPosY, RandPosZ);
				}
			
			}
		}
	}
	
	private void generateUnder(Random random, int i, int j, World world) {
		
        addOre(Blocks.glowstone, Blocks.stone, random, world, i, j, 60, 70, 1, 4, 100);

		BiomeGenBase biome = world.getBiomeGenForCoords(i, j);
			
		//Tree Spawn
		for(int t = 0; t < 50; t++){
			int Xcoord1 = i + random.nextInt(16);
			int Ycoord1 = random.nextInt(90);
			int Zcoord1 = j + random.nextInt(16);
			
			(new WorldGenDeadTrees(false, 5, 0, 0, true)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
		}
		
		//Ore Spawn
		if(random.nextInt(5) == 1){
				
			for(int a =0; a < 1; a++){
				int RandPosX = i + random.nextInt(16);
				int RandPosY = random.nextInt(150);
				int RandPosZ = j + random.nextInt(16);
				(new GnomeVillage()).generate(world, random, RandPosX, RandPosY, RandPosZ);
			}
		}
	}

	private void addOre(Block block, Block blockSpawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int spawnChance) {
		for (int i = 0; i < spawnChance; i++) {
			int defaultChunkSize = 16;

			int xPos = posX + random.nextInt(defaultChunkSize);
			int yPos = minY + random.nextInt(maxY - minY);
			int zPos = posZ + random.nextInt(defaultChunkSize);

			new WorldGenMinable(block,(minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), blockSpawn).generate(world, random, xPos, yPos, zPos);
		}
	}
	
	private void addOceanOre(Block block, Block blockSpawn, Random random,
			World world, int posX, int posZ, int minY, int maxY,
			int minVeinSize, int maxVeinSize, int spawnChance) {
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(posX ,posZ);
		if(biome instanceof BiomeGenOcean){
			for (int i = 0; i < spawnChance; i++) {
				int defaultChunkSize = 16;
				int xPos = posX + random.nextInt(defaultChunkSize);
				int yPos = minY + random.nextInt(maxY - minY);
				int zPos = posZ + random.nextInt(defaultChunkSize);

				new WorldGenMinable(block,(minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), blockSpawn).generate(world, random, xPos, yPos, zPos);
			}
		}
	
	}
	private void addDesertOre(Block block, Block blockSpawn, Random random,
			World world, int posX, int posZ, int minY, int maxY,
			int minVeinSize, int maxVeinSize, int spawnChance) {
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(posX ,posZ);
		if(biome instanceof BiomeGenDesert){
			for (int i = 0; i < spawnChance; i++) {
				int defaultChunkSize = 16;
				int xPos = posX + random.nextInt(defaultChunkSize);
				int yPos = minY + random.nextInt(maxY - minY);
				int zPos = posZ + random.nextInt(defaultChunkSize);

				new WorldGenMinable(block,(minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), blockSpawn).generate(world, random, xPos, yPos, zPos);
			}
		}
	}
}
