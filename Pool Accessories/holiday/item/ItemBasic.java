package holiday.item;

import holiday.Config;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBasic extends Item {
	
	private String texture;
	
	@SideOnly(Side.CLIENT)
	public Icon beachball;
	
	public ItemBasic(int id, CreativeTabs tab, String texName, boolean sub, int dmg, int stack) {
		super(id);
		
		texture = texName;
		
		setCreativeTab(tab);
		
		setHasSubtypes(sub);
		
		setMaxDamage(dmg);
		
		setMaxStackSize(stack);
		
		setUnlocalizedName(texName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon("holiday" + ":" + texture);
		beachball = register.registerIcon("holiday" + ":" + texture);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if(stack.itemID == Config.coolBag) {
			list.add("Cold...");
		}
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		
		return true;
	}

}
