package holiday.item;

import holiday.HolidayMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSnorkel extends ItemArmor {
	
	public ItemSnorkel(int id) {
		super(id, EnumArmorMaterial.IRON, 2, 0);
		
		setCreativeTab(HolidayMod.tabMisc);
		
		setUnlocalizedName("Snorkel");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon("holiday" + ":" + "Snorkel");
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return "holiday" + ":" + "textures/armour/Snorkel.png";
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
		super.onUpdate(stack, world, entity, par4, par5);
	}
	
	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack) {
		super.onArmorTickUpdate(world, player, itemStack);
		int id = world.getBlockId((int)player.posX, (int)player.posY + 1, (int)player.posZ);
		if(player.isEntityAlive() && player.isInsideOfMaterial(Material.water)) {
			if(!player.canBreatheUnderwater() && !player.isPotionActive(Potion.waterBreathing.id)) {
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1, 0));
			}
		}
	}

}
