package mythology.commands;

import java.util.ArrayList;
import java.util.List;

import mythology.util.Methods;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.WorldSettings;

public class EnderChestCommand extends CommandBase {
    public String getCommandName() {
        return "enderchest";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel() {
        return 2;
    }

    public String getCommandUsage(ICommandSender par1ICommandSender) {
        return "commands.enderchest.usage";
    }
    
	@Override
	public List getCommandAliases() {
		List l = new ArrayList<String>();
		l.add("ec");
		return l;
	}

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
        if (par2ArrayOfStr.length < 2) {
            EntityPlayerMP targetplayer = par2ArrayOfStr.length > 2 ? getPlayer(par1ICommandSender, par2ArrayOfStr[1]) : getCommandSenderAsPlayer(par1ICommandSender);
            EntityPlayerMP executer = getCommandSenderAsPlayer(par1ICommandSender);
            
            executer.displayGUIChest(targetplayer.getInventoryEnderChest());
            
            if(executer == targetplayer){
            	executer.addChatComponentMessage(new ChatComponentText("Looking in your enderchest."));
            } else {
            	executer.addChatComponentMessage(new ChatComponentText("Looking in " + Methods.getUsernameWithS(targetplayer) + " enderchest."));
            }
        } else {
            throw new WrongUsageException("commands.enderchest.usage", new Object[0]);
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
        return par2ArrayOfStr.length == 1 ? getListOfStringsMatchingLastWord(par2ArrayOfStr, this.getListOfPlayerUsernames()) : null;
    }

    /**
     * Returns String array containing all player usernames in the server.
     */
    protected String[] getListOfPlayerUsernames() {
        return MinecraftServer.getServer().getAllUsernames();
    }

    /**
     * Return whether the specified command parameter index is a username parameter.
     */
    public boolean isUsernameIndex(String[] par1ArrayOfStr, int par2) {
        return par2 == 1;
    }
}