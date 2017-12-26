package com.sc.science.designmode.avoidwaste.proxy;

/**
 * 代理者
 *
 * @author qiss
 */
public class PrinterProxy implements Printable {
    private String name;
    private Printer real;

    public PrinterProxy() {
    }

    public PrinterProxy(String name) {      // 构造函数
        this.name = name;
    }

    @Override
    public String getPrinterName() {    // 获取名字
        return name;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }
}
