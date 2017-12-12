package com.lhc.lingshixiaozhenexpresss.request;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by lhc on 2017/12/11.
 */

public abstract class UpdateListenerNew extends UpdateListener implements CancelListener {

    private boolean mIsCancel;

    @Override
    public void done(BmobException e) {
        if(mIsCancel){
            return;
        }
        if(e==null){
            onSuccess();
        }else{
            onError(e);
        }

    }

    @Override
    public void cancel() {
        mIsCancel=true;
    }


    public abstract void onSuccess();

    /**
     * 处理error 重写这个方法
     */
    public void onError(BmobException e){

    }
}
