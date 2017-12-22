package com.sc.science.designmode.fitdesign.adapter;

/**
 * 适配转换类,适配banner并添加一些实现适配的动作
 *
 * @author qiss
 */
public class PrintBanner extends Print {
    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    /**
     * 因为是新的接口banner不能直接使用
     */
    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    /**
     *  因为是新的接口banner不能直接使用
     */
    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
