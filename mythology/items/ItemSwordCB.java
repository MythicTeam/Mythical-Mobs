package mythology.items;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mythology.MythologyMod;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemSwordCB extends ItemSword{
	private static final double maxStackSize = 0;
	MythologyMod m = new MythologyMod();
	public ItemSwordCB(ToolMaterial arg0, String name) {
		super(arg0);
		GameRegistry.registerItem(this, name);
		this.setCreativeTab(m.tabMythical);
	}
		public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	    {
	        if (par7 == 0)
	        {
	            --par5;
	        }

	        if (par7 == 1)
	        {
	            ++par5;
	        }

	        if (par7 == 2)
	        {
	            --par6;
	        }

	        if (par7 == 3)
	        {
	            ++par6;
	        }

	        if (par7 == 4)
	        {
	            --par4;
	        }

	        if (par7 == 5)
	        {
	            ++par4;
	        }

	        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
	        {
	            return false;
	        }
	        else
	        {
	            if (par3World.getBlock(par4, par5, par6).getMaterial() == Material.air)
	            {
	                par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
	                par3World.setBlock(par4, par5, par6, Blocks.water);
	                
	            }
	            else if (par3World.getBlock(par4, par5, par6).getMaterial() == Material.water)
	            {
	                par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
	                par3World.setBlock(par4, par5, par6, Blocks.air);
	            }
	            par1ItemStack.damageItem(1, par2EntityPlayer);
	            return true;
	        }
	    }
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@SideOnly(Side.CLIENT)
	    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
			list.add(EnumChatFormatting.DARK_RED + "HP: " + EnumChatFormatting.WHITE + (itemStack.getMaxDamage() - itemStack.getItemDamage()));
		}
}
