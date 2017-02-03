package com.bwie.xutils;

import android.app.Application;

import org.xutils.x;


/**
 * 项目名称：Xutils
 * 类描述：
 * 创建人：${丁江楠}
 * 创建时间：2017/1/22 14:30
 * 修改人：${丁江楠}
 * 修改时间：2017/1/22 14:30
 * 修改备注：
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        x.Ext.init(this);
    }
}
