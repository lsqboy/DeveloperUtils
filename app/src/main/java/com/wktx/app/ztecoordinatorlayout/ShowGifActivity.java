package com.wktx.app.ztecoordinatorlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;


public class ShowGifActivity extends AppCompatActivity {

    private boolean isShowGif = true;
    private int duration = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_gif);
        final ImageView loveView = (ImageView) findViewById(R.id.love);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(ShowGifActivity.this).load(R.mipmap.lovegif).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(new GlideDrawableImageViewTarget(loveView, 1));
            }
        });
//        Glide.with(ShowGifActivity.this)
//                        .load(R.mipmap.lovegif)
//                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                        .listener(new RequestListener<Integer, GlideDrawable>() {
//
//                            @Override
//                            public boolean onException(Exception arg0, Integer arg1,
//                                                       Target<GlideDrawable> arg2, boolean arg3) {
//                                return false;
//                            }
//
//                            @Override
//                            public boolean onResourceReady(GlideDrawable resource,
//                                                           Integer model, Target<GlideDrawable> target,
//                                                           boolean isFromMemoryCache, boolean isFirstResource) {
//                                // 计算动画时长
//                                GifDrawable drawable = (GifDrawable) resource;
//                                GifDecoder decoder = drawable.getDecoder();
//                                for (int i = 0; i < drawable.getFrameCount(); i++) {
//                                    duration += decoder.getDelay(i);
//                                }
//                                //发送延时消息，通知动画结束
//                                handler.sendEmptyMessageDelayed(MESSAGE_SUCCESS,
//                                        duration);
//                                return false;
//                            }
//                        }) //仅仅加载一次gif动画
//                        .into(new GlideDrawableImageViewTarget(loveView, 1));
    }
}
