package com.sc.science.temp.translate;

import com.alibaba.fastjson.JSON;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TranslateDht {
   private static Pattern pattern = Pattern.compile("[\\u4E00-\\u9FBF]+");
    public static void main(String[] args) throws Exception {

        Connection connection = DBUtil.openConn("MySQL", "139.224.114.xx", "3306", "dht?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull", "root", "xx");
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
                        if (hasChineseByReg(name)) {
                            System.out.println("无需翻译-->" + name);
                            DBUtil.update(connection, "update torrents set tran_name=? where id=?", new Object[]{name, id});
                            continue;
                        }
                        TransResult transResult=null;
                        try {
                            transResult= YouDaoApi.translate(name);
                        } catch (Exception e) {
                            DBUtil.update(connection, "update torrents set tran_name=? where id=?", new Object[]{"-1", id});
                        }

                        if (transResult.getErrorCode().equals("0")) {
                            DBUtil.update(connection, "update torrents set tran_name=? where id=?", new Object[]{transResult.getTranslation(), id});
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

    public static boolean hasChineseByReg(String str) {
        if (str == null) {
            return false;
        }

        return pattern.matcher(str).find();
    }

}
