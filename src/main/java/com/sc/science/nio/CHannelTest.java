package com.sc.science.nio;

import org.junit.Test;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CHannelTest {
    @Test
    public void channelTest() throws Exception {
        byte message[] = {83, 111, 109, 101, 32,
                98, 121, 116, 101, 115, 46};
        FileOutputStream fout = new FileOutputStream("c:\\test.txt");
        FileChannel fc = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        for (int i = 0; i < message.length; ++i) {
            buffer.put(message[i]);
        }
        buffer.flip();
        fc.write(buffer);
        fout.close();
    }



}
