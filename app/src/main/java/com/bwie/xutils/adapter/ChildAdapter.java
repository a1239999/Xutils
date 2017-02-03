package com.bwie.xutils.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.xutils.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：Xutils
 * 类描述：
 * 创建人：${丁江楠}
 * 创建时间：2017/1/22 15:28
 * 修改人：${丁江楠}
 * 修改时间：2017/1/22 15:28
 * 修改备注：
 */
public class ChildAdapter extends BaseAdapter {
    private Context context;
    private List<Child> list=new ArrayList<>();

    public ChildAdapter(Context context, List<Child> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoldr viewHoldr;
        if(convertView==null){
            convertView=View.inflate(context,R.layout.one_item,null);
            viewHoldr=new ViewHoldr();
            x.view().inject(viewHoldr,convertView);
            convertView.setTag(viewHoldr);
        }
        else{
            viewHoldr = (ViewHoldr) convertView.getTag();
        }
        viewHoldr.textView.setText(list.get(position).getName());
        return convertView;
    }
    class ViewHoldr{
        @ViewInject(R.id.one_text)
        TextView textView;
    }
}
