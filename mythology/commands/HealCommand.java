package mythology.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class HealCommand extends CommandBase
{
    public String getCommandName()
    {
        return "heal";
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
		list.add("h");
		return list;
	}

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return "commands.heal.usage";
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] stringArray)
    {
        EntityPlayerMP sender = getCommandSenderAsPlayer(par1ICommandSender);
        if (stringArray.length == 0)
        {
        	healPlayer(sender, sender);
        }
        else if (stringArray.length <= 1)
        {
        	if (stringArray[0].toLowerCase().equals("me")){
            	healPlayer(sender, sender);
            } else {
            	EntityPlayerMP target = getPlayer(par1ICommandSender, stringArray[0]);
            	healPlayer(sender, target);
            }
        }
        else throw new WrongUsageException("commands.heal.usage", new Object[0]);
    }
    
    private void healPlayer(EntityPlayerMP healer, EntityPlayerMP healed){
    	if (healer == healed){
    		healer.addChatComponentMessage(new ChatComponentText("You healed yourself."));
    	} else {
    		healer.addChatComponentMessage(new ChatComponentText("You healed " + healed.getCommandSenderName() + "."));
    		healed.addChatComponentMessage(new ChatComponentText("You have been healed by " + healer.getCommandSenderName() + "."));
    	}
    	healed.heal(Float.MAX_VALUE);
    	healed.extinguish();
    	healed.getFoodStats().setFoodLevel(20);
    	healed.fallDistance = 0.0F;
    	healed.setAir(20);
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] stringArray)
    {
        return stringArray.length == 1 ? getListOfStringsMatchingLastWord(stringArray, this.getAllUsernames()) : null;
    }

    protected String[] getAllUsernames()
    {
        return MinecraftServer.getServer().getAllUsernames();
    }

    /**
     * Return whether the specified command parameter index is a username parameter.
     */
    public boolean isUsernameIndex(String[] par1ArrayOfStr, int par2)
    {
        return par2 == 1;
    }
}