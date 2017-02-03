package com.bwie.xutils.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.bwie.xutils.R;
import com.bwie.xutils.adapter.Child;
import com.bwie.xutils.adapter.ChildAdapter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * 项目名称：Xutils
 * 类描述：
 * 创建人：${丁江楠}
 * 创建时间：2017/1/22 14:46
 * 修改人：${丁江楠}
 * 修改时间：2017/1/22 14:46
 * 修改备注：
 */
@ContentView(R.layout.one)
public class OneFragment extends Fragment {
    @ViewInject(R.id.one_button)
    Button button;
    @ViewInject(R.id.listview_one)
    ListView listView;
    private boolean add;
    private List<Child> list;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(new Child("丁江楠"+i));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this,inflater,container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView.setAdapter(new ChildAdapter(getActivity(),list));
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
    }
    @Event(type = View.OnClickListener.class,value = R.id.one_button)
    private void textOnclick(View view){
        Snackbar.make(view,"点击了",Snackbar.LENGTH_LONG).show();
    }
    @Event(type = AdapterView.OnItemClickListener.class,value = R.id.listview_one)
    private void listonitemonclick(AdapterView<?> parent, View view, int position, long id){
        Snackbar.make(view,"点击了条目",Snackbar.LENGTH_LONG).show();
    }
}
