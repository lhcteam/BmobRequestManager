package com.lhc.lingshixiaozhenexpresss.request;

import java.util.List;

import rx.Subscription;

/**
 * Created by lhc on 2017/12/11.
 */

public class RequestManager {

    private List<CancelListener> requests;

    /**
     * 依赖注入
     * @param cancelListener
     */
    public void setCancelListener(CancelListener cancelListener){
        requests.add(cancelListener);
    }

    /**
     * 取消一个请求
     */
    public void cancel(){
        requests.get(requests.size()-1).cancel();
        remove();
    }

    /**
     * 移除一个请求
     */
    public void remove(){
        requests.remove(requests.size()-1);
    }

    /**
     * 取消所有的请求并清空
     */
    public void clear(){
        for (int i = 0; i <requests.size() ; i++) {
            requests.get(i).cancel();
        }
        requests.clear();
    }

}
