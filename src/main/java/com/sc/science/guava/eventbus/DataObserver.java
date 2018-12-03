package com.sc.science.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DataObserver {

    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     *
     * @param msg
     */
    @Subscribe
    public void func(String msg) {
        System.out.println("String msg: " + msg);
    }


    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     *
     * @param msg
     */
    @Subscribe
    public void funcEventData(EventData msg) {
        System.out.println("String eventData msg: " + msg);
    }

}
