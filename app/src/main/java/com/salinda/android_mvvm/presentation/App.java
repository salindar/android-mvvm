package com.salinda.android_mvvm.presentation;

import android.app.Application;

import com.salinda.android_mvvm.infrastructure.di.ApplicationComponent;
import com.salinda.android_mvvm.infrastructure.di.DaggerApplicationComponent;


public class App extends Application  {
    private static ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * Dagger adds Dagger prefix to the ApplicationComponent. Here Dagger creates the dependency graph
         * and appComponent instance is preserved for the lifetime of the application as it creates a whole new
         * dependency graph if we call create() again.
         */
         appComponent = DaggerApplicationComponent.create();
    }
    public static ApplicationComponent getApplicationComponent(){
        return appComponent;
    }
}
