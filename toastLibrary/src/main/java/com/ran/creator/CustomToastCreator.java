package com.ran.creator;

import android.graphics.Bitmap;
import android.view.View;

import com.ran.creator.base.BaseToastCreator;
import com.ran.interfaces.ICustomToast;
import com.ran.model.ParametersModel;

/**
 * @author Ran
 * @date 2018/11/15.
 */

public class CustomToastCreator extends BaseToastCreator{


    private CharSequence content;
    private int textColor;
    private int backgroundColor;
    private View mView;
    private int resView;
    private ParametersModel resIcon;
    private ParametersModel bitmapIcon;
    private ParametersModel resTitle;

    public ParametersModel getResTitle() {
        return resTitle;
    }

    public void setResTitle(ParametersModel resTitle) {
        this.resTitle = resTitle;
    }

    public CharSequence getContent() {
        return content;
    }

    public void setContent(CharSequence content) {
        this.content = content;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
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

    public void setResView(int resView) {
        this.resView = resView;
    }

    public ParametersModel getResIcon() {
        return resIcon;
    }

    public void setResIcon(ParametersModel resIcon) {
        this.resIcon = resIcon;
    }

    public ParametersModel getBitmapIcon() {
        return bitmapIcon;
    }

    public void setBitmapIcon(ParametersModel bitmapIcon) {
        this.bitmapIcon = bitmapIcon;
    }

    private CustomToastCreator(CustomToastBuilder builder){
        this.content = builder.content;
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

    private static class CustomToastBuilder implements ICustomToast {

        private CharSequence content;
        private int textColor;
        private int backgroundColor;
        private View mView;
        private int resView;
        private ParametersModel resIcon;
        private ParametersModel bitmapIcon;
        private ParametersModel resTitle;

        public CustomToastBuilder(){

        }

        @Override
        public void setText(CharSequence content) {
            this.content = content;
        }

        @Override
        public void setTextColor(int color) {
            this.textColor = color;
        }

        @Override
        public void setBackgroundColor(int color) {
            this.backgroundColor = color;
        }

        @Override
        public void setCustomView(View view) {
            this.mView = view;
        }

        @Override
        public void setCustomView(int resource) {
            this.resView = resource;
        }

        @Override
        public void setToastTitle(int resId, CharSequence content) {
            this.resTitle = setModel(resId,content);
        }

        @Override
        public void setToastIcon(int resId, int iconId) {
            this.resIcon = setModel(resId,iconId);
        }

        @Override
        public void setToastIcon(int resId, Bitmap bitmap) {
            this.bitmapIcon = setModel(resId,bitmap);
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
