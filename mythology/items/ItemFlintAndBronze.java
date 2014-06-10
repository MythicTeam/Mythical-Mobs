package mythology.items;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.MythologyMod;
import mythology.init.MythicalBlocks;
import mythology.init.MythicalItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFlintAndBronze extends Item {

	Random rand = new Random();

	public ItemFlintAndBronze(String string) {
		GameRegistry.registerItem(this, string);
		MythologyMod m = new MythologyMod();

		this.maxStackSize = 1;
		this.setMaxDamage(100);
		this.setCreativeTab(m.tabMythicalUnderworld);
		this.setTextureName(m.modid + ":" + "underworld/" + "FlintAndBronze");
		this.setUnlocalizedName(string);
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (par7 == 0) {
			--par5;
		}

		if (par7 == 1) {
			++par5;
		}

		if (par7 == 2) {
			--par6;
		}

		if (par7 == 3) {
			++par6;
		}

		if (par7 == 4) {
			--par4;
		}

		if (par7 == 5) {
			++par4;
		}

		if (!player.canPlayerEdit(par4, par5, par6, par7,
				itemstack)) {
			return false;
		} else {
			if (world.isAirBlock(par4, par5, par6)) {
				world.playSoundEffect((double) par4 + 0.5D, (double) par5 + 0.5D, (double) par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
				world.setBlock(par4, par5, par6, MythicalBlocks.blockBlueFire);
			}

			itemstack.damageItem(1, player);
			return true;
		}
	}
}
