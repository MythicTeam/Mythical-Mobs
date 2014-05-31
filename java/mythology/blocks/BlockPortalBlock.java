package mythology.blocks;

import mythology.MythologyMod;
import mythology.dimension.underworld.TelporterUnderworld;
import mythology.init.MythicalBlocks;
import mythology.init.MythicalRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class BlockPortalBlock extends BlockPortal {

	public BlockPortalBlock(String string, Material portal) {
		this.setCreativeTab(MythologyMod.tabMythical);
		this.setBlockTextureName(MythologyMod.modid + ":" + "underworldPortal");
	}

	public void onEntityCollidedWithBlock(World X, int p_149670_2_, int Y, int Z, Entity entity) {
        if(entity.ridingEntity == null && entity.riddenByEntity == null && entity instanceof EntityPlayerMP) {
        	EntityPlayerMP player = (EntityPlayerMP) entity;
        	MinecraftServer server = MinecraftServer.getServer();
        	
        	if(player.timeUntilPortal > 0) {
        		player.timeUntilPortal = 10;
        	} else if(player.dimension != 1) {
        		player.timeUntilPortal = 10;
        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, MythicalRegistration.underworld, new TelporterUnderworld(server.worldServerForDimension(MythicalRegistration.underworld)));       		
        	} else {
        		player.timeUntilPortal = 10;
        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TelporterUnderworld(server.worldServerForDimension(0)));
        	}
        }
    }
	
	public boolean tryToCreatePoral(World world, int x, int y, int z) {
		byte b = 0;
		byte b1 = 0;
		
		if(world.getBlock(x-1, y, z) == Blocks.soul_sand || 
				world.getBlock(x+1, y, z) == Blocks.soul_sand) {
			
		} 
		
		if(world.getBlock(x, y, z-1) == Blocks.soul_sand || 
				world.getBlock(x, y, z+1) == Blocks.soul_sand) {
			
		}
		
		if(b == b1) {
			return false;
		} else {
			if(world.isAirBlock(x-b, y, z-b1)) {
				x-=b;
				z-=z;
			}
			
			for(int i = -1; i <= 2; i++) {
				for(int j = -1; j <= 3; j++) {
					boolean flag = (i == -i || i == 2 || j == -1 || j == 3);
					
					if (i != -1 && i != 2 || j != -1 || j != 3) {
						Block k = world.getBlock(x + (b * i), y + j, z + b1 * i);
						Boolean isAirBlock = world.isAirBlock(x + b * i, y + j, z + b1 * i);
						
								
						if(flag) {
							if( k != Blocks.soul_sand) {
								return false;
							}
						} else if(!isAirBlock && k != Blocks.fire) {
							return false;
						}
					}
				}
			}
				
				for(int l = 0; l < 2; l++) {
					for(int l2 = 0; l2 < 3; l2++) {
						world.setBlock(x + b * l, y + l2, z + b1 * l, MythicalBlocks.blockPortial, 0, 2);
					}
				}
			}
		return true;
    }
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		
    }
}
