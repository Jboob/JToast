package com.ran.interfaces;

import android.support.annotation.ColorInt;

/**
 * @author Ran
 * @date 2018/11/15.
 */

public interface IToast {

     void setText(CharSequence content);

     void setTextColor(@ColorInt int color);

     void setBackgroundColor(@ColorInt int color);


}
