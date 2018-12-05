package com.ran.toast;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.IdRes;

import com.ran.creator.CustomToastCreator;
import com.ran.creator.SystemToastCreator;
import com.ran.toast.base.BaseToast;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Ran
 * @date 2018/11/15.
 */

public class JToast {

    private String TAG = "JToast";

    private static volatile JToast INSTANCE = null;

    //Toast default show time.
    private static final long DEFAULT_SHOW_TIME = 2000;

    private Map<Integer, ToastRunnable> RUNNABLES = new HashMap<>();

    private Map<Integer, CharSequence> TEXTS = new HashMap<>();

    private Context mContext;
    private Handler mHander;

    private ToastRunnable runnable;
    private CharSequence text = "text";
    private SystemToast systemToast;
    private CustomToast customToast;

    private JToast() {

    }

    private JToast(Context context) {
        if (isNull(mHander)) {
            mHander = new Handler();
        }
        this.mContext = context;
    }

    private JToast customBuilder(CustomToastBuilder builder) {
        this.text = builder.text;
        initCustomToast(builder);
        return INSTANCE;
    }

    private JToast systemBuilder(SystemToastBuilder builder) {
        this.text = builder.text;
        initSystemToast(builder);
        return INSTANCE;
    }

    public synchronized static JToast getInstance(Context ctx) {
        if (INSTANCE == null) {
            synchronized (JToast.class) {
                if (INSTANCE == null) {
                    INSTANCE = new JToast(ctx);
                }
            }
        }
        return INSTANCE;
    }

    private void initCustomToast(CustomToastBuilder builder) {
        runnable = RUNNABLES.get(text.hashCode());
        if (isNull(runnable)) {
            customToast = new CustomToast(mContext);
            runnable = new ToastRunnable(customToast);
            RUNNABLES.put(text.hashCode(), runnable);
            long showTime = builder.showTime;
            if (showTime > DEFAULT_SHOW_TIME){
                mHander.postDelayed(runnable, showTime);
            }else {
                mHander.postDelayed(runnable, DEFAULT_SHOW_TIME);
            }
            customToast.show(builder.customToastCreator,builder.text,builder.textResId,builder.gravity);
        }
    }

    private void initSystemToast(SystemToastBuilder builder) {
        runnable = RUNNABLES.get(text.hashCode());
        if (isNull(runnable)) {
            systemToast = new SystemToast(mContext);
            runnable = new ToastRunnable(systemToast);
            RUNNABLES.put(text.hashCode(), runnable);
            long showTime = builder.showTime;
            if (showTime > DEFAULT_SHOW_TIME){
                mHander.postDelayed(runnable, showTime);
            }else {
                mHander.postDelayed(runnable, DEFAULT_SHOW_TIME);
            }
            systemToast.show(builder.systemToastCreator, text);
        }
    }

    public static ToastBuilder build() {
        return new ToastBuilder();
    }

    public void show(CharSequence text) {
        if (!text.equals(TEXTS.get(text.hashCode()))) {
            TEXTS.put(text.hashCode(), text);
            systemToast = new SystemToast(mContext);
            runnable = new ToastRunnable(systemToast);
            mHander.postDelayed(runnable, DEFAULT_SHOW_TIME);
            systemToast.show(text);
        }
    }

    public static class ToastBuilder {

        public ToastBuilder() {
        }

        public SystemToastBuilder systemToastBuilder() {
            return new SystemToastBuilder();
        }

        public CustomToastBuilder customToastBuilder() {
            return new CustomToastBuilder();
        }
    }

    public static class CustomToastBuilder {

        private CustomToastCreator customToastCreator;
        private long showTime;
        private CharSequence text = "text";
        private int textResId;
        private int gravity = -1;

        public CustomToastBuilder setToastCreator(CustomToastCreator creator) {
            if (null == creator) {
                throw new NullPointerException("Creator is not null!");
            }
            this.customToastCreator = creator;
            return this;
        }

        public CustomToastBuilder setText(CharSequence text, @IdRes int resId) {
            this.text = text;
            this.textResId = resId;
            return this;
        }

        /**
         * Set the location at which the notification should appear on the screen.
         * @see android.view.Gravity
         */
        public CustomToastBuilder setGravity(int gravity){
            this.gravity = gravity;
            return this;
        }

        public CustomToastBuilder setShowTime(long time) {
            this.showTime = time;
            return this;
        }

        public JToast show(Context ctx) {
            return getInstance(ctx).customBuilder(this);
        }
    }

    public static class SystemToastBuilder {

        private SystemToastCreator systemToastCreator;
        private long showTime;
        private CharSequence text;

        public SystemToastBuilder setToastCreator(SystemToastCreator creator) {
            if (null == creator) {
                throw new NullPointerException("Creator is not null!");
            }
            this.systemToastCreator = creator;
            return this;
        }

        public SystemToastBuilder setText(CharSequence text) {
            this.text = text;
            return this;
        }

        public SystemToastBuilder setShowTime(long time) {
            this.showTime = time;
            return this;
        }

        public JToast show(Context ctx) {
            return getInstance(ctx).systemBuilder(this);
        }
    }

    private class ToastRunnable implements Runnable {

        private BaseToast toast;

        public ToastRunnable(BaseToast toast) {
            this.toast = toast;
        }

        @Override
        public void run() {
            toast.cancel();
            TEXTS.remove(toast.getText().hashCode());
            RUNNABLES.remove(toast.getText().hashCode());
            toast = null;
            runnable = null;
        }
    }

    protected void destroy() {
//        TEXTS.remove(text.hashCode());
//        RUNNABLES.remove(text.hashCode());
//        if (RUNNABLES.size() == 0) {
//            mHander = null;
//            RUNNABLES = null;
//        }

    }

    private <T> boolean isNull(T t) {
        if (null != t) {
            return false;
        }
        return true;
    }


}
