package mythology.projectiles;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityHealingBall extends EntityThrowable
{
	float healAmount;
	
    public EntityHealingBall(World world)
    {
        super(world);
    }

    public EntityHealingBall(World world, EntityLivingBase entity, float heal)
    {
        super(world, entity);
        healAmount = heal;
    }

    public EntityHealingBall(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null && par1MovingObjectPosition.entityHit instanceof EntityLiving)
        {   
            ((EntityLiving)par1MovingObjectPosition.entityHit).heal(healAmount);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}