package com.bwie.xutils.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：Xutils
 * 类描述：
 * 创建人：${丁江楠}
 * 创建时间：2017/1/22 19:28
 * 修改人：${丁江楠}
 * 修改时间：2017/1/22 19:28
 * 修改备注：
 */
public class Bean {
private Result result;

    @Override
    public String toString() {
        return "Bean{" +
                "result=" + result +
                '}';
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result{
        private List<Data> list=new ArrayList<>();

        @Override
        public String toString() {
            return "Result{" +
                    "list=" + list +
                    '}';
        }

        public List<Data> getList() {
            return list;
        }

        public void setList(List<Data> list) {
            this.list = list;
        }
    }


    public class Data{
        private String title;

        @Override
        public String toString() {
            return "Data{" +
                    "title='" + title + '\'' +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
