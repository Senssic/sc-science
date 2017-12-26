package com.sc.science.designmode.avoidwaste.proxy;

/**
 * 具体被代理者
 *
 * @author qiss
 */
public class Printer implements Printable {
    private String name;

    public Printer() {
        heavyJob("正在生成Printer的实例");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("正在生成Printer的实例(" + name + ")");
    }

    @Override
    public String getPrinterName() {                // 获取名字
        return name;
    }

    @Override
    public void setPrinterName(String name) {       // 设置名字
        this.name = name;
    }

    @Override
    public void print(String string) {
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("结束。");
    }
}
