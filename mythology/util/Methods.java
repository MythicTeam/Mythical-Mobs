package mythology.util;

import net.minecraft.entity.player.EntityPlayer;

public class Methods {
	public static String getUsernameWithS(EntityPlayer player){
		String name = player.getCommandSenderName();
		if(name.endsWith("s")){
			return new String(name + "'");
		}else{
			return new String(name + "'s");
		}
	}
}
