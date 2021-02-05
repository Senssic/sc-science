package cn.sc.science.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;

public class Example001 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException {
        DynamicType.Unloaded<Object> toString = new ByteBuddy().with(TypeValidation.of(true))
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))

                .intercept(FixedValue.value("Hello World!"))
                .make();
        toString.saveIn(new File(".\\src\\test\\java"));
        Class dynamicType = toString.load(Example001.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

        Object s = dynamicType.newInstance();
        System.out.println(s);
    }

}