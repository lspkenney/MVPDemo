package com.lsp.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by Kenney on 2017-09-29 17:11
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewLayout());
        initViewsAndListeners();

        //mPresenter = initPresenter();

        if(mPresenter == null){
            Log.e(this.getClass().getSimpleName(), "mPresenter not init yet");
            return;
        }
        mPresenter.loadData();
    }

    public abstract int setContentViewLayout();
    public abstract void initViewsAndListeners();
    //public abstract T initPresenter();

    /*public <K extends View> K getView(int viewId){
        return (K) findViewById(viewId);
    }*/


}
