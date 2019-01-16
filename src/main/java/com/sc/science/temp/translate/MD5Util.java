package com.sc.science.temp.translate;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    public static String getMD5(String source) {
        if (source == null) {
            return null;
        }
        return getMD5(source, null);
    }
    public static String getMD5(String source, String encryptcode) {
        if (source == null) {
            return null;
        }
        if (encryptcode == null) {
            return DigestUtils.md5Hex(source);
        }
        return DigestUtils.md5Hex(source + encryptcode);
    }
    public static void main(String[] args) {
        System.out.println(getMD5("fafafafafatest1508404016012秘钥"));
    }
}