package mythology.items;

import ibxm.Player;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandTime;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DayCounter extends MythItem {

	private static int time = 0;

	public DayCounter(String name) {
		super(name, "Nothing");
		setMaxStackSize(1);
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this, 1),
				new Object[] { "ppp", "pwp", "ppp", 'p', Items.paper, 'w',
						Items.clock }));
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player,
			List list, boolean par4) {
		int day = (int) player.worldObj.getTotalWorldTime() / 24000 + 1;
		list.add("Counts in-game minecraft days.");
		list.add("Does not count skipped time (bed/command)!");
		list.add(EnumChatFormatting.WHITE + "Day " + day);
	}
}
