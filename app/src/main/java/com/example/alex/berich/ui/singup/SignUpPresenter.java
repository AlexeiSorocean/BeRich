package com.example.alex.berich.ui.singup;

import com.example.alex.berich.ui.base.BasePresenter;
import com.example.alex.berich.ui.login.LoginMvpView;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by Alex on 4/4/2016.
 */
public class SignUpPresenter extends BasePresenter<SignUpMvpView> {

    SignUpMvpView signUpMvpView;

    @Override
    public void attachView(SignUpMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public boolean isViewAttached() {
        return signUpMvpView != null;
    }

    public SignUpMvpView getMvpView() {
        return signUpMvpView;
    }


    public void signUp(String username, String password, String email) {
        username = username.trim();
        password = password.trim();
        email = email.trim();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            signUpMvpView.showFiledValidationFailed();
        }
        else {
            // Login
            ParseUser.logInInBackground(username, password, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if (e == null) {
                        signUpMvpView.startMainActivity();
                    } else {
                        signUpMvpView.showSignUpFailed(e.getMessage());
                    }
                }
            });
        }
    }

}
