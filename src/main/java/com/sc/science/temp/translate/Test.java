package com.sc.science.temp.translate;

import com.alibaba.fastjson.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String appKey ="0198234236a6a8cd";
        String query = "967hotd1_1080_8000_Vicky+Love+and+Totti_-_Chamber+of+Pain+%26+Lust.mp4";
        String salt = String.valueOf(System.currentTimeMillis());
        String from = "auto";
        String to = "zh-CHS";
        String sign = md5(appKey + query + salt+ "vCv4OH8ODtTcoSTYzRKdMQraMLIUqKHI");
        Map params = new HashMap();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("sign", sign);
        params.put("salt", salt);
        params.put("appKey", appKey);
        System.out.println(requestForHttp("http://openapi.youdao.com/api", params));
    }

    public static String requestForHttp(String url,Map requestParams) throws Exception{
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        /**HttpPost*/
        HttpPost httpPost = new HttpPost(url);
        System.out.println(new JSONObject(requestParams).toString());
        List params = new ArrayList();
        Iterator it = requestParams.entrySet().iterator();
        while (it.hasNext()) {
            Entry en = (Entry) it.next();
            String key = (String) en.getKey();
            String value = (String) en.getValue();
            if (value != null) {
                params.add(new BasicNameValuePair(key, value));
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
        /**HttpResponse*/
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try{
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity, "utf-8");
            EntityUtils.consume(httpEntity);
        }finally{
            try{
                if(httpResponse!=null){
                    httpResponse.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 生成32位MD5摘要
     * @param string
     * @return
     */
    public static String md5(String string) {
        if(string == null){
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        try{
            byte[] btInput = string.getBytes("utf-8");
            /** 获得MD5摘要算法的 MessageDigest 对象 */
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            /** 使用指定的字节更新摘要 */
            mdInst.update(btInput);
            /** 获得密文 */
            byte[] md = mdInst.digest();
            /** 把密文转换成十六进制的字符串形式 */
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }catch(NoSuchAlgorithmException | UnsupportedEncodingException e){
            return null;
        }
    }


}
