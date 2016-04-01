package com.example.alex.berich.injection.component;

import com.example.alex.berich.activities.MainActivity;
import com.example.alex.berich.injection.PerActivity;
import com.example.alex.berich.injection.module.ActivityModule;
import com.example.alex.berich.ui.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
