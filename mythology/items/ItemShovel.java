package mythology.items;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumChatFormatting;

public class ItemShovel extends ItemTool {
	
    private static final Set hashSet = Sets.newHashSet(new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});
    private static final String string = "CL_00000063";

    public ItemShovel(Item.ToolMaterial tm, String name) {
        super(1.0F, tm, hashSet);
		GameRegistry.registerItem(this, name);

    }

    public boolean func_150897_b(Block b) {
        return b == Blocks.snow_layer ? true : b == Blocks.snow;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add(EnumChatFormatting.DARK_RED + "HP: " + EnumChatFormatting.WHITE + (itemStack.getMaxDamage() - itemStack.getItemDamage()));
	}
}