package com.bb.jtoast.base;

import android.content.Context;
import android.os.Handler;

/**
 * 作者：Ranbo on 2016/7/29 18:12
 * 邮箱：sjf201410@qq.com
 */
public interface JBase {

    Handler mHandler = new Handler();

    void show(Context ctx,CharSequence content,int time);

    void dimiss();

}
