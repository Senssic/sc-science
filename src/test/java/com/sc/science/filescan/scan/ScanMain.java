package com.sc.science.filescan.scan;

import com.sc.science.filescan.scan.api.IScan;

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
        IScan scan = new FileScan("C:\\Users\\qiss\\Desktop\\prelog\\sensen");


        scan.doScan(new RegHandle(new DbOutPut()));
    }
}
