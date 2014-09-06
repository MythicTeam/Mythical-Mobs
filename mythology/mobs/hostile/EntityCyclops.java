package mythology.mobs.hostile;

import mythology.MythologyMod;
import mythology.init.MythicalItems;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPlay;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCyclops extends EntityMob{

	public EntityCyclops(World world) {
		super(world);
		
		//AI
		this.getNavigator().setBreakDoors(true);
		this.isImmuneToFire = true;
		
		this.tasks.addTask(0, new EntityAISwimming(this));				
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(2, new EntityAIMoveIndoors(this));
	    this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
	    this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
	    this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        
        
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
             
        
        
        
        
               
			}
	
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return MythologyMod.modid + ":" + "cyclops.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return MythologyMod.modid + ":" + "cyclops.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return MythologyMod.modid + ":" + "cyclops.death";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.zombie.step", 0.15F, 1.0F);
    }
    
    protected Item getDropItem()
    {
        return MythicalItems.CyclopsHeart; 
    }
    
    /*protected void dropRareDrop(int par1)
    {
        switch (this.rand.nextInt(3))
        {
            case 0:
                this.dropItem(Item1, 1);
                break;
            case 1:
                this.dropItem(Item2, 1);
                break;
            case 2:
                this.dropItem(Item3, 1);
        }
    } */
    
    protected void dropFewItems(boolean par1, int par2) {
        int j;
        int k;
       
        
        {
            j = this.rand.nextInt(3 + par2);

            for (k = 0; k < j; ++k)
            {
                this.dropItem(Items.apple, 1);
            }
        }

        j = this.rand.nextInt(3 + par2);

    }
    

	
	
	
	
	
		protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35000000727464535D);
	        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(120.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(10.00D);
	        
	}
		
		 protected boolean isAIEnabled()
		    {
		        return true;
		    }

}
