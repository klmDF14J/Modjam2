package holiday;

import holiday.block.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class WorldGenPalmTree extends WorldGenerator
{
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;

    /** True if this tree should grow Vines. */
    private final boolean vinesGrow;

    /** The metadata value of the wood to use in tree generation. */
    private final int metaWood;

    /** The metadata value of the leaves to use in tree generation. */
    private final int metaLeaves;

    public WorldGenPalmTree(boolean par1)
    {
        this(par1, 4, 0, 0, false);
    }

    public WorldGenPalmTree(boolean par1, int par2, int par3, int par4, boolean par5)
    {
        super(par1);
        this.minTreeHeight = par2;
        this.metaWood = par3;
        this.metaLeaves = par4;
        this.vinesGrow = par5;
    }

    public boolean generate(World world, Random rand, int x, int y, int z)
    {
    	int randHeight = rand.nextInt(4);
    	world.setBlock(x, y, z, Blocks.palmLog.blockID);
    	world.setBlock(x, y + 1, z, Blocks.palmLog.blockID);
    	world.setBlock(x, y + 2, z, Blocks.palmLog.blockID);
    	world.setBlock(x, y + 3, z, Blocks.palmLog.blockID);
    	world.setBlock(x, y + 4, z, Blocks.palmLog.blockID);
    	
    	for(int i = 0; i < randHeight; i++) {
    		world.setBlock(x, y + 5 + i, z, Blocks.palmLog.blockID);
    	}
    	
    	world.setBlock(x, y + 5 + randHeight, z, Block.leaves.blockID);
    	
    	world.setBlock(x + 1, y + 5 + randHeight, z, Block.leaves.blockID);
    	world.setBlock(x - 1, y + 5 + randHeight, z, Block.leaves.blockID);
    	world.setBlock(x, y + 5 + randHeight, z + 1, Block.leaves.blockID);
    	world.setBlock(x, y + 5 + randHeight, z - 1, Block.leaves.blockID);
    	
    	world.setBlock(x + 2, y + 5 + randHeight, z, Block.leaves.blockID);
    	world.setBlock(x - 2, y + 5 + randHeight, z, Block.leaves.blockID);
    	world.setBlock(x, y + 5 + randHeight, z + 2, Block.leaves.blockID);
    	world.setBlock(x, y + 5 + randHeight, z - 2, Block.leaves.blockID);
    	
    	world.setBlock(x + 2, y + 4 + randHeight, z, Block.leaves.blockID);
    	world.setBlock(x - 2, y + 4 + randHeight, z, Block.leaves.blockID);
    	world.setBlock(x, y + 4 + randHeight, z + 2, Block.leaves.blockID);
    	world.setBlock(x, y + 4 + randHeight, z - 2, Block.leaves.blockID);
    	
    	world.setBlock(x + 3, y + 4 + randHeight, z, Block.leaves.blockID);
    	world.setBlock(x - 3, y + 4 + randHeight, z, Block.leaves.blockID);
    	world.setBlock(x, y + 4 + randHeight, z + 3, Block.leaves.blockID);
    	world.setBlock(x, y + 4 + randHeight, z - 3, Block.leaves.blockID);
    	
    	world.setBlock(x + 3, y + 3 + randHeight, z, Block.leaves.blockID);
    	world.setBlock(x - 3, y + 3 + randHeight, z, Block.leaves.blockID);
    	world.setBlock(x, y + 3 + randHeight, z + 3, Block.leaves.blockID);
    	world.setBlock(x, y + 3 + randHeight, z - 3, Block.leaves.blockID);
        return true;
    }

    /**
     * Grows vines downward from the given block for a given length. Args: World, x, starty, z, vine-length
     */
    private void growVines(World par1World, int par2, int par3, int par4, int par5)
    {
        this.setBlockAndMetadata(par1World, par2, par3, par4, Block.vine.blockID, par5);
        int i1 = 4;

        while (true)
        {
            --par3;

            if (!par1World.isAirBlock(par2, par3, par4) || i1 <= 0)
            {
                return;
            }

            this.setBlockAndMetadata(par1World, par2, par3, par4, Block.vine.blockID, par5);
            --i1;
        }
    }
}
