package nio;

import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;

public class NioByteBufferPutGet {
    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        byteBuffer.putInt(3);

        byteBuffer.putChar('s');

        byteBuffer.putLong(23);

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getLong());



    }

}
