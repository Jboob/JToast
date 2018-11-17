package com.ran.toast.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * @author Ran
 * @date 2018/11/16.
 */

public abstract class BaseToast extends Toast {

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public BaseToast(Context context) {
        super(context);

    }

    public abstract CharSequence getText();
}
