package com.sc.science.temp.translate;

import com.alibaba.fastjson.JSON;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
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
import java.util.List;
import java.util.Map;


public class YouDaoApi {

    public static TransResult translate(String query) throws Exception {

        String appKey = "xx";
        String salt = String.valueOf(System.currentTimeMillis());
        String from = "auto";
        String to = "zh-CHS";
        String sign = MD5Util.getMD5(appKey + query + salt + "xx");
        Map params = new HashMap();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("pid", appKey);
        params.put("salt", salt);
        params.put("sign", sign);


        String string = requestForHttp("http://fanyi.sogou.com/reventondc/api/sogouTranslate", params);

        TransResult transResul = JSON.parseObject(string, TransResult.class);
        return transResul;
    }

    public static String requestForHttp(String url,Map requestParams) throws Exception{
    /*    String requestBody="from=auto&to=zh-CHS&pid=4f4afa06d963e0aecaf552ff4e21988d&q="+requestParams.get("q")+"&sign="+requestParams.get("sign")+"&salt="+requestParams.get("salt");
        System.out.println("-->" +requestBody);
        HttpResponse response = Unirest.post("http://fanyi.sogou.com:80/reventondc/api/sogouTranslate")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("accept", "application/json")
                .body(requestBody)
                .asString();
        System.out.println("-->" +response.getBody());


        return (String) response.getBody();*/
        System.out.println("request:-->" +JSON.toJSONString(requestParams));
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        /**HttpPost*/
        HttpPost httpPost = new HttpPost(url);

        List nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("from", (String) requestParams.get("from")));
        nvps.add(new BasicNameValuePair("to", (String) requestParams.get("to")));
        nvps.add(new BasicNameValuePair("pid", (String) requestParams.get("pid")));
        nvps.add(new BasicNameValuePair("q", (String) requestParams.get("q")));
        nvps.add(new BasicNameValuePair("sign", (String) requestParams.get("sign")));
        nvps.add(new BasicNameValuePair("salt", (String) requestParams.get("salt")));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        HttpRequestBase requestBase = httpPost;
        requestBase.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.131 Safari/537.36");
        requestBase.addHeader("content-type", "application/x-www-form-urlencoded");
        requestBase.addHeader("accept", "application/json");
        CloseableHttpResponse httpResponse = httpClient.execute(requestBase);
        try{
            org.apache.http.HttpEntity httpEntity = httpResponse.getEntity();
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
        System.out.println("response:-->" +result);
        return result;
    }


    /**
     * 生成32位MD5摘要
     *
     * @param string
     * @return
     */
    private static String md5(String string) {
        if (string == null) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        try {
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
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
    }


}
