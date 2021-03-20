package com.salinda.android_mvvm.domain;

import androidx.lifecycle.ViewModel;

import com.salinda.android_mvvm.data.api.enpoint.ApiExecutor;
import com.salinda.android_mvvm.presentation.App;

import javax.inject.Inject;

public class BaseViewModel extends ViewModel {
    @Inject
    ApiExecutor apiExecutor;


    public void initializeDependencyTree() {
        App.getApplicationComponent().inject(this);
    }

    public BaseViewModel(){
        super();
        /**
         * Base ViewModel will create the dependency tree for the application. Make sure dependency injection
         * is not called more than once due to the fact that higher memo
         * ry foot print
         */
        App.getApplicationComponent().inject(this);
    }
    @Override
    protected void onCleared() {
        super.onCleared();
    }
    public void getData(){
        apiExecutor.executeSampleApiRequest();
    }
}