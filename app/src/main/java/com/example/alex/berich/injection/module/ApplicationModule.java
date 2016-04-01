package com.example.alex.berich.injection.module;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Context appContext;

    public ApplicationModule(@NonNull Context context) {
        appContext = context;
    }

    @Provides
    @Singleton
    Context providesApplication() {
        return appContext;
    }
}