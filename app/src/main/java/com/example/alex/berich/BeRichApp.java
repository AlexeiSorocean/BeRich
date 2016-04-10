package com.example.alex.berich;

import android.app.Application;
import android.content.Context;


import com.example.alex.berich.injection.ApplicationContext;
import com.example.alex.berich.injection.component.ApplicationComponent;


import com.example.alex.berich.injection.component.DaggerApplicationComponent;
import com.example.alex.berich.injection.module.ApplicationModule;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

/**
 * Created by alex on 1/17/16.
 */
public class BeRichApp extends Application {



    ApplicationComponent mApplicationComponent;

    static Context appContext;


    @Override
    public void onCreate() {
        Parse.initialize(this, "YYESkJacgOqhnzTqcCS0G3JbEPo6jGnlHsL1wDaH", "Yx1ussY2sW3JnRR1OmR9NpBEzklTnAxIy1tL0jw1");
        //ParseObject.registerSubclass(ParseMonthItem.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        super.onCreate();
        appContext = getApplicationContext();
    }

    static public Context getAppContext() {
        return appContext;
    }

    public void setAppContext(@ApplicationContext Context appContext) {
        this.appContext = appContext;
    }

    public static BeRichApp get(@ApplicationContext Context context) {
        return (BeRichApp) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }


}
