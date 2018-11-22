package com.sc.science.temp.scan;

import com.sc.science.temp.scan.api.IHandle;
import com.sc.science.temp.scan.api.IScan;

import java.io.File;
import java.io.IOException;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FileScan implements IScan {

    private String path;


    public FileScan(String path) {
        this.path = path;
    }

    /**
     * 扫描方式
     */
    @Override
    public void doScan(IHandle handle) {
        File file = new File(this.path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        this.path = file2.getAbsolutePath();
                        doScan(handle);
                    } else {
                        try {
                            handle.doHandle(file2);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
