package mythology.proxy;

import mythology.MythologyMod;
import mythology.handlers.KeyHandler;
import mythology.init.MythicalBlocks;
import mythology.init.MythicalItems;
import mythology.mobs.hostile.EntityCentaur;
import mythology.mobs.hostile.EntityMinotaur;
import mythology.mobs.hostile.EntityUnderworldSheep;
import mythology.mobs.passive.EntityFairy;
import mythology.mobs.passive.EntityGnome;
import mythology.model.armor.ModelCelestialBronzeArmor;
import mythology.model.hostile.ModelCentaur;
import mythology.model.hostile.ModelMinotaur;
import mythology.model.hostile.ModelUnderworldSheep1;
import mythology.model.hostile.ModelUnderworldSheep2;
import mythology.model.passive.ModelFairy;
import mythology.model.passive.ModelGnome;
import mythology.projectiles.EntityHealingBall;
import mythology.projectiles.RenderHealingBall;
import mythology.rendering.blocks.ItemRenderMagicWorkbench;
import mythology.rendering.hostile.CentaurRender;
import mythology.rendering.hostile.MinotaurRender;
import mythology.rendering.hostile.UnderworldSheepRender;
import mythology.rendering.passive.FairyRender;
import mythology.rendering.passive.GnomeRender;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {

	public KeyHandler keyBindInventory;
	
	public void RenderEntity() {

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock (MythicalBlocks.blockMagicWorkbench), new ItemRenderMagicWorkbench());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCentaur.class,new CentaurRender(new ModelCentaur(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGnome.class,new GnomeRender(new ModelGnome(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMinotaur.class,new MinotaurRender(new ModelMinotaur(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFairy.class,new FairyRender(new ModelFairy(), 0.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityUnderworldSheep.class, new UnderworldSheepRender(new ModelUnderworldSheep1(), new ModelUnderworldSheep2(), 0.4F));
	
		RenderingRegistry.registerEntityRenderingHandler(EntityHealingBall.class, new RenderHealingBall(MythicalItems.heart));
	}

	public static ModelBiped getArmorModel(int i) {

		final ModelCelestialBronzeArmor tutChest = new ModelCelestialBronzeArmor(1.0f);
		final ModelCelestialBronzeArmor tutLegs = new ModelCelestialBronzeArmor(0.5f);

		switch (i) {
		case 0:
			return tutChest;
		case 1:
			return tutLegs;
		default:
			break;
		}
		return tutChest; // default, if whenever you should have passed on a
							// wrong id
	}
}
