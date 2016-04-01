package com.example.alex.berich.injection.component;

import com.example.alex.berich.activities.MainActivity;
import com.example.alex.berich.injection.PerActivity;
import com.example.alex.berich.injection.module.ApplicationModule;
import com.example.alex.berich.ui.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ApplicationModule.class})
public interface ApplicationComponent {
   void inject(MainActivity activity);
   // void inject(MyFragment fragment);
   // void inject(MyService service);
}