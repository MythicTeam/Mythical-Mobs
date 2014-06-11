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
		this.worldChunkMgr = new WorldChunkManagerHell(
				MythicalBiomes.BiomeUnderworld, 0F);
		this.dimensionId = MythicalRegistration.underworld;
		this.hasNoSky = true;
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

	@SideOnly(Side.CLIENT)
	public double getVoidFogYFactor() {
		return this.terrainType.voidFadeMagnitude();
	}

	/*@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float par1, float par2) {
		float var3 = MathHelper.cos(par1 * (float) Math.PI * 2.0F) * 2.0F + 0.5F;
		if (var3 < 0.0F) {
			var3 = 0.0F;
		}
		if (var3 > 1.0F) {
			var3 = 1.0F;
		}
		float var4 = 0.7529412F;
		float var5 = 0.84705883F;
		float var6 = 1.0F;
		var4 *= var3 * 3.94F + 0.06F;
		var5 *= var3 * 0.94F + 0.06F;
		var6 *= var3 * 0.91F + 0.09F;
		return Vec3.getVec3Pool().getVecFromPool((double) var4, (double) var5, (double) var6);
	}*/
}
