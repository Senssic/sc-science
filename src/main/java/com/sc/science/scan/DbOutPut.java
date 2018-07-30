package com.sc.science.scan;

import com.sc.science.db.DBUtil;
import com.sc.science.scan.api.IOutPut;
import com.sc.science.scan.dto.AbsAppation;

import java.io.IOException;
import java.sql.Connection;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DbOutPut implements IOutPut {
    public final Connection connection = DBUtil.openConn("MySQL", "10.1.41.32", "3306", "cjia_db_report?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull", "root", "cjadmin");

    @Override
    public void writeOut(AbsAppation absAppation) throws IOException {
        DBUtil.update(connection, "INSERT INTO allloginfo (`date`, `ip`, `content`) VALUES (?, ?, ?);", new Object[]{absAppation.getPostDate(), absAppation.getIp(), absAppation.getServiceUrl()});
    }
}
