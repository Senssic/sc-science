package com.sc.science.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Working with in-memory caching.
 *
 * @author Glen Smith (glen@bytecode.com.au)
 */
public class CachingTest {

    @Test
    public void cacheFun() throws InterruptedException, ExecutionException {
        //缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
        LoadingCache<Integer,Account> studentCache
                //CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
                = CacheBuilder.newBuilder()
                //设置并发级别为8，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(8)
                //设置写缓存后8秒钟过期
                .expireAfterWrite(8, TimeUnit.SECONDS)
                //设置缓存容器的初始容量为10
                .initialCapacity(10)
                //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(100)
                //设置要统计缓存的命中率
                .recordStats()
                //设置缓存的移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                })
                //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(
                        new CacheLoader<Integer, Account>() {//此处的key可以是sql的查询字段,这样从数据库中查询的数据就缓存到内存中了
                            @Override
                            public Account load(Integer key) throws Exception {
                                System.out.println("load student " + key);
                                Account student = new Account();
                                student.setKey(key);
                                student.setUsername("name " + key);
                                return student;
                            }
                        }
                );


        //刷新key为1的缓存
        studentCache.refresh(1);

        for (int i=0;i<20;i++) {

            //从缓存中得到数据，由于我们没有设置过缓存，所以需要通过CacheLoader加载缓存数据
            Account student = studentCache.get(1);//如果是load中没有检查异常则使用getUncheck抛出异常,get会抛出异常
            System.out.println(student);
            //休眠1秒
            TimeUnit.SECONDS.sleep(1);
        }



        System.out.println("cache stats:");
        //最后打印缓存的命中率等 情况
        System.out.println(studentCache.stats().toString());
        
    }

}
