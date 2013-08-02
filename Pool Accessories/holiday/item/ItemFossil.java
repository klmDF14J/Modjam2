package holiday.item;

import holiday.HolidayMod;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFossil extends Item {

	private Icon[] icons;
	private String[] types = {"Spiral", "Splat", "Rod", "Arc", "Donut", "Flat", "Slice", "Tooth"};
	
	public ItemFossil(int id) {
		super(id);
		
		setCreativeTab(HolidayMod.tabFossils);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "Fossil_" + stack.getItemDamage();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[Items.fossils];
		
		for(int i = 0; i < icons.length; i++) {
			icons[i] = register.registerIcon("holiday" + ":" + "Fossil_" + i);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		return icons[dmg];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for(int i = 0; i < Items.fossils; i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(types[stack.getItemDamage()]);
	}

}
