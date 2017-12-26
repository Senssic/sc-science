package com.sc.science.designmode.makesimple.facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 系统一 提供getProperties接口
 *
 * @author qiss
 */
public class Database {
    private Database() {
    }

    public static Properties getProperties(String dbname) {
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found.");
        }
        return prop;
    }
}
