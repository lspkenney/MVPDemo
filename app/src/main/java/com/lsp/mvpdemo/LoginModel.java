package com.lsp.mvpdemo;

import android.os.Handler;
import android.os.Message;

import com.lsp.mvpdemo.bean.User;

import java.util.Random;


/**
 * Created by Kenney on 2017-10-13 15:20
 */

public class LoginModel {

    private LoginCallback listener;

    public LoginModel(LoginCallback listener) {
        this.listener = listener;
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    public void login(final String username, final String pwd){
        //模拟登录网络请求
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                int nextInt = random.nextInt(2);
                if(nextInt == 1){
                    listener.loginSuccess(new User(username, pwd, 20));
                }else{
                    listener.loginFailed("用户名或密码不正确");
                }
            }
        }, 3000);
    }

    public interface LoginCallback{
        void loginSuccess(User user);
        void loginFailed(String msg);
    }
}
