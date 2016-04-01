package com.example.alex.berich.ui.login;

/**
 * Created by Alex on 3/30/2016.
 */
public interface LoginMvpView {
    public void showFiledValidationFailed();
    public void showLoginFailed(String message);
    public void startMainActivity();

}
