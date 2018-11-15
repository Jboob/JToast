package com.ran.interfaces;

import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * @author Ran
 * @date 2018/11/15.
 */

public interface ICustomToast extends IToast {

    void setCustomView(View view);

    void setCustomView(@LayoutRes int resource);

    void setToastTitle(@IdRes int resId, CharSequence content);

    void setToastIcon(@IdRes int resId, @DrawableRes int iconId);

    void setToastIcon(@IdRes int resId, Bitmap bitmap);

}
