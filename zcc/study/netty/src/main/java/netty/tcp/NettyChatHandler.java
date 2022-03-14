package netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class NettyChatHandler extends SimpleChannelInboundHandler<Object> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        //System.out.println("客户端消息为："+((ByteBuf) msg).toString(CharsetUtil.UTF_8));
        String mesStr = ((ByteBuf) msg).toString(CharsetUtil.UTF_8);
        // 进行群发路由 这个 channel 就是 NioSocketChannel
        Channel channel = ctx.channel();
        NettyChatInitializer.socketChannels.forEach(socketChannel -> {
            if (socketChannel instanceof Channel && socketChannel != channel) {
                socketChannel.writeAndFlush(Unpooled.copiedBuffer(channel.remoteAddress() + ": " + mesStr, CharsetUtil.UTF_8));
            }
        });
       /* ByteBuf byteBuf = Unpooled.copiedBuffer("我知道了 我是服务器", CharsetUtil.UTF_8);
        ctx.writeAndFlush(byteBuf);*/
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        NettyChatInitializer.socketChannels.remove(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("异常产生：" + cause.getMessage());
        NettyChatInitializer.socketChannels.remove(ctx.channel());
        ctx.close();
    }

}

