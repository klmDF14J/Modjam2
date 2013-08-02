package holiday.item;

import holiday.HolidayMod;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLolly extends ItemFood {

	private Icon[] icons;
	
	public ItemLolly(int id) {
		super(id, 4, true);
		
		setCreativeTab(HolidayMod.tabFood);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return Items.lollyNames[stack.getItemDamage()] + "Lolly";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[Items.lollyNames.length];
		
		for(int i = 0; i < icons.length; i++) {
			icons[i] = register.registerIcon("holiday" + ":" + Items.lollyNames[i] + "Lolly");
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
		for(int i = 0; i < Items.lollyNames.length; i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}

}
