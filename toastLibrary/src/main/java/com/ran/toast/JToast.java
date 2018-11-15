package com.ran.toast;

import android.content.Context;
import android.os.Handler;

import com.ran.creator.CustomToastCreator;
import com.ran.creator.SystemToastCreator;
import com.ran.creator.base.BaseToastCreator;


/**
 * @author Ran
 * @date 2018/11/15.
 */

public class JToast {


    private Context mContext;
    private Handler mHander;
    private SystemToastCreator systemToastCreator;
    private CustomToastCreator customToastCreator;

    public void init(Context ctx){
        mHander = new Handler();
    }

    //TODO Creator go to builder.
    public void setToastCreator(BaseToastCreator creator){
        if (isNull(creator)){
            throw new NullPointerException("Creator is not null!");
        }
        if (creator instanceof SystemToastCreator){
            systemToastCreator = (SystemToastCreator) creator;

        }
    }

    public void show(){

    }
    //TODO Creator go to builder.
    
    public void show(CharSequence content){

    }

    private <T> boolean isNull(T t) {
        if (null != t) {
            return false;
        }
        return true;
    }

}
