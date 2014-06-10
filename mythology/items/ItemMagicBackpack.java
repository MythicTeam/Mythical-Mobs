package mythology.items;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMagicBackpack extends Item {

	public ItemMagicBackpack() {
		GameRegistry.registerItem(this, "MagicBckpack");
		MythologyMod m = new MythologyMod();

		this.maxStackSize = 1;
		this.setMaxDamage(-1);
		this.setCreativeTab(m.tabMythical);
		this.setTextureName(m.modid + ":" + "MagicBckpack");
		this.setUnlocalizedName("MagicBckpack");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		player.openGui(MythologyMod.instance, MythologyMod.guiMagicBackpack, player.worldObj, 
				(int) player.posX, 
				(int) player.posY,
				(int) player.posZ);
       
		return itemstack;
    }
}
