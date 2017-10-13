package com.lsp.mvpdemo.base;

/**
 * Created by Kenney on 2017-09-29 16:58
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
    void showToastWithShortLength(String msg);
}
