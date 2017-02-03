package com.bwie.xutils.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bwie.xutils.R;

import org.xutils.common.Callback;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 项目名称：Xutils
 * 类描述：
 * 创建人：${丁江楠}
 * 创建时间：2017/1/22 14:46
 * 修改人：${丁江楠}
 * 修改时间：2017/1/22 14:46
 * 修改备注：
 */
@ContentView(R.layout.three)

public class ThreeFragment extends Fragment {
    @ViewInject(R.id.imageView01)
    ImageView imageView01;
    @ViewInject(R.id.imageView02)
    ImageView imageView02;
    @ViewInject(R.id.imageView03)
    ImageView imageView03;
    @ViewInject(R.id.imageView04)
    ImageView imageView04;
    @ViewInject(R.id.imageView05)
    ImageView imageView05;
    private String[] images=new String[]{
            "http://zxpic.gtimg.com/infonew/0/wechat_pics_-12159730.jpg/640",
            "http://zxpic.gtimg.com/infonew/0/wechat_pics_-12159805.jpg/640"

    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this,inflater,container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.sca);
        ImageOptions options=new ImageOptions.Builder().setCircular(true).setRadius(5).setAnimation(animation).build();
        x.image().bind(imageView01,images[0]);
        x.image().bind(imageView02,images[1],options);
        x.image().bind(imageView03, images[0],  new Callback.CommonCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
        x.image().loadDrawable(images[0], options, new Callback.CommonCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable result) {
                imageView04.setImageDrawable(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

}
