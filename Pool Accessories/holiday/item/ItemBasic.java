package holiday.item;

import holiday.Config;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBasic extends Item {
	
	private String texture;
	
	public ItemBasic(int id, CreativeTabs tab, String texName) {
		super(id);
		
		texture = texName;
		
		setCreativeTab(tab);
		
		setUnlocalizedName(texName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon("holiday" + ":" + texture);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if(itemID == Config.coolBag) {
			list.add("Cold...");
		}
	}

}
