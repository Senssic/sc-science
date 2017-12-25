package com.sc.science.designmode.uniformity.decorator;

/**
 * 被装饰者具体实现类
 *
 * @author qiss
 */
public class StringDisplay extends Display {
    private String string;

    public StringDisplay(String string) {           // 通过参数传入要显示的字符串
        this.string = string;
    }

    @Override
    public int getColumns() {                       // 字符数
        return string.getBytes().length;
    }

    @Override
    public int getRows() {                          // 行数是1
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return string;
        } else {
            return null;
        }
    }
}
