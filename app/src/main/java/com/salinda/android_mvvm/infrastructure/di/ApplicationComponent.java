package com.salinda.android_mvvm.infrastructure.di;

import com.salinda.android_mvvm.domain.BaseViewModel;
import com.salinda.android_mvvm.presentation.App;
import com.salinda.android_mvvm.presentation.fragment.MainFragment;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
/*
In order to use Singleton on providers Component must be Singleton
 */
@Singleton
@Component(modules = { AndroidInjectionModule.class, DaggerModule.class})
public interface ApplicationComponent extends AndroidInjector<App> {
    void inject(BaseViewModel viewModel);
}
