package holiday.item;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import holiday.item.*;

public class EntityBeachBall extends EntityReddustFX {

	private double x, y, z;
	private World world;
	
	public EntityBeachBall(World par1World, double targetX, double targetY, double targetZ, int x2, int y2, int z2) {
		super(par1World, x2, y2, z2, 1, 1, 1);
		
		//func_110125_a(Items.beachball.beachball);
		
		x = targetX;
		y = targetY;
		z = targetZ;
		
		world = par1World;
	}

	@Override
	public void entityInit() {

	}
	
	

	@Override
	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		
	}
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		System.out.println("Updating");
		
		if(!world.isRemote) {
			if(posX != x) {
				if(posX > x) {
					posX--;
				}
				if(posX < x) {
					posX++;
				}
			}
			if(posY != y) {
				if(posY > y) {
					posY--;
				}
				if(posY < y) {
					posY++;
				}
			}
			if(posZ != z) {
				if(posZ > z) {
					posZ--;
				}
				if(posZ < z) {
					posZ++;
				}
			}
		}
	}

}
