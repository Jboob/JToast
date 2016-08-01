package com.bb.jtoast.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.bb.jtoast.base.JBase;

/**
 * 作者：Ranbo on 2016/7/29 18:14
 * 邮箱：sjf201410@qq.com
 */
public class JToast implements JBase {

    private static JToast jToast;

    private static Toast toast;

    private JToast(){
    }

    public synchronized static JToast getInstance(){
        if (null == jToast){
            jToast = new JToast();
        }
        return jToast;
    }


    @Override
    public void show(Context ctx, CharSequence content, int time) {
        time = time < 1000?2000:time;
        mHandler.removeCallbacks(runnable);
        mHandler.postDelayed(runnable,time);
        showToast(ctx,content,time);
    }

    @Override
    public void dimiss() {

    }

    private void showToast(Context ctx, CharSequence content, int time){
        Context applicationContext = ctx.getApplicationContext();
        if (!TextUtils.isEmpty(content)){
            if (null == toast){
                toast = Toast.makeText(applicationContext,content,Toast.LENGTH_SHORT);
            }
            toast.show();
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            JToast.toast.cancel();
        }
    };
}
