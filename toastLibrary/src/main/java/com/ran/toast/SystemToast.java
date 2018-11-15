package com.ran.toast;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ran.creator.SystemToastCreator;

/**
 * @author Ran
 * @date 2018/11/15.
 */

public class SystemToast {

    private SystemToastCreator systemToastCreator;

    private Toast toast;

    private Context mContext;

    protected void setContext(Context ctx) {
        this.mContext = ctx;
    }

    protected void setCreator(SystemToastCreator creator) {
        this.systemToastCreator = creator;
    }

    protected void show(Context ctx) {
        if (isNull(systemToastCreator)){
            throw new NullPointerException("SystemToastCreator is not null.");
        }
        initToast(ctx.getApplicationContext());
    }

    protected void show(CharSequence content) {
        toast = Toast.makeText(mContext, content, Toast.LENGTH_SHORT);
        toast.show();
        toast.cancel();
    }

    protected void cancel() {
        if (!isNull(toast))
            toast.cancel();
    }

    private void initToast(Context ctx) {
        toast = new Toast(ctx);
        View view = toast.getView();
        TextView textView = view.findViewById(android.R.id.message);
        textView.setTextColor(systemToastCreator.getTextColor());
        view.setBackgroundColor(systemToastCreator.getBackgroundColor());
        textView.setText(systemToastCreator.getContent());
        toast.show();
    }

    private <T> boolean isNull(T t) {
        if (null != t) {
            return false;
        }
        return true;
    }
}
