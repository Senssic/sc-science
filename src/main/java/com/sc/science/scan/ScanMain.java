package com.sc.science.scan;

import com.sc.science.scan.api.IScan;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ScanMain {
    public static void main(String[] args) {
        IScan scan = new FileScan("C:\\Users\\Administrator\\Desktop\\prelog");


        scan.doScan(new RegHandle(new DbOutPut()));
    }
}
