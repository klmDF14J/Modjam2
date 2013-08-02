package holiday.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import holiday.HolidayMod;
import holiday.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class ItemChisel extends Item {

	public ItemChisel(int id) {
		super(id);
		
		setMaxDamage(100);
		setMaxStackSize(1);
		
		setCreativeTab(HolidayMod.tabFossils);
		
		setUnlocalizedName("Chisel");
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote && world.getBlockId(x, y, z) == Blocks.fossil.blockID) {
			EntityItem fossil = new EntityItem(world, x + world.rand.nextFloat(), y + world.rand.nextFloat(), z + world.rand.nextFloat(), new ItemStack(Items.fossil, 1, world.rand.nextInt(Items.fossils)));
			fossil.motionX = (-0.5F + world.rand.nextFloat()) * 0.05F;
			fossil.motionY = (4 + world.rand.nextFloat()) * 0.05F;
			fossil.motionZ = (-0.5F + world.rand.nextFloat()) * 0.05F;
			world.spawnEntityInWorld(fossil);
			world.setBlockToAir(x, y, z);
			stack.damageItem(1, player);
		}
		return true; 
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("Use it to carve into fossil encrusted stones");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon("holiday" + ":" + "Chisel");
	}

}
