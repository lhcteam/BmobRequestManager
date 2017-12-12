package com.lhc.lingshixiaozhenexpresss.request;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by lhc on 17/12/12.
 */

public abstract class SaveListenerNew extends SaveListener<String> implements CancelListener{
    private boolean mIsCancel;
    @Override
    public void done(String objectId, BmobException e) {
        if(mIsCancel){
            return;
        }
        if(e==null){
            onSuccess(objectId);
        }else{
            onError(e);
        }
    }

    @Override
    public void cancel() {
        mIsCancel=true;
    }

    public abstract void onSuccess(String objectId);

    /**
     * 处理error 重写这个方法
     */
    public void onError(BmobException e){

    }
}
