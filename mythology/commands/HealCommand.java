package mythology.commands;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.WorldSettings;

public class HealCommand extends CommandBase {
    public String getCommandName() {
        return "heal";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel() {
        return 2;
    }

    public String getCommandUsage(ICommandSender par1ICommandSender) {
        return "commands.heal.usage";
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
        if (par2ArrayOfStr.length < 2) {
            EntityPlayerMP healedplayer = par2ArrayOfStr.length > 2 ? getPlayer(par1ICommandSender, par2ArrayOfStr[1]) : getCommandSenderAsPlayer(par1ICommandSender);
            healedplayer.heal(healedplayer.getMaxHealth()-healedplayer.getHealth());;
            healedplayer.getFoodStats().setFoodLevel(20);
            healedplayer.fallDistance = 0.0F;
            healedplayer.extinguish();
            EntityPlayerMP healer = getCommandSenderAsPlayer(par1ICommandSender);
            if(healer == healedplayer){
            	healedplayer.addChatComponentMessage(new ChatComponentText("You have been healed by yourself."));
            } else {
            	healedplayer.addChatComponentMessage(new ChatComponentText("You have been healed by " + healer.getDisplayName() + "."));
            }
        } else {
            throw new WrongUsageException("commands.heal.usage", new Object[0]);
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