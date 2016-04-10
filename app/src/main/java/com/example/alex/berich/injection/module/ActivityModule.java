package com.example.alex.berich.injection.module;

import android.app.Activity;
import android.content.Context;

import com.example.alex.berich.injection.ActivityContext;
import com.example.alex.berich.ui.login.LoginPresenter;
import com.example.alex.berich.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }


    @Provides
    LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
}
