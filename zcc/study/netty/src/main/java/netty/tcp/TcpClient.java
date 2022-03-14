package netty.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TcpClient {

    public static void main(String[] args) {
        EventLoopGroup clientEventGroup = new NioEventLoopGroup();


        try{

            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(clientEventGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new NettyChatClientInitializer());

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8098).sync();

            channelFuture.addListener(future -> {
                if (channelFuture.isSuccess()){
                    System.out.println("客户端启动成功"+channelFuture.channel().localAddress());
                }
            });

            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            clientEventGroup.shutdownGracefully();
        }

    }

}


