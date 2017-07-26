package com.sc.science.guava;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Making basic collections easier to work with.
 *
 * @author Glen Smith (glen@bytecode.com.au)
 */
public class CollectionsTest {
    //创建集合
    @Test
    public void collectionCreation() {
        List<String> empty = Lists.newArrayList();
        Map<String, String> userIdToName = Maps.newHashMap();

        List<String> names = Lists.newArrayList("Glen", "Kylie", "Isaac", "Zoe");
        Set<String> set=  Sets.newHashSet();
        assertEquals(4, names.size());
    }

    @Test
    public void immutableCollections() {
        Set<String> PEOPLE = ImmutableSet.of("Glen", "Kylie", "Isaac", "Zoe");

        try {
            PEOPLE.add("Add me");
            fail("Should not be able to add()");
        } catch (UnsupportedOperationException uoe) {
            // all is well
        }
        List<String> immutableNamedColors = ImmutableList.<String>builder()
                .add("red", "green","black","white","grey")
                .build();
        List<String> sourlist=Lists.newArrayList("a","b","c");
        List<String>  targetList=ImmutableList.copyOf(sourlist);
       // immutableNamedColors.add(":");//不可变集合,不能添加或删除等修改集合的方法
        for(String s:immutableNamedColors){
            System.out.println("-->" +s);
        }

    }

    @Test
    public void immutableMaps() {

        ImmutableMap<String, String> userIdToEmail = ImmutableMap.of("glen", "glen@bytecode.com.au",
                "kylie", "kylie@bytecode.com.au");
        assertEquals("glen@bytecode.com.au", userIdToEmail.get("glen"));
    }

    @Test
    public void buildingImmutableMaps() {

        ImmutableMap<Integer, String> postcodes = new ImmutableMap.Builder<Integer, String>()
                .put(2600, "Tony")
                .put(2615, "Glen")
                .build();
        assertEquals("Tony", postcodes.get(2600));

    }
    //不可变集合枚举的一些操作
    @Test
    public void setOperations() {
        Set<String> first = Sets.newHashSet("a", "b", "c");
        Set<String> second = Sets.newHashSet("c", "d", "e");
        //存在集合一中且不存在集合二中的所有元素
        assertEquals(ImmutableSet.of("a", "b"), Sets.difference(first, second));
        //差集
        assertEquals(ImmutableSet.of("a", "b", "d", "e"), Sets.symmetricDifference(first, second));
        //交集
        assertEquals(ImmutableSet.of("c"), Sets.intersection(first, second));
        //并集
        assertEquals(ImmutableSet.of("a", "b", "c", "d", "e"), Sets.union(first, second));
    }
    //排序
    @Test
    public void orderingCollections() {
        List<Account> accounts = ImmutableList.of(
                new Account("glen", "pw", "glen@glensmith.com.au"),
                new Account("glen", "pw", "glen@bytecode.com.au"),
                new Account("kylie", "pw", "kylie@bytecode.com.au")
                
        );
        Ordering<Account> byNameThenEmail = new Ordering<Account>() {

            @Override
            public int compare(Account left, Account right) {
                return ComparisonChain.start().
                        compare(left.getUsername(), right.getUsername()).
                        compare(left.getEmail(), right.getEmail()).
                        result();
            }
            
        };


        assertFalse(byNameThenEmail.isOrdered(accounts));
        assertEquals("glen@bytecode.com.au", 
                byNameThenEmail.sortedCopy(accounts).get(0).getEmail());
        assertEquals("kylie", byNameThenEmail.reverse().min(accounts).getUsername());
        
    }
    @Test
    public void iterators(){
        //1.判断是否所有的都满足集合条件

        List<String> list = Lists.newArrayList("Apple","Pear","Peach","Banana");

        Predicate<String> condition = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return ((String)input).startsWith("P");
            }
        };
        boolean allIsStartsWithP = Iterators.all(list.iterator(), condition);//是否满足条件
        System.out.println("all result == " + allIsStartsWithP);
        //2.获取集合中的第N个
        String secondElement = Iterators.get(list.iterator(), 1);
        //3.获取集合
        Iterator<String> startPElements = Iterators.filter(list.iterator(), new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.startsWith("P");
            }
        });
        //4.返回符合的第一个值
        String length5Element = Iterators.find(list.iterator(), new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.length() == 5;
            }
        });
        //5.对迭代元素进行转换
        Iterator<Integer> countIterator = Iterators.transform(list.iterator(), new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return input.length();
            }
        });
    }

}
