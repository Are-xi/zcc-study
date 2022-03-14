package netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.InetAddress;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    private Log logger = LogFactory.getLog(NettyServerHandler.class);



    /**
     * 收到数据时调用
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try{
            ByteBuf in = (ByteBuf) msg;
            int read = in.readableBytes();
            byte[] bytes = new byte[read];

            in.readBytes(bytes);
            System.out.println(new String(bytes));

          logger.error("服务端接受的消息 : " + msg);

        }finally {
            ReferenceCountUtil.release(msg);
        }
    }


    /**
     * 出现异常是关闭连接
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 建立连接是返回消息
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.error("连接得客户端地址是："+ctx.channel().remoteAddress());
        logger.error("连接得客户端id是："+ctx.channel().id());
        ctx.writeAndFlush("client"+ InetAddress.getLocalHost().getHostName()+"连接成功 \n");
        System.out.println("connection");
        super.channelActive(ctx);
    }
}
