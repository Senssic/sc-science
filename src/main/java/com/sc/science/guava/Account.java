package com.sc.science.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import java.util.Date;

/**
 * A basic account object with some common field types to allow us to experiment our guava
 * features.
 *
 * @author Glen
 */
public class Account implements Comparable<Account> {

    private String username;
    private String password;
    private Integer key;

    private String email;
    private Date dateCreated;
    private Date lastLogin;

    public Account() {
    }

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    //使用guava的工具类方便生成toString
    @Override
    public String toString() {
        // return SenUtils.getToString(Account.class,this);  //进一步封装
        return MoreObjects.toStringHelper(this)
                .add("name", username)
                .add("email", email)
                .add("created", dateCreated)
                .add("lastLogon", lastLogin)
                .toString();

    }

    //使用guava的工具类,快速生成hashCode
    @Override
    public int hashCode() {
        return Objects.hashCode(username, email);
    }

    //使用guava的工具类,快速比较对象
    @Override
    public boolean equals(Object obj) {
        Account other = (Account) obj;
        return Objects.equal(username, other.getUsername()) &&
                Objects.equal(email, other.getEmail());
    }

    //使用guava的工具类快速实现比较排序
    @Override
    public int compareTo(Account o) {
        return ComparisonChain.start()
                .compare(username, o.username)
                .compare(email, o.email)
                .result();

    }


}
