package com.lhc.lingshixiaozhenexpresss.request;

import java.util.List;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by lhc on 17/12/12.
 */

public abstract class FindListenerNew<T> extends FindListener<T> implements CancelListener {

    private boolean mIsCancel;

    @Override
    public void done(List<T> list, BmobException e) {
        if(mIsCancel){
            return;
        }
        if(e==null){
            onSuccess(list);
        }else{
            onError(e);
        }
    }

    @Override
    public void cancel() {
        mIsCancel=true;
    }

    public abstract void onSuccess(List<T> list);

    /**
     * 处理error 重写这个方法
     */
    public void onError(BmobException e){

    }
}
