package netty.tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

import java.util.LinkedList;
import java.util.List;

public class NettyChatInitializer extends ChannelInitializer<SocketChannel> {
    //存储该 初始化Channel 用余每次发送群聊消息
    public static final List<SocketChannel> socketChannels = new LinkedList<>();

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // ch 类型是 NioSocketChannel
        socketChannels.add(ch);
        ch.pipeline().addLast(new NettyChatHandler());


    }
}


