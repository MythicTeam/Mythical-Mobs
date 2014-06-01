package mythology.items;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWarhammer extends MythItem
{
    private float damage;
    private final Item.ToolMaterial toolmaterial;
    
    public ItemWarhammer(Item.ToolMaterial material, String name, String lore)
    {
    	super(name, lore);
        this.toolmaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.damage = 3.0F + material.getDamageVsEntity();
    }

    public float func_150931_i()
    {
        return this.toolmaterial.getDamageVsEntity();
    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
    	Material material = p_150893_2_.getMaterial();
    	return material != Material.rock && material != Material.iron && material != Material.piston && material != Material.packedIce && material != Material.ice ? 1.0F : 1.5F;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase hitted, EntityLivingBase hitter)
    {
        par1ItemStack.damageItem(1, hitter);
        if(hitted instanceof EntitySpider || hitted instanceof EntitySkeleton || hitted instanceof EntityEnderman){
        	hitted.heal(-2F);
        }
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int x, int y, int z, EntityLivingBase entity)
    {
        if ((double)block.getBlockHardness(world, x, y, z) != 0.0D)
        {
        	itemstack.damageItem(1, entity);
        }

        return true;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }


    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolmaterial.getEnchantability();
    }

    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName()
    {
        return this.toolmaterial.toString();
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.toolmaterial.func_150995_f() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.damage, 0));
        return multimap;
    }
}