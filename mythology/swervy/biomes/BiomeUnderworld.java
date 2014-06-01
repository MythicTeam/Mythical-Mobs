package mythology.swervy.biomes;

import java.util.Random;

import mythology.init.MythicalBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeUnderworld extends BiomeGenBase {
	
	private WorldGenerator WorldGenTrees;
	private WorldGenerator WorldGenLakes;
	int color;
	
	public BiomeUnderworld(int id) {
		super(id);
		this.theBiomeDecorator.treesPerChunk = 50;
		this.canSpawnLightningBolt();
		this.setDisableRain();
		//this.worldGeneratorTrees = new net.minecraft.world.gen.feature.WorldGenTrees(true);
		//this.topBlock = MythicalBlocks.underworldGrass;
		//this.fillerBlock = MythicalBlocks.underworldDirt;
		//this.WorldGenTrees = new WorldGenHugeTrees();
		this.WorldGenLakes = new WorldGenLiquids(Blocks.water);
	}

}