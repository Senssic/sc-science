package com.sc.science.juc;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Test {
    public static void main(String[] args) throws Exception{
        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(3);
        System.out.println("-->" + arrayBlockingQueue.take());

    }
}
