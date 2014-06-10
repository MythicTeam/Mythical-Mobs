package mythology.biomes;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mythology.init.MythicalBlocks;
import mythology.mobs.hostile.EntityUnderworldSheep;
import mythology.world.WorldGenDeadTrees;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenMutated;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.entity.boss.EntityDragon;

public class BiomeUnderworld extends BiomeGenBase {

    private WorldGenerator WorldGenTrees;
    private WorldGenerator WorldGenLakes;
    int color;

    public BiomeUnderworld(int id) {
        super(id);
        this.canSpawnLightningBolt();
        this.setDisableRain();
        this.WorldGenTrees = new WorldGenDeadTrees(true);
        this.topBlock = MythicalBlocks.blockDeadGrass;
        this.fillerBlock = MythicalBlocks.blockDeadDirt;
        //this.WorldGenTrees = new WorldGenHugeTrees();
        this.WorldGenLakes = new WorldGenLiquids(Blocks.water);
        
        this.theBiomeDecorator.treesPerChunk = 6;
        this.theBiomeDecorator.flowersPerChunk = 100;
        this.theBiomeDecorator.grassPerChunk = 1;
        
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
                                                                                                                      
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityUnderworldSheep.class, 2, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 5, 1, 4));
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

        for (int l1 = 255; l1 >= 0; --l1) {
            int i2 = (j1 * 16 + i1) * k1 + l1;

            if (l1 <= 0 + rand.nextInt(5)) {
                blocks[i2] = MythicalBlocks.blockDeadRack;
            } else {
                Block block2 = blocks[i2];

                if (block2 != null && block2.getMaterial() != Material.air) {
                    if (block2 == Blocks.stone) {
                        if (k == -1) {
                            if (l <= 0) {
                                block = null;
                                b0 = 0;
                                block1 = MythicalBlocks.blockDeadStone;
                            } else if (l1 >= 59 && l1 <= 64) {
                                block = this.topBlock;
                                b0 = (byte)(this.field_150604_aj & 255);
                                block1 = this.fillerBlock;
                            }

                            if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
                                if (this.getFloatTemperature(int1, l1, int2) < 0.15F) {
                                    block = Blocks.ice;
                                    b0 = 0;
                                } else {
                                    block = Blocks.water;
                                    b0 = 0;
                                }
                            }

                            k = l;

                            if (l1 >= 62) {
                                blocks[i2] = block;
                                bytes[i2] = b0;
                            } else if (l1 < 56 - l) {
                                block = null;
                                block1 = MythicalBlocks.blockDeadStone;
                                blocks[i2] = Blocks.gravel;
                            } else {
                                blocks[i2] = block1;
                            }
                        } else if (k > 0) {
                            --k;
                            blocks[i2] = block1;

                            if (k == 0 && block1 == Blocks.sand) {
                                k = rand.nextInt(4) + Math.max(0, l1 - 63);
                                block1 = Blocks.sandstone;
                            }
                        }
                    }
                } else {
                    k = -1;
                }
            }
        }
    }
}