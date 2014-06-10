package mythology.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.BlockSapling;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DeadLogBlock extends BlockLog {
    public static final String[] field_150168_M = new String[] {"side"};
    private static final String __OBFID = "CL_00000281";

    public DeadLogBlock() {
    	super();
    	this.setCreativeTab(MythologyMod.tabMythicalUnderworld);
    	this.setHardness(2.0F);
        this.setStepSound(soundTypeWood);
        GameRegistry.registerBlock(this, "deadLog");
        this.setBlockName("deadLog");
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
        list.add(new ItemStack(item, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iiconregister) {
        this.field_150167_a = new IIcon[field_150168_M.length];
        this.field_150166_b = new IIcon[field_150168_M.length];

        for (int i = 0; i < this.field_150167_a.length; ++i) {
            this.field_150167_a[i] = iiconregister.registerIcon(MythologyMod.modid + ":blocks/underworld/deadLog" + "_side");
            this.field_150166_b[i] = iiconregister.registerIcon(MythologyMod.modid + ":blocks/underworld/deadLog" + "_side" + "_top");
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random rand) {
        return 1;
    }

    public Item getItemDropped(int var1, Random rand, int var2) {
        return Item.getItemFromBlock(this);
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int var1) {
        byte b0 = 4;
        int i1 = b0 + 1;

        if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1)) {
            for (int j1 = -b0; j1 <= b0; ++j1) {
                for (int k1 = -b0; k1 <= b0; ++k1) {
                    for (int l1 = -b0; l1 <= b0; ++l1) {
                        Block block1 = world.getBlock(x + j1, y + k1, z + l1);
                        if (block1.isLeaves(world, x + j1, y + k1, z + l1)) {
                            block1.beginLeavesDecay(world, x + j1, y + k1, z + l1);
                        }
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int p_150163_1_) {
        return this.field_150167_a[p_150163_1_ % this.field_150167_a.length];
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_) {
        return this.field_150166_b[p_150161_1_ % this.field_150166_b.length];
    }

    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
        return true;
    }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z) {
        return true;
    }
}