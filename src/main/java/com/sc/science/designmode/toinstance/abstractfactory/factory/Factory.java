package com.sc.science.designmode.toinstance.abstractfactory.factory;

/**
 * 抽象工厂
 *
 * @author qiss
 */
public abstract class Factory {
    /**
     * 返回抽象工厂实例类
     * @param classname
     * @return
     */
    public static Factory getFactory(String classname) {
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(classname).newInstance();
        } catch (ClassNotFoundException e) {
            System.err.println("没有找到 " + classname + "类。");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    /**
     * 创建抽象产品Link
     * @param caption
     * @param url
     * @return
     */
    public abstract Link createLink(String caption, String url);

    /**
     * 创建抽象产品Tray
     * @param caption
     * @return
     */
    public abstract Tray createTray(String caption);

    /**
     * 创建抽象产品Page
     * @param title
     * @param author
     * @return
     */
    public abstract Page createPage(String title, String author);
}
