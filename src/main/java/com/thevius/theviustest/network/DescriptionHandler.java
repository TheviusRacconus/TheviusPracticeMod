package com.thevius.theviustest.network;

import com.thevius.theviustest.TheviusTest;
import com.thevius.theviustest.reference.Reference;
import com.thevius.theviustest.tileentity.TileEntityThevius;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.tileentity.TileEntity;

@ChannelHandler.Sharable
public class DescriptionHandler extends SimpleChannelInboundHandler<FMLProxyPacket>
{
    public static final String CHANNEL = Reference.MOD_ID + "Description";

    static
    {
        NetworkRegistry.INSTANCE.newChannel(CHANNEL, new DescriptionHandler());
    }

    public static void init()
    {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception
    {
        ByteBuf buf = msg.payload();
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
        TileEntity te = TheviusTest.proxy.getClientPlayer().worldObj.getTileEntity(x, y, z);
        if(te instanceof TileEntityThevius)
        {
            ((TileEntityThevius)te).readFromPacket(buf);
        }
    }

}
