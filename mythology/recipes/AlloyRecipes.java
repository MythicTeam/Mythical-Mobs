package mythology.recipes;

import mythology.init.MythicalIngot;
import mythology.init.MythicalItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AlloyRecipes {

    public static ItemStack getSmeltingResult(Item i, Item j) {
        return getOutput(i, j);
    }
    
    public static ItemStack getOutput(Item input, Item input1) {
    	
       if (input == MythicalIngot.itemCopperIngot && input1 == MythicalIngot.itemTinIngot || input == MythicalIngot.itemTinIngot && input1 == MythicalIngot.itemCopperIngot) {
            return new ItemStack(MythicalIngot.itemBronzeIngot, 2);
        }
        
        return null;
    }
}