package com.sc.science.designmode.uniformity.decorator;

/**
 * 装饰框接口,必须和Display有相同接口,继承即可,并聚合装饰物
 *
 * @author qiss
 */
public abstract class Border extends Display {
    protected Display display;

    protected Border(Display display) { // 在生成实例时通过参数指定被装饰物
        this.display = display;
    }
}
