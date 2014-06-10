package mythology.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Mjolnir extends ItemWarhammer {
	
	public Mjolnir() {
		super(ToolMaterial.EMERALD, "mjolnir", "A legendary hammer. Controls thunder.");
	}

	public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
		if (player.worldObj.getBlock(x, y, z) == Blocks.stone && player.capabilities.allowEdit) {
			player.worldObj.setBlock(x, y, z, Blocks.cobblestone);
			return true;
		}
		else return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack, int pass) {
		return true;
	}

	// TODO Add thunder on right click
}
