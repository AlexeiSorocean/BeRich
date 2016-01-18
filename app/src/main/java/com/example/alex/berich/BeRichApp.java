package com.example.alex.berich;

import android.app.Application;
import android.content.Context;

/**
 * Created by alex on 1/17/16.
 */
public class BeRichApp extends Application {


    static Context appContext;


    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }

    static public Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context appContext) {
        this.appContext = appContext;
    }


}
