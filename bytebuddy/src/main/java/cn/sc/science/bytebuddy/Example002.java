package cn.sc.science.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;

public class Example002 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException {
        DynamicType.Unloaded<Dog> hello = new ByteBuddy()
                .subclass(Dog.class)
                .method(ElementMatchers.named("hello"))
                .intercept(MethodDelegation.to(MyServiceInterceptor.class))
                .make();
        hello.saveIn(new File(".\\src\\test\\java"));
        Class<? extends Dog> loaded = hello.load(Example002.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();


        Object s = loaded.newInstance();
        System.out.println(((Dog) s).hello());
    }

}