package holiday.block;

import holiday.HolidayMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockWeed extends BlockFlower {

	public BlockWeed(int par1) {
		super(par1);
		
		setCreativeTab(HolidayMod.tabMisc);
		
		setUnlocalizedName("Weed");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon("holiday" + ":" + "Weed");
	}

}
