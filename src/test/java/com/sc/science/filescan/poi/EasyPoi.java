package com.sc.science.filescan.poi;


import com.sc.science.filescan.db.DBUtil;

import java.io.File;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class EasyPoi {
    public static final Connection connection = DBUtil.openConn("MySQL", "10.1.41.32", "3306", "senssic_test?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull", "root", "cjadmin");

    public static void main(String[] args) {
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        List<IpMapper> list = ExcelImportUtil.importExcel(
                new File("C:\\Users\\qiss\\Desktop\\CJIA\\01.xlsx"),
                IpMapper.class, params);

        for (IpMapper ipMapper : list) {
            for (Map.Entry<String, String> entry : ipMapper.featchEnv().entrySet()) {
                String ip = entry.getKey(), port = "";
                if (entry.getKey().contains(":")) {
                    ip = entry.getKey().split(":")[0];
                    port = entry.getKey().split(":")[1];
                }
                DBUtil.update(connection, "INSERT INTO ipmapper (`servicename`, `ip`,port, `environment`) VALUES (?, ?,?, ?);", new Object[]{ipMapper.getServicename(), ip, port, entry.getValue()});
            }
        }
        System.out.println(list.size());
    }
}
