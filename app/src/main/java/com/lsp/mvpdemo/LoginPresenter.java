package com.lsp.mvpdemo;

import android.text.TextUtils;

import com.lsp.mvpdemo.bean.User;

/**
 * Created by Kenney on 2017-09-29 17:39
 */

public class LoginPresenter implements LoginContract.Presenter, LoginModel.LoginCallback {

    private LoginContract.View loginView;
    private LoginModel loginModel;


    public LoginPresenter(LoginContract.View loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel(this);
        loginView.setPresenter(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void login() {
        String userName = loginView.getUserName();
        if(TextUtils.isEmpty(userName)){
            loginView.showToastWithShortLength("用户名不能为空");
            return ;
        }

        String pwd = loginView.getPassword();
        if(TextUtils.isEmpty(pwd)){
            loginView.showToastWithShortLength("密码不能为空");
            return ;
        }

        loginView.showLoadingDialog("正在登录...");
        loginModel.login(userName, pwd);
    }

    @Override
    public void loginSuccess(User user) {
        loginView.dismissLoadingDialog();
        loginView.showToastWithShortLength("登录成功");
    }

    @Override
    public void loginFailed(String msg) {
        loginView.dismissLoadingDialog();
        loginView.showToastWithShortLength(msg);
    }
}
