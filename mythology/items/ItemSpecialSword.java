package mythology.items;

import java.util.List;

import mythology.MythologyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpecialSword extends MythItem {
	private float damage;
	private final Item.ToolMaterial toolmaterial;


	public ItemSpecialSword(String name, String info, ToolMaterial material)
    {
    	super(name, info);
        this.toolmaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.damage = 4.0F + material.getDamageVsEntity();
        this.setTextureName("iron_sword");
    }

	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		String playername = player.getDisplayName();
		itemstack.setStackDisplayName("Special Sword");
		if (itemstack.stackTagCompound != null) {
			itemstack.stackTagCompound = new NBTTagCompound();
		}
		itemstack.stackTagCompound.setString("MadeBy", player.getDisplayName());
		if(player.getDisplayName().endsWith("s")){
			itemstack.setStackDisplayName(player.getDisplayName() + "' " + itemstack.getDisplayName());
		}
		else{
			itemstack.setStackDisplayName(player.getDisplayName() + "'s " + itemstack.getDisplayName());
		}
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {
    	list.add(info);
    	if (itemstack.stackTagCompound != null) {
    		list.add(EnumChatFormatting.GOLD + "Forged by " + itemstack.stackTagCompound.getString("MadeBy"));
    	}
    }

	public float func_150931_i() {
		return this.toolmaterial.getDamageVsEntity();
	}

	public float func_150893_a(ItemStack itemstack, Block block) {
		if (block == Blocks.web) {
			return 15.0F;
		} else {
			Material material = block.getMaterial();
			return material != Material.plants && material != Material.vine
					&& material != Material.coral
					&& material != Material.leaves
					&& material != Material.gourd ? 1.0F : 1.5F;
		}
	}

	/**
	 * Current implementations of this method in child classes do not use the
	 * entry argument beside ev. They just raise the damage on the stack.
	 */
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

	/**
	 * Returns True is the item is renderer in full 3D when hold.
	 */
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	/**
	 * returns the action that specifies what animation to play when the items
	 * is being used
	 */
	public EnumAction getItemUseAction(ItemStack itemstack) {
		return EnumAction.block;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack itemstack) {
		return 72000;
	}

	public boolean func_150897_b(Block block) {
		return block == Blocks.web;
	}

	/**
	 * Return the enchantability factor of the item, most of the time is based
	 * on material.
	 */
	public int getItemEnchantability() {
		return this.toolmaterial.getEnchantability();
	}

	/**
	 * Return the name for this tool's material.
	 */
	public String getToolMaterialName() {
		return this.toolmaterial.toString();
	}

	/**
	 * Return whether this item is repairable in an anvil.
	 */
	public boolean getIsRepairable(ItemStack par1ItemStack,	ItemStack par2ItemStack) {
		return this.toolmaterial.func_150995_f() == par2ItemStack.getItem() ? true
				: super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	/**
	 * Gets a map of item attribute modifiers, used by ItemSword to increase hit
	 * damage.
	 */
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage
				.getAttributeUnlocalizedName(), new AttributeModifier(
				field_111210_e, "Weapon modifier", (double) this.damage, 0));
		return multimap;
	}
}