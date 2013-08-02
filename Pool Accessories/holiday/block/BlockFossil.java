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
import net.minecraft.entity.player.EntityPlayer;
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
	
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		for(int i = 0; i < 10; i++) {
			world.spawnParticle("reddust", x + world.rand.nextFloat(), y + 0.5 + world.rand.nextFloat(), z + world.rand.nextFloat(), 255, 255, 0);
		}
	}

}
