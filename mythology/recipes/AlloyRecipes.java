package mythology.recipes;

import mythology.init.MythicalIngot;
import mythology.init.MythicalItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AlloyRecipes {
    public AlloyRecipes() {}
    
    public static ItemStack getSmeltingResult(Item i, Item j) {
        return getOutput(i, j);
    }
    
    private static ItemStack getOutput(Item i, Item j) {
        if (i == Items.coal && j == Items.iron_ingot || i == Items.iron_ingot && j == Items.coal) {
            return new ItemStack(Items.gold_ingot, 1);
        }
        
        if (i == MythicalIngot.itemCopperIngot && j == MythicalIngot.itemTinIngot || i == MythicalIngot.itemTinIngot && j == MythicalIngot.itemCopperIngot) {
            return new ItemStack(MythicalIngot.itemBronzeIngot, 2);
        }
        return null;
    }
}