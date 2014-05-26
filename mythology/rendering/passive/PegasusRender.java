package mythology.rendering.passive;

import mythology.mobs.passive.EntityGnome;
import mythology.mobs.passive.EntityPegasus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



@SideOnly(Side.CLIENT)
public class PegasusRender extends RenderLiving 
{
	public static float scale = 1.5F;

	private static final ResourceLocation cowTextures = new ResourceLocation("mythical:textures/entity/Pegasus.png");
    private static final String __OBFID = "CL_00000984";

    public PegasusRender(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityPegasus par1EntityPegasus)
    {
        return cowTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEntityTexture((EntityPegasus)par1Entity);
    }

}
