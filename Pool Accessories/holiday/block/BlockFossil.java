package holiday.block;

import holiday.HolidayMod;
import holiday.item.Items;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockFossil extends Block {

	public BlockFossil(int id) {
		super(id, Material.rock);
		
		setCreativeTab(HolidayMod.tabFossils);
		
		setUnlocalizedName("Fossil");
		
		setHardness(3F);
		setResistance(1F);
		setBlockUnbreakable();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon("holiday" + ":" + "FossilRock");
	}

}
