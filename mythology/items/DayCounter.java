package mythology.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DayCounter extends MythItem{

	public DayCounter(String name) {
		super(name, "Nothing");
		setMaxStackSize(1);
	}
	
    /**
     * allows items to add custom lines of information to the mouseover description
     */
	@Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {
		int day = (int)player.worldObj.getTotalWorldTime() / 24000 + 1;
		list.add("Counts in-game minecraft days.");
		list.add("Does not count skipped time (bed/command)!");
    	list.add(EnumChatFormatting.WHITE + "Day " + day);
    }
}
