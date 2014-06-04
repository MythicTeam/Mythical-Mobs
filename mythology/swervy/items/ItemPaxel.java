package mythology.swervy.items;

import java.util.List;
import java.util.Set;

import mythology.MythologyMod;
import mythology.init.MythicalTools;
import mythology.swervy.common.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPaxel extends ItemTool {
	
	private static final Set field_150915_c = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium, Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});
    private static final String __OBFID = "CL_00000053";
    
    Resources r = new Resources();
    
    public ItemPaxel(String name, ToolMaterial toolmaterial) {
        super(2.0F, toolmaterial, field_150915_c);
        this.maxStackSize = 1;
        setCreativeTab(MythologyMod.tabMythical);
		setTextureName(MythologyMod.modid + ":" + name);
		setUnlocalizedName(name);
		this.setMaxDamage(toolmaterial.getMaxUses());
		this.canRepair = true;
		GameRegistry.registerItem(this, name);
		
		if (name == "paxelBronze"){
			this.setMaxDamage(175);
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this, 1), new Object[] { "psa", " x ", " x ", 'p', MythicalTools.pickaxeBronze, 's', MythicalTools.shovelBronze, 'a', MythicalTools.axeBronze, 'x', Items.stick}));
		} else if(name == "paxelCelestialBronze") {
			this.setMaxDamage(200);
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this, 1), new Object[] { "psa", " x ", " x ", 'p', MythicalTools.pickaxeCelestialBronze, 's', MythicalTools.shovelCelestialBronze, 'a', MythicalTools.axeCelestialBronze, 'x', Items.stick}));
		} else if(name == "paxelImperialGold") {
			this.setMaxDamage(225);
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this, 1), new Object[] { "psa", " x ", " x ", 'p', MythicalTools.pickaxeImperialGold, 's', MythicalTools.shovelImperialGold, 'a', MythicalTools.axeImperialGold, 'x', Items.stick}));
		} else if(name == "paxelSilver") {
			this.setMaxDamage(160);
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this, 1), new Object[] { "psa", " x ", " x ", 'p', MythicalTools.pickaxeSilver, 's', MythicalTools.shovelSilver, 'a', MythicalTools.axeSilver, 'x', Items.stick}));
		} else if(name == "paxelRuby") {
			this.setMaxDamage(150);
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this, 1), new Object[] { "psa", " x ", " x ", 'p', MythicalTools.pickaxeRuby, 's', MythicalTools.shovelRuby, 'a', MythicalTools.axeRuby, 'x', Items.stick}));
		} else if(name == "paxelSapphire") {
			this.setMaxDamage(150);
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this, 1), new Object[] { "psa", " x ", " x ", 'p', MythicalTools.pickaxeSapphire, 's', MythicalTools.shovelSapphire, 'a', MythicalTools.axeSapphire, 'x', Items.stick}));
		}
    }

    public boolean func_150897_b(Block block) {
        return  Blocks.snow_layer != null ? true : block == Blocks.snow || block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (block != Blocks.diamond_block && block != Blocks.diamond_ore ? (block != Blocks.emerald_ore && block != Blocks.emerald_block ? (block != Blocks.gold_block && block != Blocks.gold_ore ? (block != Blocks.iron_block && block != Blocks.iron_ore ? (block != Blocks.lapis_block && block != Blocks.lapis_ore ? (block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore ? (block.getMaterial() == Material.rock ? true : (block.getMaterial() == Material.iron ? true : block.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }

    public float func_150893_a(ItemStack itemstack, Block block) {
        return block.getMaterial() != Material.iron && block.getMaterial() != Material.anvil && block.getMaterial() != Material.rock ? super.func_150893_a(itemstack, block) : this.efficiencyOnProperMaterial;
    }
    
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack ItemStack, EntityPlayer EntityPlayer, World World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        if (!EntityPlayer.canPlayerEdit(par4, par5, par6, par7, ItemStack)) {
            return false;
        } else {
            UseHoeEvent event = new UseHoeEvent(EntityPlayer, ItemStack, World, par4, par5, par6);
            if (MinecraftForge.EVENT_BUS.post(event)) {
                return false;
            }

            if (event.getResult() == Result.ALLOW) {
            	ItemStack.damageItem(1, EntityPlayer);
                return true;
            }

            Block block = World.getBlock(par4, par5, par6);

            if (par7 != 0 && World.getBlock(par4, par5 + 1, par6).isAir(World, par4, par5 + 1, par6) && (block == Blocks.grass || block == Blocks.dirt)) {
                Block block1 = Blocks.farmland;
                World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (World.isRemote) {
                    return true;
                } else {
                    ItemStack.damageItem(1, EntityPlayer);
                    return true;
                }
            }else {
                return false;
            }
        }
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add(EnumChatFormatting.DARK_RED + "HP: " + EnumChatFormatting.WHITE + (itemStack.getMaxDamage() - itemStack.getItemDamage()));
	}
    
    public boolean hitEntity(ItemStack ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
    	ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    /**
     * Returns the name of the material this tool is made from as it is declared in Item.ToolMaterial (meaning diamond
     * would return "EMERALD")
     */
    public String getToolMaterialName() {
        return this.toolMaterial.toString();
    }
}
