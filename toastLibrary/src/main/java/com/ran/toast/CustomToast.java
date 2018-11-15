package com.ran.toast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ran.creator.CustomToastCreator;
import com.ran.model.ParametersModel;

/**
 * @author Ran
 * @date 2018/11/15.
 */

public class CustomToast {


    private CustomToastCreator customToastCreator;

    private Toast toast;

    private Context mContext;

    protected void setContext(Context ctx) {
        this.mContext = ctx;
    }

    protected void setCreator(CustomToastCreator creator) {
        this.customToastCreator = creator;
    }

    protected void show(Context ctx) {
        if (isNull(customToastCreator)){
            throw new NullPointerException("CustomToastCreator is not null.");
        }
        initToast(ctx.getApplicationContext());
    }

    private void initToast(Context ctx) {
        toast = new Toast(ctx);
        View view = null;
        if (!isNull(customToastCreator.getView())){
            view = customToastCreator.getView();
        }else if (customToastCreator.getResView() >= 0){
            view = LayoutInflater.from(mContext).inflate(customToastCreator.getResView(),null);
        }else {
            throw new NullPointerException("CustomView is not null in the Custom Toast.");
        }

        if (!isNull(customToastCreator.getResTitle())){
            ParametersModel model = customToastCreator.getResTitle();
            TextView textView = view.findViewById(model.getResId());
            if (!isNull(textView)){
                if (!isNull(model.getObject())){
                    if (model.getObject() instanceof CharSequence){
                        textView.setText((CharSequence) model.getObject());
                    }
                }
                textView.setTextColor(customToastCreator.getTextColor());
            }
        }

        view.setBackgroundColor(customToastCreator.getBackgroundColor());
        toast.setView(view);
        toast.show();
    }

    protected void cancel() {
        if (!isNull(toast))
            toast.cancel();
    }

    private <T> boolean isNull(T t) {
        if (null != t) {
            return false;
        }
        return true;
    }
}
