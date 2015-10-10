package com.thevius.theviustest.world.gen;

import com.thevius.theviustest.init.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class WorldGeneratorExploding implements IWorldGenerator
{
    private WorldGenMinable explodingBlockGen = new WorldGenMinable(ModBlocks.explodingBlock, 10);

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
        for(int i = 0; i < 5; i++)
        {
            int randX = x + random.nextInt(16);
            int randY = random.nextInt(20 + random.nextInt(60));
            int randZ = z + random.nextInt(16);

            explodingBlockGen.generate(world, random, randX, randY, randZ);
        }
    }

    public void generateNether(World world, int x, int z, Random random)
    {

    }

    public void generateEnd(World world, int x, int z, Random random)
    {

    }

}


