package mythology.swervy.dimension;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mythology.init.MythicalBiomes;
import mythology.init.MythicalRegistration;
import mythology.swervy.common.Registration;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderUnderworld extends WorldProvider {

	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(MythicalBiomes.BiomeUnderworld, 0F);
		this.dimensionId = Registration.underworld;
		this.hasNoSky = false;
		this.isHellWorld = false;
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunckProviderUnderworld(this.worldObj, this.getSeed(), false);
	}
	
	@Override
	public String getDimensionName() {
		return "Underworld";
	}
	
	@Override
	public String getWelcomeMessage() {
		return "Welcome to the Underworld";
	}
	
	public boolean canCoordinateBeSpawn(int par1, int par2) {
		return false;
	}
	
	@Override
	public boolean canRespawnHere() {
		return true;
	}
	
	public boolean renderVoidFog() {
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isSkyColored() {
		return false;
	}

	public boolean isSurfaceWorld() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public float getCloudHeight() {
		return -256.0F;
	}

	public double getVoidFogYFactor() {
	         return this.terrainType.voidFadeMagnitude();
	         
	}
}
