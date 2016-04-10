package com.example.alex.berich.injection.component;

import android.content.Context;

import com.example.alex.berich.injection.ApplicationContext;
import com.example.alex.berich.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ApplicationModule.class})
public interface ApplicationComponent {

    @ApplicationContext Context getContext();


}