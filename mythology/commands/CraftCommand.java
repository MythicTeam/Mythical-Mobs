package mythology.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CraftCommand extends CommandBase
{
    public String getCommandName()
    {
        return "craft";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 2;
    }
    
	@Override
	public List getCommandAliases() {
		List list = new ArrayList<String>();
		list.add("crafting");
		list.add("craftingtable");
		list.add("ct");
		list.add("workbench");
		list.add("wb");
		return list;
	}

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return "commands.craft.usage";
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] stringArray)
    {
        EntityPlayerMP sender = getCommandSenderAsPlayer(par1ICommandSender);
        if (stringArray.length == 0)
        {
        	sender.displayGUIWorkbench((int)sender.posX, (int)sender.posY, (int)sender.posZ);
        }
        else throw new WrongUsageException("commands.craft.usage", new Object[0]);
    }
}