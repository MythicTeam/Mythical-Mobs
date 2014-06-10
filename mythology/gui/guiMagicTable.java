package mythology.gui;

import org.lwjgl.opengl.GL11;

import mythology.MythologyMod;
import mythology.containers.ContainerMagicTable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class guiMagicTable extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(MythologyMod.modid + ":" + "textures/gui/MagicTable.png");
	
	public guiMagicTable(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		super(new ContainerMagicTable(invPlayer, world, x, y, z));
		
		this.xSize = 176;
		this.ySize = 188;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Magic Crafting"), 55, -10, 0xFFFFFF);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop - 16, 0, 0, xSize, ySize);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
        return false;
    }
	
	@Override
	public void onGuiClosed() {
		if (this.mc.thePlayer != null) {
            this.inventorySlots.onContainerClosed(this.mc.thePlayer);
        }
	}
}
