package com.example.alex.berich.ui.singup;

import com.example.alex.berich.ui.base.MvpView;

/**
 * Created by Alex on 4/4/2016.
 */
public interface SignUpMvpView  extends MvpView {
    public void showFiledValidationFailed();
    public void showSignUpFailed(String message);
    public void startMainActivity();
}
