package mythology.dimension.underworld;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.plains, 0F);
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
	public boolean canRespawnHere() {
		return true;
	}
	
	public boolean renderVoidFog() {
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isSkyColored() {
		return true;
	}

	public boolean isSurfaceWorld() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public float getCloudHeight() {
		return 128.0F;
	}

	public double getVoidFogYFactor() {
	         return this.terrainType.voidFadeMagnitude();
	         
	}
	
	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float par1, float par2) {
		int i = 10890654;
		float f2 = MathHelper.cos(par1 * 3.141593F * 2.0F) * 2.0F + 0.5F;
		
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		
		float f3 = (i >> 16 & 0xFF) / 255.0F;
		float f4 = (i >> 8 & 0xFF) / 255.0F;
		float f5 = (i & 0xFF) / 255.0F;
		
		f3 *= (f2 * 0.0F + 0.15F);
		f4 *= (f2 * 0.0F + 0.15F);
		f5 *= (f2 * 0.0F + 0.15F);
		
		return this.worldObj.getWorldVec3Pool().getVecFromPool(f3, f4, f5);
	}


}
