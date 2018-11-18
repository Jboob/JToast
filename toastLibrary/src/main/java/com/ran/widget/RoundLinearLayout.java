package com.ran.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
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

    public RoundLinearLayout(Context context) {
        super(context);

    }

    public RoundLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public RoundLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public void init(Context context, @Nullable AttributeSet attrs){
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.RoundLayout);
        this.cornesRadius = (float) arr.getInt(R.styleable.RoundLayout_radius, 0);
        if (cornesRadius == 0) {
            float topLeftRadius = (float) arr.getInt(R.styleable.RoundLayout_topLeftRadius, 0);
            float topRightRadius = arr.getFloat(R.styleable.RoundLayout_topRightRadius, 0);
            float bottomLeftRadius = arr.getFloat(R.styleable.RoundLayout_bottomLeftRadius, 0);
            float bottomRightRadius = arr.getFloat(R.styleable.RoundLayout_bottomRightRadius, 0);
            radii = new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius,
                    bottomLeftRadius, bottomLeftRadius, bottomRightRadius, bottomRightRadius};
        }
        drawRoundDrawable();
        arr.recycle();
    }

    public void setRadius(float radius){
        this.cornesRadius = radius;
    }

    private void drawRoundDrawable() {
        GradientDrawable drawable = null;

        if (cornesRadius != 0) {
            drawable = new GradientDrawable();
            drawable.setColor(Color.GRAY);
            drawable.setCornerRadius(cornesRadius);
            drawable.setGradientType(GradientDrawable.RECTANGLE);
        }else if (null != radii){
            drawable = new GradientDrawable();
            drawable.setColor(Color.GRAY);
            drawable.setCornerRadii(radii);
            drawable.setGradientType(GradientDrawable.RECTANGLE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if (null != drawable)
                setBackground(drawable);
        }
    }
}