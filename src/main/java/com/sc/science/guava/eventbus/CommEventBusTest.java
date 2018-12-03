package com.sc.science.guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * 注意点
 * 1.代码可读性很差，项目中使用的时候，从post的地方，查询handle使用，都是使用ide的搜索服务，问题很难定位，不如普通的接口调用方便查询；
 * 2.由于EventBus是将消息队列放入到内存中的，listener消费这个消息队列，故系统重启之后，保存或者堆积在队列中的消息丢失。
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CommEventBusTest {

    public static void main(String[] args) {
        DataObserver dataObserver = new DataObserver();
        EventBus eventBus = new EventBus();
        eventBus.register(dataObserver);


        // 只有注册的参数类型为String的方法会被调用
        eventBus.post("post string method");
        eventBus.post(123);


        //发布实体消息
        eventBus.post(new EventData("eventDate", 30));



        //注销消费者,不再监听
        eventBus.unregister(dataObserver);
        eventBus.post("post string method");


    }

}
