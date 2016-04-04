package com.example.alex.berich.injection.component;

import android.app.Application;
import android.content.Context;

import com.example.alex.berich.activities.MainActivity;
import com.example.alex.berich.injection.ApplicationContext;
import com.example.alex.berich.injection.PerActivity;
import com.example.alex.berich.injection.module.ApplicationModule;
import com.example.alex.berich.ui.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ApplicationModule.class})
public interface ApplicationComponent {

    @ApplicationContext Context getContext();


}