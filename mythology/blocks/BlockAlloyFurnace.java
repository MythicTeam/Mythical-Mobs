package mythology.blocks;

import java.util.Random;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mythology.MythologyMod;
import mythology.init.MythicalBlocks;
import mythology.tileentities.TileEntityAlloyFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAlloyFurnace extends BlockContainer{

	private final boolean isActive;
	private static boolean keepInventory;
	private Random rand = new Random();

	
	@SideOnly(Side.CLIENT)
	protected IIcon iconFront;
	@SideOnly(Side.CLIENT)
	protected IIcon iconTop;
	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon;
	
	public BlockAlloyFurnace(boolean isActive ,String string, CreativeTabs tabMythical, Material iron) {
		super(Material.rock);
		this.setBlockName("alloyFurnace");
		this.setCreativeTab(tabMythical);
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(1F);
		this.isActive = isActive;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(MythologyMod.modid + ":" + "alloyFurnaceSide");
		this.iconFront = iconRegister.registerIcon(MythologyMod.modid + ":" + (this.isActive ? "alloyFurnaceOn" : "alloyFurnaceOff"));
		this.iconTop = iconRegister.registerIcon(MythologyMod.modid + ":" + "alloyFurnaceTop"); 
	}
	 
	
	public Item getItemDropped(int par1, Random random, int par3) {
		return Item.getItemFromBlock(MythicalBlocks.alloyFurnaceIdle);
	}
	
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z){
		if(!world.isRemote){
			Block l = world.getBlock(x, y, z - 1); // = Block behind
			Block il = world.getBlock(x, y, z + 1); // = Block In front
			Block jl = world.getBlock(x - 1, y, z); // = Block to left
			Block kl = world.getBlock(x + 1, y, z); // Block to right
			
			byte bO = 3;
			 //Checks if block is opaque
			if (l.isNormalCube() && !il.isNormalCube())
	            {
	                bO = 3;
	            }

	            if (il.isNormalCube() && !l.isNormalCube())
	            {
	                bO = 2;
	            }

	            if (kl.isNormalCube() && !jl.isNormalCube())
	            {
	                bO = 5;
	            }

	            if (jl.isNormalCube() && !kl.isNormalCube())
	            {
	                bO = 4;
	            }
			world.setBlockMetadataWithNotify(x, y, z, bO, 2);
		}
	
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata){
		if(side == 3 && metadata == 0){
			return iconFront;
			} else{

			return side == 1 ? this.iconTop : (side == 0 ? this.iconTop : side != metadata ? this.blockIcon : this.iconFront);
			}
	}
	
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);

		if (tile_entity == null || player.isSneaking()) {

			return false;
		}

		player.openGui(MythologyMod.instance, MythologyMod.guiAlloyFurnace, world, x, y, z);
		

		return true;
	}
	
    public static void updateFurnaceBlockState(boolean var1, World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        keepInventory = true;

        if (var1)
        {
        	world.setBlock(x, y, z, MythicalBlocks.alloyFurnaceActive);
        }
        else
        {
        	world.setBlock(x, y, z, MythicalBlocks.alloyFurnaceIdle);
        }

        keepInventory = false;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }
    
	public TileEntity createNewTileEntity(World world, int useless) {
		
		return new TileEntityAlloyFurnace();
	}

	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        if (this.isActive)
        {
            int l = world.getBlockMetadata(x, y, z);
            float f = (float)x + 0.5F;
            float f1 = (float)y + 0.0F + rand.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)z + 0.5F;
            float f3 = 0.52F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;

            if (l == 4)
            {
            	world.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 5)
            {
            	world.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 2)
            {
            	world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 3)
            {
            	world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack){
		int l = MathHelper.floor_double((double) entityLivingBase.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		
		if(l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
			}
		
		if(l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		
		if(l == 2){
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		
		if(l == 3){
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		
		if(itemstack.hasDisplayName()){
			((TileEntityAlloyFurnace)world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());
		}
	}

	public static void updateAlloyFurnaceBlockState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
		
			int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
			TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
			keepInventory = true;
			
			if(active){
				worldObj.setBlock(xCoord, yCoord, zCoord, MythicalBlocks.alloyFurnaceActive);
			}else{
				worldObj.setBlock(xCoord, yCoord, zCoord, MythicalBlocks.alloyFurnaceIdle);
			}
			
			keepInventory = false;
			
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
			
			if(tileentity != null){
				tileentity.validate();
				worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
			}
			
		
	}
	
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldMetadata){
		if(!keepInventory){
			TileEntityAlloyFurnace tileentity = (TileEntityAlloyFurnace) world.getTileEntity(x, y, z);
			
			if(tileentity != null){
				for(int i = 0; i < tileentity.getSizeInventory(); i++){
					ItemStack itemstack = tileentity.getStackInSlot(i);
					
					if(itemstack != null){
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;
						
						while(itemstack.stackSize > 0){
							int j = this.rand.nextInt(21) + 10;
							
							if(j > itemstack.stackSize){
								j = itemstack.stackSize;
							}
							
							itemstack.stackSize -= j;
							
							EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));  
							
							if(itemstack.hasTagCompound()){
								item.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							}
							
							float f3 = 0.05F;
							item.motionX = (double)((float)this.rand.nextGaussian() * f3);
							item.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
							item.motionZ = (double)((float)this.rand.nextGaussian() * f3);
							
							world.spawnEntityInWorld(item);
						}
					}
				}
				
				world.func_147453_f(x, y, z, oldBlock);
			}
		}
		
		super.breakBlock(world, x, y, z, oldBlock, oldMetadata);
		
	}
	
	public boolean hasComparatorInputOverride(){
		return true;
		
	}
	
	public int getComparatorInputOverride(World world, int x, int y, int z, int i){
		return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(x, y, z));
	}
	
	public Item getItem(World world, int x, int y, int z){
		return Item.getItemFromBlock(MythicalBlocks.alloyFurnaceIdle);
	}
}


