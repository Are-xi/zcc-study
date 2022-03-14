package netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.rmi.activation.ActivationSystem;
import java.util.Scanner;

public class NettyClientHander extends SimpleChannelInboundHandler<Object> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        System.out.println(((ByteBuf)o).toString(CharsetUtil.UTF_8));
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf byteBuf = Unpooled.copiedBuffer("我知道了1",CharsetUtil.UTF_8);
        ctx.writeAndFlush(byteBuf);
        new Thread(() ->{
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                ctx.writeAndFlush(Unpooled.copiedBuffer(scanner.nextLine(),CharsetUtil.UTF_8));

            }
        }).start();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.print("发生异常了"+cause.getMessage());
        ctx.close();
    }
}
