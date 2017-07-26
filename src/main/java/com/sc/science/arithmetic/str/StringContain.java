package com.sc.science.arithmetic.str;

/**
 * 字符串包含,无论顺序,无论数量
 *
 * 比如:abcd  包含   acccccc  返回true
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StringContain {
    /**
     * 位运算
     *
     * 先把a所有的字符都放入一个散列表中,然后轮询短字符串b,看b中的每个字符是否都在散列表里面,如果都在则包含,否则不包含
     * @param a
     * @param b
     * @return
     */
    public static  boolean stringContain(String a,String b){
        char[] ca=a.toCharArray();
        char[] cb=b.toCharArray();
        int hash=0;
        for(int i=0;i<ca.length;++i){
            hash|=(1<<(ca[i]-'A'));
        }
        for(int i=0;i<cb.length;++i){
            if((hash & (1<<(cb[i]-'A')))==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("-->" +StringContain.stringContain("abcdeeeef","eeeeeeefe"));
        System.out.println("-->" +"abcdf".contains("cd"));
    }
}
