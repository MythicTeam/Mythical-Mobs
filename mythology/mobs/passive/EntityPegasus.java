package mythology.mobs.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityPegasus extends EntityAnimal{

	public EntityPegasus(World par1World) {
		super(par1World);
		this.setSize(3.0F, 3.0F);
		setPosition();
	}
	
	public void setPosition() {
		AxisAlignedBB b = this.boundingBox;
		double boxSX = b.maxX - b.minX;
		double boxSY = b.maxY - b.minY;
		double boxSZ = b.maxZ - b.minZ;
		this.boundingBox.setBounds(posX - boxSX/2D, posY, posZ - boxSZ/2D, posX + boxSX/2D, posY + boxSY, posZ + boxSZ/2D);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		
		return new EntityPegasus(worldObj);
	}
	
    protected void applyEntityAttributes(){

        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.00);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4);

    }

    public boolean isAIEnabled(){


        return  true;

    }
}
