package com.sc.science.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

import org.junit.Test;

import java.util.SortedSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Basic work around Common object-related operations.
 *
 * @author Glen Smith (glen@bytecode.com.au)
 */
public class ObjectsTest {
    //object toString方法的快速呈现
    @Test
    public void nicerToString() {
        Account account = new Account("glen", "password", "glen@bytecode.com.au");
        String expected = "Account{name=glen, email=glen@bytecode.com.au, created=null, lastLogon=null}";
        assertEquals(expected, account.toString());
    }
    //给定其中不为空的参数,如果第一个不为空则返回第一个参数,如果第一个为空第二个不为空则返回第二个参数,如果两个都为空,则抛出null异常
    @Test
    public void firstNonNull() {
        assertEquals("two", MoreObjects.firstNonNull(null, "two"));
        assertEquals("one", MoreObjects.firstNonNull("one","two"));
    }

    //比较两个对象
    @Test
    public void nullsafeEquals() {
        assertTrue(Objects.equal(null, null));
        assertFalse(Objects.equal(null, "something"));
    }
    //快速生成hashCode
    @Test
    public void implementingHashCode() {
        
        int code = Objects.hashCode(1, 2, 3, null, 4);
        assertEquals(29615141, code);
        
    }
    //快速比较Account类实现Comparable接口,ComparisonChain
    @Test
    public void comparisonChain() {
        
        Account one = new Account("glen", "pw", "glen@glensmith.com.au");
        Account two = new Account("glen", "pw", "glen@bytecode.com.au");
        
        SortedSet<Account> accounts = Sets.newTreeSet();
        accounts.add(one);
        accounts.add(two);
        Account first = Iterables.getFirst(accounts, null);
        assertEquals("glen@bytecode.com.au", first.getEmail());
       
        
    }
    

}
