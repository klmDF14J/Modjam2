package holiday.item;

import holiday.HolidayMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFishAndChips extends ItemFood {
	
	public ItemFishAndChips(int id) {
		super(id, 8, false);
		
		setCreativeTab(HolidayMod.tabFood);
		
		setUnlocalizedName("FishAndChips");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon("holiday" + ":" + "FishAndChips");
	}

}
