package com.ran.creator;

import android.graphics.Bitmap;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;

import com.ran.creator.base.BaseToastCreator;
import com.ran.model.ParametersModel;

/**
 * @author Ran
 * @date 2018/11/15.
 */

public class CustomToastCreator extends BaseToastCreator{


    private @ColorInt int textColor;
    private @ColorInt int backgroundColor;
    private View mView;
    private @LayoutRes int resView;
    private ParametersModel resIcon;
    private ParametersModel bitmapIcon;

    public int getTextColor() {
        return textColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public View getView() {
        return mView;
    }

    public void setView(View mView) {
        this.mView = mView;
    }

    public int getResView() {
        return resView;
    }

    public ParametersModel getResIcon() {
        return resIcon;
    }

    public ParametersModel getBitmapIcon() {
        return bitmapIcon;
    }

    private CustomToastCreator(CustomToastBuilder builder){
        this.textColor = builder.textColor;
        this.backgroundColor = builder.backgroundColor;
        this.mView = builder.mView;
        this.resView = builder.resView;
        this.resIcon = builder.resIcon;
        this.bitmapIcon = builder.bitmapIcon;
    }

    public static CustomToastBuilder build(){
        return new CustomToastBuilder();
    }

    public static class CustomToastBuilder  {

        private @ColorInt int textColor;
        private @ColorInt int backgroundColor;
        private View mView;
        private @LayoutRes int resView;
        private ParametersModel resIcon;
        private ParametersModel bitmapIcon;

        public CustomToastBuilder(){

        }

        public CustomToastBuilder setTextColor(@ColorInt int color) {
            this.textColor = color;
            return this;
        }

        public CustomToastBuilder setBackgroundColor(@ColorInt int color) {
            this.backgroundColor = color;
            return this;
        }

        public CustomToastBuilder setCustomView(View view) {
            this.mView = view;
            return this;
        }

        public CustomToastBuilder setCustomView(@LayoutRes int resource) {
            this.resView = resource;
            return this;
        }

        public CustomToastBuilder setToastIcon(@IdRes int resId, @DrawableRes int iconId) {
            this.resIcon = setModel(resId,iconId);
            return this;
        }

        public CustomToastBuilder setToastIcon(@IdRes int resId, Bitmap bitmap) {
            this.bitmapIcon = setModel(resId,bitmap);
            return this;
        }

        private ParametersModel setModel(int resId, Object obj){
            ParametersModel model = new ParametersModel();
            model.setResId(resId);
            model.setObject(obj);
            return model;
        }

        public CustomToastCreator creator(){
            return new CustomToastCreator(this);
        }
    }



}
