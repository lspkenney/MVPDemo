package com.lsp.mvpdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatDialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lsp.mvpdemo.base.BaseActivity;
import com.lsp.mvpdemo.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements OnClickListener , LoginContract.View{
    private EditText et_name, et_pwd;
    private Button btn_login;
    private ProgressDialog dialog;

    @Override
    public int setContentViewLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initViewsAndListeners() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);

        new LoginPresenter(this);
        dialog = new ProgressDialog(this);
    }

    @Override
    public void onClick(View view) {
        mPresenter.login();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showLoadingDialog(String msg) {
        dialog.setMessage(msg);
        if(!isFinishing() && !dialog.isShowing()){
            dialog.show();
        }
    }

    @Override
    public void dismissLoadingDialog() {
        if(dialog.isShowing()){
            dialog.dismiss();
        }
    }

    @Override
    public String getUserName() {
        return et_name.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return et_pwd.getText().toString().trim();
    }

    @Override
    public void showToastWithShortLength(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

