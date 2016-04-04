package com.example.alex.berich.ui.login;

import com.example.alex.berich.ui.base.MvpView;

/**
 * Created by Alex on 3/30/2016.
 */
public interface LoginMvpView extends MvpView {
    public void showFiledValidationFailed();
    public void showLoginFailed(String message);
    public void startMainActivity();

}
