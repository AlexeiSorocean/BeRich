package com.example.alex.berich.ui.base;

import android.support.v7.app.AppCompatActivity;

import com.example.alex.berich.BeRichApp;
import com.example.alex.berich.injection.component.ActivityComponent;

import com.example.alex.berich.injection.component.DaggerActivityComponent;
import com.example.alex.berich.injection.module.ActivityModule;

/**
 * Created by Alex on 4/1/2016.
 */
public class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;



    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(BeRichApp.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }
}
