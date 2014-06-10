package mythology.swervy.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mythology.MythologyMod;
import mythology.dimension.TelporterUnderworld;
import mythology.init.MythicalBlocks;
import mythology.init.MythicalRegistration;
import mythology.swervy.common.Registration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class PortalBlock extends BlockPortal {
	
	public static final int[][] field_150001_a = new int[][] {new int[0], {3, 1}, {2, 0}};
	private static final String __OBFID = "CL_00000284";

	@SideOnly(Side.CLIENT)
    private IIcon[] field_149850_M;
	
	private static int field_150864_e = 0;
	private int field_150862_g;
    private int field_150868_h;
	
    public PortalBlock(String string, Material portal) {
    	GameRegistry.registerBlock(this, string);
        this.setCreativeTab(MythologyMod.tabMythicalUnderworld);
        this.setHardness(-1.0F);
        this.setLightLevel(0.75F);
        //this.setBlockTextureName(MythologyMod.modid + ":" + "underworldPortal");
    }  

    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
        super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);

        if (p_149674_1_.provider.isSurfaceWorld() && p_149674_1_.getGameRules().getGameRuleBooleanValue("doMobSpawning") && p_149674_5_.nextInt(2000) < p_149674_1_.difficultySetting.getDifficultyId()) {
            int l;

            for (l = p_149674_3_; !World.doesBlockHaveSolidTopSurface(p_149674_1_, p_149674_2_, l, p_149674_4_) && l > 0; --l) {;
            }

            if (l > 0 && !p_149674_1_.getBlock(p_149674_2_, l + 1, p_149674_4_).isNormalCube()) {
                Entity entity = ItemMonsterPlacer.spawnCreature(p_149674_1_, 57, (double) p_149674_2_ + 0.5D, (double) l + 1.1D, (double) p_149674_4_ + 0.5D);

                if (entity != null) {
                    entity.timeUntilPortal = entity.getPortalCooldown();
                }
            }
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
        int l = func_149999_b(p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_));

        if (l == 0) {
            if (p_149719_1_.getBlock(p_149719_2_ - 1, p_149719_3_, p_149719_4_) != this && p_149719_1_.getBlock(p_149719_2_ + 1, p_149719_3_, p_149719_4_) != this) {
                l = 2;
            } else {
                l = 1;
            }

            if (p_149719_1_ instanceof World && !((World) p_149719_1_).isRemote) {
                ((World) p_149719_1_).setBlockMetadataWithNotify(p_149719_2_, p_149719_3_, p_149719_4_, l, 2);
            }
        }

        float f = 0.125F;
        float f1 = 0.125F;

        if (l == 1) {
            f = 0.5F;
        }

        if (l == 2) {
            f1 = 0.5F;
        }

        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public static boolean tryToCreatePortal(World world, int x, int y, int z) {
    	PortalBlock.Size size = new PortalBlock.Size(world, x, y, z, 1);
    	PortalBlock.Size size1 = new PortalBlock.Size(world, x, y, z, 2);

        if (size.func_150860_b() && field_150864_e == 0) {
            size.func_150859_c();
            return true;
        } else if (size1.func_150860_b() && field_150864_e == 0) {
            size1.func_150859_c();
            return true;
        } else {
            return false;
        }
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        int l = func_149999_b(world.getBlockMetadata(x, y, z));
        PortalBlock.Size size = new PortalBlock.Size(world, x, y, z, 1);
        PortalBlock.Size size1 = new PortalBlock.Size(world, x, y, z, 2);

        if (l == 1 && (!size.func_150860_b() || this.field_150864_e < this.field_150868_h * this.field_150862_g)) {
        	world.setBlock(x, y, z, Blocks.air);
        } else if (l == 2 && (!size1.func_150860_b() || this.field_150864_e < this.field_150868_h * this.field_150862_g)) {
        	world.setBlock(x, y, z, Blocks.air);
        } else if (l == 0 && !size.func_150860_b() && !size1.func_150860_b()) {
        	world.setBlock(x, y, z, Blocks.air);
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
        int i1 = 0;

        if (p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_) == this) {
            i1 = func_149999_b(p_149646_1_.getBlockMetadata(p_149646_2_, p_149646_3_, p_149646_4_));

            if (i1 == 0) {
                return false;
            }

            if (i1 == 2 && p_149646_5_ != 5 && p_149646_5_ != 4) {
                return false;
            }

            if (i1 == 1 && p_149646_5_ != 3 && p_149646_5_ != 2) {
                return false;
            }
        }

        boolean flag = p_149646_1_.getBlock(p_149646_2_ - 1, p_149646_3_, p_149646_4_) == this && p_149646_1_.getBlock(p_149646_2_ - 2, p_149646_3_, p_149646_4_) != this;
        boolean flag1 = p_149646_1_.getBlock(p_149646_2_ + 1, p_149646_3_, p_149646_4_) == this && p_149646_1_.getBlock(p_149646_2_ + 2, p_149646_3_, p_149646_4_) != this;
        boolean flag2 = p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_ - 1) == this && p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_ - 2) != this;
        boolean flag3 = p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_ + 1) == this && p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_ + 2) != this;
        boolean flag4 = flag || flag1 || i1 == 1;
        boolean flag5 = flag2 || flag3 || i1 == 2;
        return flag4 && p_149646_5_ == 4 ? true : (flag4 && p_149646_5_ == 5 ? true : (flag5 && p_149646_5_ == 2 ? true : flag5 && p_149646_5_ == 3));
    }

    public int quantityDropped(Random p_149745_1_) {
        return 0;
    }

    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
        if(p_149670_5_.ridingEntity == null && p_149670_5_.riddenByEntity == null && p_149670_5_ instanceof EntityPlayerMP) {
        	EntityPlayerMP player = (EntityPlayerMP) p_149670_5_;
        	MinecraftServer server = MinecraftServer.getServer();
        	
        	if(player.timeUntilPortal > 0) {
        		player.timeUntilPortal = 10;
        	} else if(player.dimension != Registration.underworld) {
        		player.timeUntilPortal = 10;
        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, Registration.underworld, new TelporterUnderworld(server.worldServerForDimension(Registration.underworld)));       		
        	} else {
        		player.timeUntilPortal = 10;
        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TelporterUnderworld(server.worldServerForDimension(0)));
        	}
        }
		
        /*
		if (p_149670_5_.ridingEntity == null && p_149670_5_.riddenByEntity == null) {
            p_149670_5_.setInPortal();
        }
        */
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
        if (p_149734_5_.nextInt(100) == 0) {
            p_149734_1_.playSound((double) p_149734_2_ + 0.5D, (double) p_149734_3_ + 0.5D, (double) p_149734_4_ + 0.5D, "portal.portal", 0.5F, p_149734_5_.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int l = 0; l < 4; ++l) {
            double d0 = (double)((float) p_149734_2_ + p_149734_5_.nextFloat());
            double d1 = (double)((float) p_149734_3_ + p_149734_5_.nextFloat());
            double d2 = (double)((float) p_149734_4_ + p_149734_5_.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = p_149734_5_.nextInt(2) * 2 - 1;
            d3 = ((double) p_149734_5_.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double) p_149734_5_.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double) p_149734_5_.nextFloat() - 0.5D) * 0.5D;

            if (p_149734_1_.getBlock(p_149734_2_ - 1, p_149734_3_, p_149734_4_) != this && p_149734_1_.getBlock(p_149734_2_ + 1, p_149734_3_, p_149734_4_) != this) {
                d0 = (double) p_149734_2_ + 0.5D + 0.25D * (double) i1;
                d3 = (double)(p_149734_5_.nextFloat() * 2.0F * (float) i1);
            } else {
                d2 = (double) p_149734_4_ + 0.5D + 0.25D * (double) i1;
                d5 = (double)(p_149734_5_.nextFloat() * 2.0F * (float) i1);
            }

            p_149734_1_.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }
    }

    public static int func_149999_b(int p_149999_0_) {
        return p_149999_0_ & 3;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return Item.getItemById(0);
    }

    public static class Size {
        private final World field_150867_a;
        private final int field_150865_b;
        private final int field_150866_c;
        private final int field_150863_d;
        private ChunkCoordinates field_150861_f;
        private int field_150862_g;
        private int field_150868_h;
		private int field_150864_e;
        private static final String __OBFID = "CL_00000285";

        public Size(World p_i45415_1_, int p_i45415_2_, int p_i45415_3_, int p_i45415_4_, int p_i45415_5_) {
            this.field_150867_a = p_i45415_1_;
            this.field_150865_b = p_i45415_5_;
            this.field_150863_d = BlockPortal.field_150001_a[p_i45415_5_][0];
            this.field_150866_c = BlockPortal.field_150001_a[p_i45415_5_][1];

            for (int i1 = p_i45415_3_; p_i45415_3_ > i1 - 21 && p_i45415_3_ > 0 && this.func_150857_a(p_i45415_1_.getBlock(p_i45415_2_, p_i45415_3_ - 1, p_i45415_4_)); --p_i45415_3_) {;
            }

            int j1 = this.func_150853_a(p_i45415_2_, p_i45415_3_, p_i45415_4_, this.field_150863_d) - 1;

            if (j1 >= 0) {
                this.field_150861_f = new ChunkCoordinates(p_i45415_2_ + j1 * Direction.offsetX[this.field_150863_d], p_i45415_3_, p_i45415_4_ + j1 * Direction.offsetZ[this.field_150863_d]);
                this.field_150868_h = this.func_150853_a(this.field_150861_f.posX, this.field_150861_f.posY, this.field_150861_f.posZ, this.field_150866_c);

                if (this.field_150868_h < 2 || this.field_150868_h > 21) {
                    this.field_150861_f = null;
                    this.field_150868_h = 0;
                }
            }

            if (this.field_150861_f != null) {
                this.field_150862_g = this.func_150858_a();
            }
        }

        protected int func_150853_a(int p_150853_1_, int p_150853_2_, int p_150853_3_, int p_150853_4_) {
            int j1 = Direction.offsetX[p_150853_4_];
            int k1 = Direction.offsetZ[p_150853_4_];
            int i1;
            Block block;

            for (i1 = 0; i1 < 22; ++i1) {
                block = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_, p_150853_3_ + k1 * i1);

                if (!this.func_150857_a(block)) {
                    break;
                }

                Block block1 = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_ - 1, p_150853_3_ + k1 * i1);

                if (block1 != Blocks.soul_sand) {
                    break;
                }
            }

            block = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_, p_150853_3_ + k1 * i1);
            return block == Blocks.soul_sand ? i1 : 0;
        }

        protected int func_150858_a() {
            int i;
            int j;
            int k;
            int l;
            label56:

            for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g) {
                i = this.field_150861_f.posY + this.field_150862_g;

                for (j = 0; j < this.field_150868_h; ++j) {
                    k = this.field_150861_f.posX + j * Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][1]];
                    l = this.field_150861_f.posZ + j * Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][1]];
                    Block block = this.field_150867_a.getBlock(k, i, l);

                    if (!this.func_150857_a(block)) {
                        break label56;
                    }

                    if (block == MythicalBlocks.blockPortal) {
                       this.field_150864_e++;
                    }

                    if (j == 0) {
                        block = this.field_150867_a.getBlock(k + Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][0]], i, l + Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][0]]);

                        if (block != Blocks.soul_sand) {
                            break label56;
                        }
                    } else if (j == this.field_150868_h - 1) {
                        block = this.field_150867_a.getBlock(k + Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][1]], i, l + Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][1]]);

                        if (block != Blocks.soul_sand) {
                            break label56;
                        }
                    }
                }
            }

            for (i = 0; i < this.field_150868_h; ++i) {
                j = this.field_150861_f.posX + i * Direction.offsetX[PortalBlock.field_150001_a[this.field_150865_b][1]];
                k = this.field_150861_f.posY + this.field_150862_g;
                l = this.field_150861_f.posZ + i * Direction.offsetZ[PortalBlock.field_150001_a[this.field_150865_b][1]];

                if (this.field_150867_a.getBlock(j, k, l) != Blocks.soul_sand) {
                    this.field_150862_g = 0;
                    break;
                }
            }

            if (this.field_150862_g <= 21 && this.field_150862_g >= 3) {
                return this.field_150862_g;
            } else {
                this.field_150861_f = null;
                this.field_150868_h = 0;
                this.field_150862_g = 0;
                return 0;
            }
        }

        protected boolean func_150857_a(Block p_150857_1_) {
            return p_150857_1_.getMaterial() == Material.air || p_150857_1_ == MythicalBlocks.blockBlueFire || p_150857_1_ == MythicalBlocks.blockPortal;
        }

        public boolean func_150860_b() {
            return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
        }

        public void func_150859_c() {
            for (int i = 0; i < this.field_150868_h; ++i) {
                int j = this.field_150861_f.posX + Direction.offsetX[this.field_150866_c] * i;
                int k = this.field_150861_f.posZ + Direction.offsetZ[this.field_150866_c] * i;

                for (int l = 0; l < this.field_150862_g; ++l) {
                    int i1 = this.field_150861_f.posY + l;
                    this.field_150867_a.setBlock(j, i1, k, MythicalBlocks.blockPortal, this.field_150865_b, 2);
                }
            }
        }
    }
}