package com.example.alex.berich.ui.login;

import com.example.alex.berich.ui.base.Presenter;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by Alex on 3/30/2016.
 */
public class LoginPresenter implements Presenter <LoginMvpView>{

    LoginMvpView loginMvpView;

    @Override
    public void attachView(LoginMvpView loginMvpView) {

    }

    @Override
    public void detachView() {

    }

    public boolean isViewAttached() {
        return loginMvpView != null;
    }

    public LoginMvpView getMvpView() {
        return loginMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }

    public void checkUserImput(String username, String password) {
        username = username.trim();
        password = password.trim();

        if (username.isEmpty() || password.isEmpty()) {
            loginMvpView.showFiledValidationFailed();
        }
        else {
            // Login
            ParseUser.logInInBackground(username, password, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if (e == null) {
                        loginMvpView.startMainActivity();
                    } else {
                        loginMvpView.showLoginFailed(e.getMessage());
                    }
                }
            });
        }
    }
}
