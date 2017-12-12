package com.lhc.lingshixiaozhenexpresss.request;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lhc.lingshixiaozhenexpresss.bean.Person;

import java.util.List;

import cn.bmob.v3.BmobQuery;

/**
 * Created by lhc on 17/12/12.
 */


/**
 * 使用例子
 */
public class SampleActivity extends AppCompatActivity{

    private RequestManager mRequestManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRequestManager=new RequestManager();

        Button cancel=new Button(this);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //手动取消请求
                mRequestManager.cancel();
            }
        });

    }

    private void query(){
        BmobQuery<Person> mPersonBmobQuery=new BmobQuery<>();
        mPersonBmobQuery.findObjects(query);
        mRequestManager.setCancelListener(query);

    }

    private FindListenerNew query=new FindListenerNew<Person>() {
        @Override
        public void onSuccess(List list) {

        }
    };




    /**
     * 在销毁activity的时候取消所有的请求回调
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRequestManager.clear();
    }
}
