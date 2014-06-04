package mythology.handlers;

import mythology.MythologyMod;
import mythology.containers.ContainerAlloyFurnace;
import mythology.gui.GuiAlloyFurnace;
import mythology.swervy.common.Resources;
import mythology.swervy.gui.guiHelp;
import mythology.tileentities.TileEntityAlloyFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
				case MythologyMod.guiAlloyFurnace:
						return new ContainerAlloyFurnace(player.inventory, (TileEntityAlloyFurnace) entity);
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		switch(ID){
		case MythologyMod.guiAlloyFurnace:
				return new GuiAlloyFurnace(player.inventory, (TileEntityAlloyFurnace) entity);
		case 3:
			return new guiHelp(player);
	}
		return null;
	}

}
