package com.sc.science.nio;

import org.junit.Test;

import java.nio.IntBuffer;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

/**
 * IntBuffer,FloatBuffer,CharBuffer,DoubleBuffer,ShortBuffer,LongBuffer,ByteBuffer
 * buffer.flip()将NIO Buffer转为读模式    buffer.clear(),buffer.compact(),将NIObuffer转为写模式
 */
public class BufferTest {

    /**
     * NIO Buffer的基本操作
     */
    @Test
    public void buffer() {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for (int i = 0; i < intBuffer.capacity(); ++i) {
            int j = 2 * (i + 1);
            // 将给定整数写入此缓冲区的当前位置，当前位置递增
            intBuffer.put(j);
        }
        intBuffer.flip();
        // 查看在当前位置和限制位置之间是否有元素
        while (intBuffer.hasRemaining()) {
            // 读取此缓冲区当前位置的整数，然后当前位置递增
            int j = intBuffer.get();
            System.out.print(j + "  ");
        }
    }

    /**
     * rewind函数重置缓冲区
     */
    @Test
    public void bufferRewind() {
        IntBuffer intbuffer = IntBuffer.allocate(3);
        System.out.println("-->" + intbuffer);
        intbuffer.put(5);
        intbuffer.put(6);
        intbuffer.put(8);
        //intbuffer.put(9);//会报错
        System.out.println("-->" + intbuffer);
        intbuffer.rewind();
        intbuffer.put(8);
        intbuffer.put(8);
        intbuffer.put(8);
        System.out.println("-->" + intbuffer);
        intbuffer.flip();//切换为读模式
        System.out.println("-->" + intbuffer.get(0));

    }

    /**
     * 通过mark和reset组合使用可以将position保存多次读数据
     */
    @Test
    public void bufferMarkReset() {
        IntBuffer intBuffer = IntBuffer.allocate(3);
        intBuffer.put(5);
        intBuffer.put(6);
        intBuffer.put(8);
        intBuffer.flip();
        System.out.println("-->" + intBuffer.get());
        intBuffer.mark();//标记post位置
        System.out.println("-->" + intBuffer.get());
        intBuffer.reset();//使post位置移动到三次标记位置
        System.out.println("-->" + intBuffer.get());
        System.out.println("-->" + intBuffer.get());

    }


    /**
     * claer将limit,capacity,position都归到初始位置即:limit=capacity,position=0;
     */
    @Test
    public void bufferClear() {
        IntBuffer intBuffer = IntBuffer.allocate(3);
        System.out.println("-->" + intBuffer);
        intBuffer.put(7);
        intBuffer.flip();
        intBuffer.get();
        intBuffer.clear();//里面存在的数据将无法被使用到
        intBuffer.put(9);
        intBuffer.flip();
        System.out.println("-->" + intBuffer.get());

    }

    /**
     * 将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面。limit属性依然像clear()方法一样，设置成capacity。现在Buffer准备好写数据了，但是不会覆盖未读的数据.
     */
    @Test
    public void bufferCompact() {
        IntBuffer intBuffer = IntBuffer.allocate(3);
        System.out.println("-->" + intBuffer);
        intBuffer.put(7);
        System.out.println("-->" + intBuffer);
        intBuffer.flip();
        System.out.println("-->" + intBuffer);
        intBuffer.compact();//将数据copy到初始位置即:limit=capacity,position=x;
        System.out.println("-->" + intBuffer);
        intBuffer.put(9);
        System.out.println("-->" + intBuffer);
        System.out.println("-->" + intBuffer.get(0));//依然能取到7
        intBuffer.flip();
        System.out.println("-->" + intBuffer);
        System.out.println("-->" +  intBuffer.get());

    }

}
