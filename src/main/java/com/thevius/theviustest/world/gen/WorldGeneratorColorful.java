package com.thevius.theviustest.world.gen;

import com.thevius.theviustest.init.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class WorldGeneratorColorful implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        switch(world.provider.dimensionId)
        {
            case 0:
                generateSurface(world, x, z, random);
                break;
            case -1:
                generateNether(world, x, z, random);
                break;
            case 1:
                generateEnd(world, x, z, random);
                break;
            default:
                generateSurface(world, x, z, random);
        }
    }

    public void generateSurface(World world, int x, int z, Random random)
    {
       if(random.nextInt(10) == 0)
       {
           int randX = x + random.nextInt(16);
           int randZ = z + random.nextInt(16);
           int randY = world.getHeightValue(randX, randZ);
          if(world.getBiomeGenForCoords(randX, randZ) != BiomeGenBase.river && world.getBiomeGenForCoords(randX, randZ) != BiomeGenBase.ocean)
          {
              Block block = world.getBlock(randX, randY - 1, randZ);
              if(block != Blocks.water && block != Blocks.lava)
              {
                  generateColorfulBlock(world, randX, randY, randZ);
              }
          }
       }

    }

    public void generateNether(World world, int x, int z, Random random)
    {

    }

    public void generateEnd(World world, int x, int z, Random random)
    {

    }

    private void generateColorfulBlock(World world, int x, int y, int z)
    {
        for(int i = 0; i < 10; i++)
        {
            world.setBlock(x, y + i, z, Blocks.fence, 0, 2);
        }

        for(int dx = 0; dx < 4; dx++)
        {
            for(int dy = 0; dy < 3; dy++)
            {
                world.setBlock(x + 1 + dx, y + 7 + dy, z, ModBlocks.colorfulBlock);
            }

        }
    }
}
