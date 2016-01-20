package com.example.alex.berich;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;

/**
 * Created by alex on 1/17/16.
 */
public class BeRichApp extends Application {


    static Context appContext;


    @Override
    public void onCreate() {
        Parse.initialize(this, "YYESkJacgOqhnzTqcCS0G3JbEPo6jGnlHsL1wDaH", "Yx1ussY2sW3JnRR1OmR9NpBEzklTnAxIy1tL0jw1");

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
