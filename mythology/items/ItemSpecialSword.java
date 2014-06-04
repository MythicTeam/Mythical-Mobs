package mythology.items;

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
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpecialSword extends MythItem {
	private float damage;
	private final Item.ToolMaterial toolmaterial;
    private static final String[] SWORD_OVERLAY_NAMES = new String[] {"sword_blood_overlay", "sword_glowing_overlay", "sword_wet_overlay"};
    @SideOnly(Side.CLIENT)
    private IIcon overlayIcon;

	public ItemSpecialSword(String name, String info, ToolMaterial material)
    {
    	super(name, info);
        this.toolmaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.damage = 4.0F + material.getDamageVsEntity();
        this.setTextureName("item_sword");
    }
	
    /**
     * Gets an icon index based on an item's damage value and the given render pass
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int par1, int par2)
    {
        return par2 == 1 ? this.overlayIcon : super.getIconFromDamageForRenderPass(par1, par2);
    }
    
   // @SideOnly(Side.CLIENT)
   // public void registerIcons(IIconRegister par1IconRegister)
   // {
   // 	super(par1IconRegister);
   //     this.overlayIcon = par1IconRegister.registerIcon(MythologyMod.modid + ":" + SWORD_OVERLAY_NAMES[1]);
   // }
	
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		itemstack.stackTagCompound = new NBTTagCompound();
		itemstack.stackTagCompound.setString("MadeBy", player.getDisplayName());
	}


	public float func_150931_i() {
		return this.toolmaterial.getDamageVsEntity();
	}

	public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
		if (p_150893_2_ == Blocks.web) {
			return 15.0F;
		} else {
			Material material = p_150893_2_.getMaterial();
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
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}

	public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_,
			Block p_150894_3_, int p_150894_4_, int p_150894_5_,
			int p_150894_6_, EntityLivingBase p_150894_7_) {
		if ((double) p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_,
				p_150894_5_, p_150894_6_) != 0.0D) {
			p_150894_1_.damageItem(2, p_150894_7_);
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
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.setItemInUse(par1ItemStack,
				this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	public boolean func_150897_b(Block p_150897_1_) {
		return p_150897_1_ == Blocks.web;
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
	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
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