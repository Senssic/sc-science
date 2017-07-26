package com.sc.science.guava;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.reflect.Reflection;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.RateLimiter;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Filtering and transforming collections with a functional style.
 *
 * @author Glen Smith (glen@bytecode.com.au)
 */
public class FunctionalTest {

    List<Account> accounts;

    @Before
    public void setup() {
        accounts = Lists.newArrayList(new Account("glen", "pw", "glen@bytecode.com.au"),
                new Account("joe", "pw", "joe@joecool.com.au"),
                new Account("mary", "secret", "mary@marycool.com.au"));

    }
    @Test
    public void rateLimiter(){
        //1.ListenableFuture顾名思义就是可以监听的Future，它是对java原生Future的扩展增强
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call execute..");
                TimeUnit.SECONDS.sleep(1);
                return 7;
            }
        });
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("get listenable future's result with callback " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });



        //2.RateLimiter限制资源的并发访问线程数
        RateLimiter limiter = RateLimiter.create(4.0); //每秒不超过4个任务被提交
        limiter.acquire();  //请求RateLimiter, 超过permits会被阻塞
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("-->do do do .....");
            }
        }); //提交任务
        if(limiter.tryAcquire()){ //未请求到limiter则立即返回false
            System.out.println("-->do someting");
        }else{
            System.out.println("-->do else someting" );
        }
    }

    @Test
    public void filteringCollection() {
        List<Account> badPasswords = Lists.newArrayList(Iterables.filter(accounts, new Predicate<Account>() {
            @Override
            public boolean apply(Account account) {
                return account.getPassword().equals("pw");
            }
        }));
        assertEquals(2, badPasswords.size());
    }

    @Test
    public void transformCollection() {
        Collection<String> emails = Collections2.transform(accounts, new Function<Account, String>() {
            @Override
            public String apply(Account account) {
                return account.getEmail();
            }
        });
        ImmutableSet<String> expected = ImmutableSet.of("glen@bytecode.com.au", "joe@joecool.com.au", "mary@marycool.com.au");
        Set<String> actual = Sets.newHashSet(emails);
        assertEquals(0, Sets.symmetricDifference(expected, actual).size());
    }

    /**
     * 动态代理  guava
     */
    @Test
    public void reflect() {
        InvocationHandler invocationHandler = new MyInvocationHandler();
        // Guava Dynamic Proxy implement
        IFoo foo = Reflection.newProxy(IFoo.class, invocationHandler);
        foo.doSomething();
        //jdk Dynamic proxy implement
        IFoo jdkFoo = (IFoo) Proxy.newProxyInstance(
                IFoo.class.getClassLoader(),
                new Class<?>[]{IFoo.class},
                invocationHandler);
        jdkFoo.doSomething();


    }

    public interface IFoo {
        void doSomething();
    }

    class MyInvocationHandler implements InvocationHandler {
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println("proxy println something");
            return null;
        }
    }
}

