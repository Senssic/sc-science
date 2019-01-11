package com.sc.science.temp.translate;

import com.alibaba.fastjson.JSON;
import com.sc.science.db.DBUtil;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TranslateDht {

    public static void main(String[] args) throws Exception {

        Connection connection = DBUtil.openConn("MySQL", "139.224.114.xxx", "3306", "dht?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull", "root", "123456");
        if (connection == null || connection.isClosed()) {
            return;
        }
        List<Map<String, Object>> mapList = null;
        do {
            mapList = DBUtil.queryMapList(connection, "select name,id from torrents where tran_name is  null  limit 0,30", null);
            for (Map<String, Object> map : mapList) {
                try {
                    String name = (String) map.get("name");
                    BigInteger id = (BigInteger) map.get("id");
                    if (!org.apache.commons.lang3.StringUtils.isEmpty(name)) {
                        TransResult transResult = YouDaoApi.translate(name);
                        if (transResult.getErrorCode().equals("0")) {
                            DBUtil.update(connection, "update torrents set tran_name=? where id=?", new Object[]{transResult.getTranslation().get(0), id});
                            System.out.println("处理第[" + id + "]-->[" + name + "]-->" + JSON.toJSONString(transResult.getTranslation()) + "成功!");
                        } else {
                            System.out.println("翻译失败!-->" + id);
                            DBUtil.update(connection, "update torrents set tran_name=? where id=?", new Object[]{"1", id});
                        }
                    } else {
                        System.out.println("-->空数据!" + id);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while (mapList != null && mapList.size() > 0);
    }
}
