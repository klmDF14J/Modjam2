package holiday;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class HolidayBiome extends BiomeGenBase {

	public static WorldGenerator worldGenPalmTree, worldGenOasis;
	
	public HolidayBiome(int par1) {
		super(par1);
		this.topBlock = (byte) Block.sand.blockID;
		this.fillerBlock = (byte) Block.sandStone.blockID;
		this.setDisableRain();
		worldGenPalmTree = new WorldGenPalmTree(true, 8, 0, 0, false);
		worldGenOasis = new WorldGenOasis();
	}
	
	 public WorldGenerator getRandomWorldGenForTrees(Random par1Random) {
		 return (WorldGenerator)(par1Random.nextInt(10) == 0 ? this.worldGeneratorBigTree : worldGenPalmTree);
	 }
	 
	@Override
	public void decorate(World world, Random rand, int par3, int par4) {
		super.decorate(world, rand, par3, par4);
		
		if(rand.nextInt(40) == 0) {
			int k = par3 + rand.nextInt(16) + 8;
	        int l = par4 + rand.nextInt(16) + 8;
	            
			worldGenOasis.generate(world, rand, k, world.getHeightValue(k, l), l);
		}
	}
	 

}
