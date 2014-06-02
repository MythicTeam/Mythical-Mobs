package mythology.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class AdmintoolDamageChanger extends MythItem{

	public AdmintoolDamageChanger(String name, String lore) {
		super(name, lore);
		setMaxStackSize(1);
	}
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER){
        	int x = par4;
        	int y = par5;
        	int z = par6;
        	int meta = par3World.getBlockMetadata(x, y, z);
    		
        	meta++;
        	
        	meta &= 0xF;
        	
        	par3World.setBlockMetadataWithNotify(x, y, z, meta, 2);
    	}	    	
    	return true;
    }
}
