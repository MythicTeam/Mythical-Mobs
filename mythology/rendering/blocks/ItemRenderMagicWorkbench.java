package mythology.rendering.blocks;

import mythology.model.blocks.MagicWorkbench;
import mythology.tileentities.TileEntityMagicTable;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderMagicWorkbench implements IItemRenderer {

	private MagicWorkbench model;
	
	public ItemRenderMagicWorkbench() {
		model = new MagicWorkbench();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityMagicTable(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}
