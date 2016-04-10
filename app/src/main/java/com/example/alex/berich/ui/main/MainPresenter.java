package com.example.alex.berich.ui.main;

import android.util.Log;

import com.example.alex.berich.ui.base.BasePresenter;
import com.parse.ParseUser;

/**
 * Created by Alex on 4/4/2016.
 */
public class MainPresenter extends BasePresenter<MainMvpView> {

    private static final String TAG = "MainPresenter";
    MainMvpView mainMvpView;

    public void onLoginRequired() {
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            mainMvpView.showLoginScreen();
        }
        else {
            Log.i(TAG, currentUser.getUsername());
        }
    }


}
