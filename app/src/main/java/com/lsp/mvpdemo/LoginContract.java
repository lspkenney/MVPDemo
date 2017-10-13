package com.lsp.mvpdemo;

import com.lsp.mvpdemo.base.BasePresenter;
import com.lsp.mvpdemo.base.BaseView;

/**
 * Created by Kenney on 2017-09-29 17:04
 */

public interface LoginContract {
    interface View extends BaseView<Presenter>{
        void showLoadingDialog(String msg);
        void dismissLoadingDialog();
        String getUserName();
        String getPassword();
    }

    interface Presenter extends BasePresenter{
        void login();
    }
}
