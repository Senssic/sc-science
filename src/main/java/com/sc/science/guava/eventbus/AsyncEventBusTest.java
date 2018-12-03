package com.sc.science.guava.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AsyncEventBusTest {


    public static void main(String[] args) {
        DataObserver dataObserver = new DataObserver();
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(20);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 20, 30, TimeUnit.SECONDS, workQueue);
        EventBus eventBus = new AsyncEventBus(executor);
        eventBus.register(dataObserver);


        // 只有注册的参数类型为String的方法会被调用
        eventBus.post("post string method");
        eventBus.post(123);


        //发布实体消息
        eventBus.post(new EventData("eventDate", 30));


        //注销消费者,不再监听
        eventBus.unregister(dataObserver);
        eventBus.post("post string method");


        //executor.shutdown();

    }
}
