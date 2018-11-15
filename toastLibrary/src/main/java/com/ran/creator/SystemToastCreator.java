package com.ran.creator;

import com.ran.creator.base.BaseToastCreator;
import com.ran.interfaces.IToast;

/**
 * @author Ran
 * @date 2018/11/15.
 */

public class SystemToastCreator extends BaseToastCreator {


    private CharSequence content;
    private int textColor;
    private int backgroundColor;

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

    private SystemToastCreator(SystemToastBuilder builder){
        this.content = builder.content;
        this.textColor = builder.textColor;
        this.backgroundColor = builder.backgroundColor;
    }

    public static SystemToastBuilder build(){
        return new SystemToastBuilder();
    }

    private static class SystemToastBuilder implements IToast{

        private CharSequence content;
        private int textColor;
        private int backgroundColor;

        public SystemToastBuilder(){

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

        public SystemToastCreator creator(){
            return new SystemToastCreator(this);
        }

    }



}
