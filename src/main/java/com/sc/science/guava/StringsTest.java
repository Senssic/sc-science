package com.sc.science.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Basic work around String operations.
 *
 * @author Glen Smith (glen@bytecode.com.au)
 */
public class StringsTest {

    //使用com.google.common.base.Strings类的isNullOrEmpty(input)方法判断字符串是否为空
    @Test
    public void livingInFearOfNullNoMore() {
        assertTrue(Strings.isNullOrEmpty(null));//是否是""或者是null
        assertTrue(Strings.isNullOrEmpty(""));
        assertFalse(Strings.isNullOrEmpty("       "));
        assertNull(Strings.emptyToNull(""));//""转为null
        assertNotNull(Strings.nullToEmpty(null));//null转为""

    }

    //填充字符
    @Test
    public void pad() {
        assertEquals("ssscc", Strings.padEnd("sss", 5, 'c'));//后填充
        assertEquals("22.12", Strings.padStart(".12", 5, '2'));//前填充
    }

    @Test
    public void basicSplitting() {

        List<String> splitRoles = Splitter.on(',').trimResults()//去除空白符号
                .omitEmptyStrings().splitToList("role1, role2 ,role3,,,role4,");//过去空字符串
        assertEquals(4, splitRoles.size());

        Set<String> rolesSet = ImmutableSet.copyOf(splitRoles);
        ImmutableSet<String> expectedSet = ImmutableSet.of("role1", "role2", "role3", "role4");
        assertTrue(rolesSet.containsAll(expectedSet));

        Map<String,String> expStr=Splitter.onPattern("[,;]{1,}").trimResults().omitEmptyStrings().withKeyValueSeparator("=")//
                .split("a=b;c=d,e=f");//使用正则且使用二次拆分
        for(Map.Entry<String,String> entry:expStr.entrySet()){
            System.out.println(entry.getKey()+"-->" +entry.getValue());
        }

    }

    @Test
    public void splittingToMaps() {
        String faveCols = "Glen=Orange;Kylie=Aqua;Isaac=Blue;Zoe=Yellow";
        Map<String, String> userToColour = Splitter.on(";")
                .withKeyValueSeparator("=")
                .split(faveCols);
        assertEquals("Orange", userToColour.get("Glen"));
    }

//合并字符串
    @Test
    public void basicJoining() {

        List<String> someRoles = Lists.newArrayList("role1", "role2", null, "role3");
        String rolesString = Joiner.on(",").skipNulls().join(someRoles);
        assertEquals("role1,role2,role3", rolesString);

        rolesString = Joiner.on(",").useForNull("(missing)").join(someRoles);
        assertEquals("role1,role2,(missing),role3", rolesString);

    }
//逆向合并字符串并二次合并
    @Test
    public void joinToMap() {
        Map<String, Integer> mapToJoin = ImmutableMap.of("one", 1, "two", 2, "three", 3);

        String joined = Joiner.on(",").withKeyValueSeparator("=").join(mapToJoin);
        assertEquals("one=1,two=2,three=3", joined);


    }

    @Test
    public void prefixing() {
        assertEquals("winwinwin", Strings.repeat("win", 3));//重复三次
        assertEquals("win", Strings.commonPrefix("winning", "wins"));//相同的前缀
        assertEquals("winning", Strings.commonSuffix("bi-winning", "so winning"));//相同的后缀
    }

    //比对和转换
    @Test
    public void charMatchingFun() {

        assertTrue(CharMatcher.DIGIT.matches('0'));
        assertTrue(CharMatcher.DIGIT.matchesAllOf("123456789"));
        assertTrue(CharMatcher.WHITESPACE.or(CharMatcher.DIGIT).
                or(CharMatcher.JAVA_LOWER_CASE).matchesAllOf("abc 123"));
        assertEquals("123-def", CharMatcher.anyOf("cba").collapseFrom("123abcdef", '-'));
        assertEquals("123def", CharMatcher.anyOf("cba").removeFrom("123abcdef"));
        assertEquals("abc", CharMatcher.anyOf("cba").retainFrom("123abcdef"));

    }

}
