package holiday.block;

import holiday.HolidayMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockBasic extends Block {

	private String texture;
	
	public BlockBasic(int id, Material mat, String s) {
		super(id, mat);
		
		texture = s;
		
		setUnlocalizedName(texture);
		
		setCreativeTab(HolidayMod.tabMisc);
	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon("holiday" + ":" + texture);
	}
}
