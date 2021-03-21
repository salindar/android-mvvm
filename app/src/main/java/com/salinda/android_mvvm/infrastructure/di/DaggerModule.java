package com.salinda.android_mvvm.infrastructure.di;
import org.greenrobot.eventbus.EventBus;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Application wide Dagger module for dependency injection.
 * Mention all dependencies that requires special functionality to create dependency
 */
@Module
public class DaggerModule {

    /**
     * Provides EvenBus singleton instance to the application
     * @return
     */
    @Provides
    @Singleton
    static EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Named("BASE_URL")
    static String provideBaseUrl() {
        /**
         * TODO fetch this value from configs based on selected flavour and build type
         */
        return "https://jsonplaceholder.typicode.com/";
    }

}
