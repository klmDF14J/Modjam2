package holiday;

import holiday.item.Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HolidayTab extends CreativeTabs {

	private String name; 
	private int index;
	private int[] ids = {8000, 8005, 8004};
	
	public HolidayTab(String s, int id) {
		super(getNextID(), s);
		
		name = s;
		index = id;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return ids[index];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel() {
		return name;
	}

}
