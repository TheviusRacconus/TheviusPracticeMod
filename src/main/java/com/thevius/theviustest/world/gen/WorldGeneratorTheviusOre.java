package com.thevius.theviustest.world.gen;

import com.thevius.theviustest.init.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class WorldGeneratorTheviusOre implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        world.setBlock(chunkX * 16, 30, chunkZ * 16, ModBlocks.theviusOre, 0, 2);
    }
}
