package mythology.items;

import java.util.List;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mythology.projectiles.EntityHealingBall;
import mythology.util.Methods;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class StaffHealing extends MythItem{
	private float damage;
	private final Item.ToolMaterial toolmaterial;
	
	public StaffHealing(String name, String lore) {
		super(name, lore);
		ToolMaterial material = ToolMaterial.WOOD;
        this.toolmaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(384);//Same as bow
        this.damage = 4.0F;
	}
	
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		String playername = player.getDisplayName();
		itemstack.setStackDisplayName("Healing Staff");
		if (itemstack.stackTagCompound != null) {
			itemstack.stackTagCompound = new NBTTagCompound();
		}
		itemstack.stackTagCompound.setString("MadeBy", player.getDisplayName());
		itemstack.setStackDisplayName(Methods.getUsernameWithS(player) + itemstack.getDisplayName());
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {
    	list.add(info);
    	if (itemstack.stackTagCompound != null) {
    		list.add(EnumChatFormatting.GOLD + "Made by " + itemstack.stackTagCompound.getString("MadeBy"));
    	}
    }
	
    public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityPlayer player, int useDuration)
    {
        int j = this.getMaxItemUseDuration(itemstack) - useDuration;
        float f = (float)j / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if(f>12.0F){//Sets max heal amount
        	f = 12.0F;
        }
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote)
        {
        	world.spawnEntityInWorld(new EntityHealingBall(world, player, f));
        }
    }
	
    public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player)
    {
        return itemstack;
    }
	
    public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 72000;
    }
	
	public float func_150931_i() {
		return this.toolmaterial.getDamageVsEntity();
	}
	
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase hitted, EntityLivingBase hitter) {
		itemstack.damageItem(1, hitter);
		return true;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world,	EntityPlayer player) {
		player.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		return itemstack;
	}
	
	public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		if ((double) block.getBlockHardness(world, x, y, z) != 0.0D) {
			itemstack.damageItem(2, entity);
		}
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}
	
	public EnumAction getItemUseAction(ItemStack itemstack) {
		return EnumAction.bow;
	}
	
	public int getItemEnchantability() {
		return this.toolmaterial.getEnchantability();
	}
	
	public String getToolMaterialName() {
		return this.toolmaterial.toString();
	}
	
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage
				.getAttributeUnlocalizedName(), new AttributeModifier(
				field_111210_e, "Weapon modifier", (double) this.damage, 0));
		return multimap;
	}
}
