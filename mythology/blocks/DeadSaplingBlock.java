package mythology.blocks;

import java.util.List;
import java.util.Random;

import mythology.MythologyMod;
import mythology.init.MythicalBlocks;
import mythology.world.WorldGenDeadTrees;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DeadSaplingBlock extends BlockBush implements IGrowable {
	
    public static final String[] field_149882_a = new String[] {"dead"};
    private static final IIcon[] field_149881_b = new IIcon[field_149882_a.length];
    private static final String __OBFID = "CL_00000305";

    public DeadSaplingBlock(String string, Material leaves) {
    	super(Material.plants);
        float f = 0.4F;
        this.setCreativeTab(MythologyMod.tabMythicalUnderworld);
        this.setBlockTextureName(MythologyMod.modid + ":/plants/underworld/" + "deadSapling");
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        GameRegistry.registerBlock(this, "deadSapling");
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this, 3), new Object[] { "xx", "xx", 'x', Blocks.sapling}));
        this.setBlockName("deadSapling");
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
        if (!p_149674_1_.isRemote) {
            super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);

            if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9 && p_149674_5_.nextInt(7) == 0) {
                this.func_149879_c(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
            }
        }
    }
    
    @Override
    public boolean canPlaceBlockOn(Block block){
        return block == MythicalBlocks.blockDeadGrass || block == MythicalBlocks.blockDeadDirt;
    }

    public void func_149879_c(World world, int x, int y, int z, Random rand) {
        int l = world.getBlockMetadata(x, y, z);

        if ((l & 8) == 0) {
        	world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
        } else {
            this.func_149878_d(world, x, y, z, rand);
        }
    }

    public void func_149878_d(World world, int x, int y, int z, Random rand) {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, rand, x, y, y)) return;
        int l = world.getBlockMetadata(x, y, y) & 7;
        Object object = rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenDeadTrees(true, 5, 0, 0, true);
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        switch (l) {
        case 0:
        default:
            break;
        case 1:
            label78:

            for (i1 = 0; i1 >= -1; --i1) {
                for (j1 = 0; j1 >= -1; --j1) {
                    if (this.func_149880_a(world, x + i1, y, y + j1, 1) && this.func_149880_a(world, x + i1 + 1, y, y + j1, 1) && this.func_149880_a(world, x + i1, y, y + j1 + 1, 1) && this.func_149880_a(world, x + i1 + 1, y, y + j1 + 1, 1)) {
                        object = new WorldGenMegaPineTree(false, rand.nextBoolean());
                        flag = true;
                        break label78;
                    }
                }
            }

            if (!flag) {
                j1 = 0;
                i1 = 0;
                object = new WorldGenTaiga2(true);
            }

            break;
        case 2:
            object = new WorldGenForest(true, false);
            break;
        case 3:
            label93:

            for (i1 = 0; i1 >= -1; --i1) {
                for (j1 = 0; j1 >= -1; --j1) {
                    if (this.func_149880_a(world, x + i1, y, y + j1, 3) && this.func_149880_a(world, x + i1 + 1, y, y + j1, 3) && this.func_149880_a(world, x + i1, y, y + j1 + 1, 3) && this.func_149880_a(world, x + i1 + 1, y, y + j1 + 1, 3)) {
                        object = new WorldGenMegaJungle(true, 10, 20, 3, 3);
                        flag = true;
                        break label93;
                    }
                }
            }

            if (!flag) {
                j1 = 0;
                i1 = 0;
                object = new WorldGenDeadTrees(true, 4 + rand.nextInt(7), 3, 3, false);
            }

            break;
        case 4:
            object = new WorldGenSavannaTree(true);
            break;
        case 5:
            label108:

            for (i1 = 0; i1 >= -1; --i1) {
                for (j1 = 0; j1 >= -1; --j1) {
                    if (this.func_149880_a(world, x + i1, y, y + j1, 5) && this.func_149880_a(world, x + i1 + 1, y, y + j1, 5) && this.func_149880_a(world, x + i1, y, y + j1 + 1, 5) && this.func_149880_a(world, x + i1 + 1, y, y + j1 + 1, 5)) {
                        object = new WorldGenCanopyTree(true);
                        flag = true;
                        break label108;
                    }
                }
            }

            if (!flag) {
                return;
            }
        }

        Block block = Blocks.air;

        if (flag) {
            world.setBlock(x + i1, y, y + j1, block, 0, 4);
            world.setBlock(x + i1 + 1, y, y + j1, block, 0, 4);
            world.setBlock(x + i1, y, y + j1 + 1, block, 0, 4);
            world.setBlock(x + i1 + 1, y, y + j1 + 1, block, 0, 4);
        } else {
            world.setBlock(x, y, y, block, 0, 4);
        }

        if (!((WorldGenerator) object).generate(world, rand, x + i1, y, y + j1)) {
            if (flag) {
                world.setBlock(x + i1, y, y + j1, this, l, 4);
                world.setBlock(x + i1 + 1, y, y + j1, this, l, 4);
                world.setBlock(x + i1, y, y + j1 + 1, this, l, 4);
                world.setBlock(x + i1 + 1, y, y + j1 + 1, this, l, 4);
            } else {
                world.setBlock(x, y, y, this, l, 4);
            }
        }
    }

    public boolean func_149880_a(World world, int p_149880_2_, int p_149880_3_, int p_149880_4_, int p_149880_5_) {
        return world.getBlock(p_149880_2_, p_149880_3_, p_149880_4_) == this && (world.getBlockMetadata(p_149880_2_, p_149880_3_, p_149880_4_) & 7) == p_149880_5_;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_) {
        return MathHelper.clamp_int(p_149692_1_ & 7, 0, 5);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
    }
    
    public boolean func_149851_a(World world, int x, int y, int z, boolean b) {
        return true;
    }

    public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
        return (double) world.rand.nextFloat() < 0.45D;
    }

    public void func_149853_b(World world, Random rand, int x, int y, int z) {
        this.func_149879_c(world, x, y, z, rand);
    }
}