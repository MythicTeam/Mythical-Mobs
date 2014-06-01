package mythology.swervy.biomes;

import java.util.Random;

import mythology.init.MythicalBlocks;
import mythology.swervy.common.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
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
		this.topBlock = Resources.blockDeadGrass;
		this.fillerBlock = Resources.blockDeadDirt;
		//this.WorldGenTrees = new WorldGenHugeTrees();
		this.WorldGenLakes = new WorldGenLiquids(Blocks.water);
	}
	
	@Override
	public void genTerrainBlocks(World world, Random rand, Block[] blocks, byte[] bytes, int int1, int int2, double d) {
	        boolean flag = true;
	        Block block = this.topBlock;
	        byte b0 = (byte)(this.field_150604_aj & 255);
	        Block block1 = this.fillerBlock;
	        int k = -1;
	        int l = (int)(d / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
	        int i1 = int1 & 15;
	        int j1 = int2 & 15;
	        int k1 = blocks.length / 256;

	        for (int l1 = 255; l1 >= 0; --l1)
	        {
	            int i2 = (j1 * 16 + i1) * k1 + l1;

	            if (l1 <= 0 + rand.nextInt(5))
	            {
	                blocks[i2] = Resources.blockDeadRack;
	            }
	            else
	            {
	                Block block2 = blocks[i2];

	                if (block2 != null && block2.getMaterial() != Material.air)
	                {
	                    if (block2 == Blocks.stone)
	                    {
	                        if (k == -1)
	                        {
	                            if (l <= 0)
	                            {
	                                block = null;
	                                b0 = 0;
	                                block1 = Resources.blockDeadStone;
	                            }
	                            else if (l1 >= 59 && l1 <= 64)
	                            {
	                                block = this.topBlock;
	                                b0 = (byte)(this.field_150604_aj & 255);
	                                block1 = this.fillerBlock;
	                            }

	                            if (l1 < 63 && (block == null || block.getMaterial() == Material.air))
	                            {
	                                if (this.getFloatTemperature(int1, l1, int2) < 0.15F)
	                                {
	                                    block = Blocks.ice;
	                                    b0 = 0;
	                                }
	                                else
	                                {
	                                    block = Blocks.water;
	                                    b0 = 0;
	                                }
	                            }

	                            k = l;

	                            if (l1 >= 62)
	                            {
	                                blocks[i2] = block;
	                                bytes[i2] = b0;
	                            }
	                            else if (l1 < 56 - l)
	                            {
	                                block = null;
	                                block1 = Resources.blockDeadStone;
	                                blocks[i2] = Blocks.gravel;
	                            }
	                            else
	                            {
	                                blocks[i2] = block1;
	                            }
	                        }
	                        else if (k > 0)
	                        {
	                            --k;
	                            blocks[i2] = block1;

	                            if (k == 0 && block1 == Blocks.sand)
	                            {
	                                k = rand.nextInt(4) + Math.max(0, l1 - 63);
	                                block1 = Blocks.sandstone;
	                            }
	                        }
	                    }
	                }
	                else
	                {
	                    k = -1;
	                }
	            }
	        }
	}

}