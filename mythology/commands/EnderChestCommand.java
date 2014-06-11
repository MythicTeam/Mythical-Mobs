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
		List list = new ArrayList<String>();
		list.add("ec");
		list.add("endchest");
		return list;
	}

    public void processCommand(ICommandSender par1ICommandSender, String[] stringArray) {
        EntityPlayerMP sender = getCommandSenderAsPlayer(par1ICommandSender);
        if (stringArray.length == 0)
        {
        	openEnderchest(sender, sender);
        }
        else if (stringArray.length <= 1)
        {
        	if (stringArray[0].toLowerCase().equals("me")){
        		openEnderchest(sender, sender);
            } else {
            	EntityPlayerMP target = getPlayer(par1ICommandSender, stringArray[0]);
            	openEnderchest(sender, target);
            }
        }
        else throw new WrongUsageException("commands.heal.usage", new Object[0]);
    }

    private void openEnderchest(EntityPlayerMP sender, EntityPlayerMP target) {
    	if (sender == target){
    		sender.addChatComponentMessage(new ChatComponentText("Opening your chest."));
    	} else {
    		sender.addChatComponentMessage(new ChatComponentText("Opening " + Methods.getUsernameWithS(target) + " chest."));
    	}
    	sender.displayGUIChest(target.getInventoryEnderChest());;
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