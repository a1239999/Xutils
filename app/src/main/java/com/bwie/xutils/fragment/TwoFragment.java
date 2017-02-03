package com.bwie.xutils.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.xutils.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;


/**
 * 项目名称：Xutils
 * 类描述：
 * 创建人：${丁江楠}
 * 创建时间：2017/1/22 14:46
 * 修改人：${丁江楠}
 * 修改时间：2017/1/22 14:46
 * 修改备注：
 */
@ContentView(R.layout.two)
public class TwoFragment extends Fragment {
    @ViewInject(R.id.get)
    Button get;
    @ViewInject(R.id.post)
    Button post;
    @ViewInject(R.id.upload)
    Button upload;
    @ViewInject(R.id.download)
    Button download;
    @ViewInject(R.id.textView)
    TextView textview;
    @ViewInject(R.id.imageView)
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Event(R.id.get)
    private void get(final View view) {
        //   Snackbar.make(view,"点击了get",Snackbar.LENGTH_LONG).show();
        String url="http://v.juhe.cn/weixin/query?pno=&ps=&dtype=&key=dcea9d3f5ffccdbe84fa9e588a480997";
        HttpUtils client=new HttpUtils();
        client.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                Snackbar.make(view,result,Snackbar.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }
    @Event(R.id.download)
    private void download(View view){
        HttpUtils utils=new HttpUtils();
        HttpHandler handler=utils.download("http://v.juhe.cn/weixin/redirect?wid=wechat_20170117019820",//网络上要下载的东西
                "/mnt/sdcard/Pictures/Screenshots/1111111111.png",//下载到的地址
                true, // 如果目标文件存在，接着未完成的部分继续下载。服务器不支持RANGE时将从新下载。
                true, // 如果从请求返回信息中获取到文件名，下载完成后自动重命名。
                new RequestCallBack<File>() {
            @Override
            public void onStart() {
                super.onStart();
                textview.setText("开始了");
            }
            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                super.onLoading(total, current, isUploading);
                textview.setText(current + "/" + total);
            }
            @Override
            public void onSuccess(ResponseInfo<File> responseInfo) {
                textview.setText("下载完成：" + responseInfo.result.getPath());
                /*BitmapUtils utils=new BitmapUtils(getActivity());
                utils.configDefaultLoadingImage(R.mipmap.ic_launcher);//默认的背景图片
                utils.configDefaultLoadFailedImage(R.mipmap.ic_launcher);//加载失败的图片
                utils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);//图片格式
                utils.display(imageView,"http://zxpic.gtimg.com/infonew/0/wechat_pics_-12159359.jpg/640");*/
            }
            @Override
            public void onFailure(HttpException e, String s) {
                textview.setText(s);
            }
        });
    }
    @Event(R.id.upload)
    private void upload(View view){
        BitmapUtils utils=new BitmapUtils(getActivity());
        utils.configDefaultLoadingImage(R.mipmap.ic_launcher);//默认的背景图片
        utils.configDefaultLoadFailedImage(R.mipmap.ic_launcher);//加载失败的图片
        utils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);//图片格式
        utils.display(imageView,"http://zxpic.gtimg.com/infonew/0/wechat_pics_-12159359.jpg/640");
    }

}
