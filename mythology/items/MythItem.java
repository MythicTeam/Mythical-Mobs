package mythology.items;

import java.util.List;

import mythology.MythologyMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MythItem extends Item{
	
	String info;	
	
	public MythItem(String name, String lore){
		setCreativeTab(MythologyMod.tabMythical);
		setTextureName(MythologyMod.modid + ":" + name);
		setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
		info = lore;
	}
	
    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {
    	list.add(info);
    }
}
