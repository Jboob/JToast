package com.ran.toast;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ran.creator.CustomToastCreator;
import com.ran.model.ParametersModel;
import com.ran.toast.base.BaseToast;
import com.ran.widget.RoundLinearLayout;

/**
 * @author Ran
 * @date 2018/11/15.
 */

class CustomToast extends BaseToast {

    private Context mContext;

    private CharSequence text;

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link }
     *                or {@link } object.
     */
    public CustomToast(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public CharSequence getText() {
        return text;
    }

    protected void show(CustomToastCreator creator, CharSequence text, @IdRes int resId) {
        this.text = text;
        initToast(creator,text,resId);
    }

    private void initToast(CustomToastCreator creator,CharSequence text, @IdRes int resId) {

        View view = null;
        if (!isNull(creator.getView())) {
            view = creator.getView();
        } else if (creator.getResView() >= 0) {
            LayoutInflater inflate = (LayoutInflater)
                    mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflate.inflate(creator.getResView(), null);
        } else {
            throw new NullPointerException("CustomView is not null in the Custom Toast.");
        }
        TextView textView = view.findViewById(resId);
        if (!isNull(textView)){
            if (isNull(text)){
                text = "null";
            }
            textView.setText(text);
            textView.setTextColor(creator.getTextColor());
        }

        if (!isNull(creator.getResIcon())){
            ParametersModel model = creator.getResIcon();
            ImageView imageView = view.findViewById(model.getResId());
            if (!isNull(imageView)){
                int iconId = (int) model.getObject();
                imageView.setImageResource(iconId);
            }
        }

        if (!isNull(creator.getBitmapIcon())){
            ParametersModel model = creator.getResIcon();
            ImageView imageView = view.findViewById(model.getResId());
            if (!isNull(imageView)){
                Bitmap bitmap = (Bitmap) model.getObject();
                imageView.setImageBitmap(bitmap);
            }
        }

        if (creator.isBackgroundRound()){
            RoundLinearLayout roundLinearLayout = new RoundLinearLayout(mContext);
            roundLinearLayout.setBackgroundColor(creator.getBackgroundColor());
            roundLinearLayout.setRadius(100f);
            roundLinearLayout.addView(view);
            setView(roundLinearLayout);
        }else {
            view.setBackgroundColor(creator.getBackgroundColor());
            setView(view);
        }
        show();
    }

    private <T> boolean isNull(T t) {
        if (null != t) {
            return false;
        }
        return true;
    }
}
