package mythology.items;

import mythology.init.MythicalBlocks;
import mythology.init.MythicalItems;
import mythology.init.MythicalTools;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Mjolnir extends ItemWarhammer {
	private Entity EntityLightningBolt;

	public Mjolnir() {
		super(ToolMaterial.EMERALD, "mjolnir", "A legendary hammer. Controls thunder.");
	}

	public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
		if (player.worldObj.getBlock(x, y, z) == Blocks.stone && player.capabilities.allowEdit) {
    		player.worldObj.setBlock(x, y, z, MythicalBlocks.crackedStone);
			return true;
		}
		else return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack itemstack, int pass) {
		return true;
	}

    public float func_150893_a(ItemStack itemstack, Block block)
    {
    	Material material = block.getMaterial();
    	if (block == Blocks.stone){
    		return 200;
    	}
    	return material != Material.rock && material != Material.iron && material != Material.piston && material != Material.packedIce && material != Material.ice ? 1.0F : 1.5F;
    }
    
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5)
    {
    	if (entity instanceof EntityPlayer){
    		EntityPlayer player = ((EntityPlayer)entity);
        	if(!player.inventory.hasItem(MythicalItems.jarngreipr)){
        		player.inventory.consumeInventoryItem(this);
        		player.inventory.addItemStackToInventory(new ItemStack(MythicalTools.mjolnirUseless));
        	}
    	}
    }

	public ItemStack onItemRightClick(ItemStack itemstack, World world,	EntityPlayer player){
		if(!world.isRemote)	{
			double x = player.posX;			
			double y = player.posY;
			double z = player.posZ;
			world.addWeatherEffect(new EntityLightningBolt(world, x, y+10, z));
		}
	return itemstack;
	}
}
