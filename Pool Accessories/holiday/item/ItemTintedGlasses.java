package holiday.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import holiday.HolidayMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class ItemTintedGlasses extends ItemArmor {

	private Icon[] icons;
	
	public ItemTintedGlasses(int id) {
		super(id, EnumArmorMaterial.IRON, 2, 0);
		
		setCreativeTab(HolidayMod.tabClothes);
		setHasSubtypes(true);
		setMaxDamage(4);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return Items.glassesColours[stack.getItemDamage()] + "TintedGlasses";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[Items.glassesColours.length];
		
		for(int i = 0; i < icons.length; i++) {
			icons[i] = register.registerIcon("holiday" + ":" + Items.glassesColours[i] + "TintedGlasses");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		return icons[dmg];
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return "holiday" + ":" + "/textures/armour/" + Items.glassesColours[stack.getItemDamage()] + "TintedGlasses.png"; 
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for(int i = 0; i < Items.glassesColours.length; i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}
	
	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack) {
		
	}

}
