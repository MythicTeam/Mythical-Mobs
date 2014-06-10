package mythology.dimension;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mythology.init.MythicalBiomes;
import mythology.init.MythicalRegistration;
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
		this.dimensionId = MythicalRegistration.underworld;
		this.hasNoSky = true;
		this.isHellWorld = false;
		this.getFogColor(0, 0);
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
	
	@Override
	public int getMoonPhase(long par1) {
        return (int) (par1 * 0L);
    }
	
	public boolean canCoordinateBeSpawn(int par1, int par2) {
		return false;
	}
	
	@Override
	public boolean getWorldHasVoidParticles() {
		 return this.terrainType.hasVoidParticles(this.hasNoSky);
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
		return false;
	}

	@SideOnly(Side.CLIENT)
	public float getCloudHeight() {
		return -256.0F;
	}

	public double getVoidFogYFactor() {
	         return this.terrainType.voidFadeMagnitude();
	         
	}
}
