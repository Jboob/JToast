package com.ran.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import com.ran.toast.R;

/**
 * @author Ran
 * @date 2018/11/17.
 */

public class RoundLinearLayout extends LinearLayout {

    private String TAG = "RoundLinearLayout";

    private float cornesRadius;

    private float[] radii;

    private GradientDrawable gradientDrawable;

    private @ColorInt int backgroundColor;

    private @DrawableRes int backgroundResource;

    public RoundLinearLayout(Context context) {
        super(context);

    }

    public RoundLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RoundLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, @Nullable AttributeSet attrs) {
        gradientDrawable = new GradientDrawable();
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.RoundLayout);
        this.cornesRadius = arr.getFloat(R.styleable.RoundLayout_radius, 0);
        if (cornesRadius == 0) {
            float topLeftRadius = arr.getFloat(R.styleable.RoundLayout_topLeftRadius, 0);
            float topRightRadius = arr.getFloat(R.styleable.RoundLayout_topRightRadius, 0);
            float bottomLeftRadius = arr.getFloat(R.styleable.RoundLayout_bottomLeftRadius, 0);
            float bottomRightRadius = arr.getFloat(R.styleable.RoundLayout_bottomRightRadius, 0);
            radii = new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius,
                    bottomLeftRadius, bottomLeftRadius, bottomRightRadius, bottomRightRadius};
        }
        drawRoundDrawable();
        arr.recycle();
    }

    public void setRadius(float radius) {
        this.cornesRadius = radius;
        if (null != gradientDrawable) {
            gradientDrawable.setCornerRadius(radius);
            setBackgroundDrawable();
        }
    }

    public void setTopLeftRadius(float topLeftRadius){
        if (null != gradientDrawable) {
            radii = new float[]{topLeftRadius, topLeftRadius, 0, 0,
                    0, 0, 0, 0};
            gradientDrawable.setCornerRadii(radii);
            setBackgroundDrawable();
        }
    }

    public void setTopRightRadius(float topRightRadius){
        if (null != gradientDrawable) {
            radii = new float[]{0, 0, topRightRadius, topRightRadius,
                    0, 0, 0, 0};
            gradientDrawable.setCornerRadii(radii);
            setBackgroundDrawable();
        }
    }

    public void setBottomLeftRadius(float bottomLeftRadius){
        if (null != gradientDrawable) {
            radii = new float[]{0, 0, 0, 0,
                    0, 0, bottomLeftRadius, bottomLeftRadius};
            gradientDrawable.setCornerRadii(radii);
            setBackgroundDrawable();
        }
    }

    public void setBottomRightRadius(float bottomRightRadius){

        if (null != gradientDrawable) {
            radii = new float[]{0, 0, 0, 0,
                    bottomRightRadius, bottomRightRadius, 0, 0};
            gradientDrawable.setCornerRadii(radii);
            setBackgroundDrawable();
        }
    }

    public void setBackgroundColor(@ColorInt int color) {
        this.backgroundColor = color;
        if (null != gradientDrawable){
            gradientDrawable.setColor(color);
            setBackgroundDrawable();
        }
    }

    /**
     * Set GradientType in the GradientDrawable
     * @param gradient GradientDrawable {RECTANGLE,OVAL,LINE,RING}
     */
    public void setGradientType(int gradient){
        if (null != gradientDrawable){
            gradientDrawable.setGradientType(gradient);
            setBackgroundDrawable();
        }
    }

    @SuppressLint("WrongConstant")
    private void drawRoundDrawable() {
        Log.d(TAG, "drawRoundDrawable: "+cornesRadius);
        if (null == gradientDrawable) {
            return;
        }
        if (cornesRadius != 0) {
            gradientDrawable.setCornerRadius(cornesRadius);
            gradientDrawable.setGradientType(GradientDrawable.RECTANGLE);
        } else if (null != radii) {
            gradientDrawable.setCornerRadii(radii);
            gradientDrawable.setGradientType(GradientDrawable.RECTANGLE);
        }
        setBackgroundDrawable();
    }

    private void setBackgroundDrawable(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(gradientDrawable);
        }
    }

}
