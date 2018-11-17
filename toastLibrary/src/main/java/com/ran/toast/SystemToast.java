package com.ran.toast;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ran.creator.SystemToastCreator;
import com.ran.toast.base.BaseToast;

/**
 * @author Ran
 * @date 2018/11/15.
 */

class SystemToast extends BaseToast {

    private SystemToastCreator creator;
    private CharSequence text;
    private Context mContext;

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link }
     *                or {@link } object.
     */
    public SystemToast(Context context) {
        super(context);
        this.mContext = context;
       makeText(mContext,"",Toast.LENGTH_SHORT);
    }

    @Override
    public CharSequence getText() {
        return this.text;
    }

    protected void show(SystemToastCreator creator, CharSequence text) {
        if (isNull(creator)) {
            throw new NullPointerException("SystemToastCreator is not null.");
        }
        this.text = text;
        this.creator = creator;
        initToast();
    }

    protected void show(CharSequence content) {
        this.text = content;
        makeText(mContext.getApplicationContext(), content, Toast.LENGTH_SHORT).show();
    }

    private void initToast() {
        Toast toast = makeText(mContext,text,Toast.LENGTH_SHORT);
        View view = toast.getView();
        if (null == view){
            throw new NullPointerException("Toast view is null.");
        }
        TextView textView = view.findViewById(android.R.id.message);
        if (null == textView){
            throw new NullPointerException("Not found {android.R.id.message} , this is null.");
        }
        textView.setTextColor(creator.getTextColor());
        if (creator.getBackgroundColor() != -1){
            view.setBackgroundColor(creator.getBackgroundColor());
        }
        textView.setShadowLayer(creator.getShadowRadius(),0,0, creator.getShadowColor());
        toast.show();
    }

    @Override
    public void cancel() {
        super.cancel();
        if (!isNull(creator)) {
            creator = null;
        }
        if (isNull(text)) {
            text = null;
        }
    }

    private <T> boolean isNull(T t) {
        if (null != t) {
            return false;
        }
        return true;
    }
}
