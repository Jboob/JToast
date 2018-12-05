package com.ran.creator;

/**
 * @author Ran
 * @date 2018/11/15.
 */

public class SystemToastCreator  {

    private int textColor;
    private int backgroundColor;
    private int shadowColor;
    private float shadowRadius;

    public int getTextColor() {
        return textColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getShadowColor() {
        return shadowColor;
    }

    public float getShadowRadius() {
        return shadowRadius;
    }

    private SystemToastCreator(SystemToastBuilder builder){
        this.textColor = builder.textColor;
        this.backgroundColor = builder.backgroundColor;
        this.shadowColor = builder.shadowColor;
        this.shadowRadius = builder.shadowRadius;
    }

    public static SystemToastBuilder build(){
        return new SystemToastBuilder();
    }

    public static class SystemToastBuilder{

        private int textColor;
        private int backgroundColor = -1;
        private int shadowColor = 0;
        private float shadowRadius = 2.75f;

        public SystemToastBuilder(){

        }

        public SystemToastBuilder setTextColor(int color) {
            this.textColor = color;
            return this;
        }

        public SystemToastBuilder setBackgroundColor(int color) {
            this.backgroundColor = color;
            return this;
        }

        public SystemToastBuilder shadowColor(int shadowColor){
            this.shadowColor = shadowColor;
            return this;
        }

        public SystemToastBuilder shadowRadius(float radius){
            this.shadowRadius = radius;
            return this;
        }

        public SystemToastCreator creator(){
            return new SystemToastCreator(this);
        }
    }
}
