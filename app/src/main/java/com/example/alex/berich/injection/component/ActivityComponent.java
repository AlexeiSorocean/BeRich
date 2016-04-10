package com.example.alex.berich.injection.component;

import com.example.alex.berich.injection.PerActivity;
import com.example.alex.berich.injection.module.ActivityModule;
import com.example.alex.berich.injection.module.ApplicationModule;
import com.example.alex.berich.ui.login.LoginActivity;
import com.example.alex.berich.ui.login.LoginPresenter;
import com.example.alex.berich.ui.main.MainActivity;
import com.example.alex.berich.ui.main.MainPresenter;

import dagger.Component;

@PerActivity
@Component(modules = {ApplicationModule.class, ActivityModule.class})
public interface ActivityComponent {

    void inject(LoginActivity mainActivity);
    void inject(LoginPresenter loginPresenter);
    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);

}
