package com.bwie.xutils.adapter;

/**
 * 项目名称：Xutils
 * 类描述：
 * 创建人：${丁江楠}
 * 创建时间：2017/1/22 15:28
 * 修改人：${丁江楠}
 * 修改时间：2017/1/22 15:28
 * 修改备注：
 */
public class Child {
    private String name;

    public Child(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
