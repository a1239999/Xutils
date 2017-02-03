package com.bwie.xutils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.xutils.fragment.FourFragment;
import com.bwie.xutils.fragment.OneFragment;
import com.bwie.xutils.fragment.ThreeFragment;
import com.bwie.xutils.fragment.TwoFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
//根据极客学院视频观看学习
//blog.csdn.net/dj0379/article/details/38356773/博客网址
//Xutils框架的好处  目前在github来说是比较完善的一个框架  很实用
@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new OneFragment();
                    case 1:
                        return new TwoFragment();
                    case 2:
                        return new ThreeFragment();
                    case 3:
                        return new FourFragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:
                       return "注释模块";
                    case 1:
                        return "网络模块";
                    case 2:
                        return "图片模块";
                    case 3:
                        return "数据库模块";
                }
                return null;
            }
        });

    }
}
