package com.bwie.xutils.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * 项目名称：Xutils
 * 类描述：
 * 创建人：${丁江楠}
 * 创建时间：2017/1/25 15:11
 * 修改人：${丁江楠}
 * 修改时间：2017/1/25 15:11
 * 修改备注：
 */
@Table(name = "nan")
public class User {
    @Column(name = "id",isId = true, autoGen = true, property = "NOT NULL")
    private int id;
    @Column(name = "u_name",property = "NOT NULL")
    private String name;
    @Column(name = "u_age")
    private String age;

    public User() {
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

