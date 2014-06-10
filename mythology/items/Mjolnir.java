package mythology.items;

import mythology.init.MythicalBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Mjolnir extends ItemWarhammer {
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

	// TODO Add thunder on right click
}
