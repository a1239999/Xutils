package com.bwie.xutils.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bwie.xutils.R;
import com.bwie.xutils.bean.User;

import org.xutils.DbManager;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

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
@ContentView(R.layout.four)
public class FourFragment extends Fragment {
    @ViewInject(R.id.name)
    EditText edit_name;
    @ViewInject(R.id.password)
    EditText edit_password;
    @ViewInject(R.id.create_db)
     Button create_db;
     private DbManager.DaoConfig manager=new DbManager.DaoConfig().setDbName("dingjiangnan.db").setTableCreateListener(new DbManager.TableCreateListener() {
        @Override
        public void onTableCreated(DbManager db, TableEntity<?> table) {

        }
    }).setDbOpenListener(new DbManager.DbOpenListener() {
         @Override
         public void onDbOpened(DbManager db) {
             db.getDatabase().enableWriteAheadLogging();
         }
     });
    DbManager db = x.getDb(manager);
    private String name1;
    private String age1;
    private String name;
    private String age;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this,inflater,container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    @Event(R.id.create_db)
    private void create_Db(View view){
        List<User> all = null;
        try {
            all = db.findAll(User.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        Log.i("nan",all.toString());
        for(User user:all){
            name1 = user.getName();
            age1 = user.getAge();
            Log.i("TAG", "create_Db: "+ name1);
            Log.i("TAG", "create_Db: "+ age1);
        }
        if(!edit_name.getText().equals(name1)){
            name = edit_name.getText().toString();
            age = edit_password.getText().toString();
            try {
                db.save(new User(name,age));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
       Snackbar.make(view,"添加过了",Snackbar.LENGTH_LONG).show();
        }
    }
    @Event(R.id.delete_table)
    private void delete(View v) throws DbException {
        db.dropTable(User.class);
    }
    @Event(R.id.selsct)
    private void select(View v) throws DbException {
        List<User> all = db.findAll(User.class);
        Log.i("nan",all.toString());
        for(User user:all){
            name1 = user.getName();
            age1 = user.getAge();
            Log.i("TAG", "create_Db: "+ name1);
            Log.i("TAG", "create_Db: "+ age1);
        }
    }
}
