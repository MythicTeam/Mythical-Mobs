package mythology.swervy.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class MagicTableRecipeSorter implements Comparator {

	final MagicTableCraftingManager MagicTable;
	
	public MagicTableRecipeSorter(MagicTableCraftingManager MagicTableCraftingManager) {
		this.MagicTable = MagicTableCraftingManager;
	}
	
	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof MagicTableShapelessRecipes && irecipe2 instanceof MagicTableShapedRecipes ? 1: (irecipe2 instanceof MagicTableShapelessRecipes && irecipe1 instanceof MagicTableShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}
