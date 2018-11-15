package com.ran.creator.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 作者：Ranbo on 2016/7/29 18:14
 * 邮箱：vip_jboob@163.com
 */
public class JToast {

    private static volatile JToast INSTANCE = null;


    private Toast toast;

    private Handler mHandler;

    private View mView;

    private Context mContext;

    private JToast(Context ctx) {
        mHandler = new Handler();
        mContext = ctx.getApplicationContext();
    }

    public synchronized static JToast getInstance(Context ctx) {
        if (INSTANCE == null) {
            synchronized (JToast.class) {
                if (INSTANCE == null) {
                    INSTANCE = new JToast(ctx);
                }
            }
        }
        return INSTANCE;
    }

    public void setCustomView(View view) {
        this.mView = view;
    }

    public void setCustomView(@LayoutRes int resource) {
        this.mView = LayoutInflater.from(mContext).inflate(resource, null);
    }

    public void setText(@IdRes int viewId, CharSequence content) {
        TextView textView = findViewById(viewId);
        textView.setText(content);
    }

    public void setIcon(@IdRes int viewId, @DrawableRes int iconId) {
        ImageView imageView = findViewById(viewId);
        imageView.setImageResource(iconId);
    }

    public void setIcon(@IdRes int viewId, Bitmap bitmap) {
        ImageView imageView = findViewById(viewId);
        imageView.setImageBitmap(bitmap);
    }

    public void show(CharSequence content) {
        show(content, 2000);
    }

    public void show(CharSequence content, int time) {
        time = time < 1000 ? 2000 : time;//默认两秒
        mHandler.removeCallbacks(runnable);
        mHandler.postDelayed(runnable, time);
        if (null == mView){
            showSystemToast(content);
        }
    }

    private void showCustomToast() {
        if (null == toast) {
            toast = new Toast(mContext);
        }

    }

    private void showSystemToast(CharSequence content) {
        if (!TextUtils.isEmpty(content)) {
            if (null == toast) {
                toast = Toast.makeText(mContext, content, Toast.LENGTH_SHORT);
            }
            toast.setText(content);
            toast.show();
        }
    }

    private <V extends View> V findViewById(@IdRes int viewId) {
        if (null == mView) {
            throw new NullPointerException("View is null ! please set 'setCustomView' method.");
        }
        V v = mView.findViewById(viewId);
        if (null == v) {
            throw new NullPointerException("viewId is not found ! please check viewId.");
        }
        return v;
    }

    /**
     *
     */
    public void cancel() {
        toast.cancel();
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            cancel();
        }
    };
}
