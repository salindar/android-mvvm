package com.salinda.android_mvvm.domain;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.salinda.android_mvvm.data.model.RetrofitResponseWrapper;
import com.salinda.android_mvvm.data.repository.SampleRepository;
import com.salinda.android_mvvm.infrastructure.dto.busevent.NetworkOperationEvent;
import com.salinda.android_mvvm.presentation.App;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

/**
 * Created by Salinda Rathnayeka March 2021
 * salindakrishantha@gmail.com
 * <p>
 * Base ViewModel class to get inherited for child view models. EventBus initialization and dependency
 * injection are handled by this base class. However, every Fragment needs to inherit from BaseFragment
 * and every ViewModel needs inherit from BaseViewModel class to have all these features.
 */
public abstract class BaseViewModel extends ViewModel {
    @Inject
    EventBus bus;

    @Inject
    SampleRepository sampleRepo;
    protected MutableLiveData<Boolean> loading;

    public MutableLiveData<Boolean> getLoadingState() {
        if (loading == null) {
            loading = new MutableLiveData<>();
        }
        return loading;
    }


    public BaseViewModel() {
        super();
        /**
         * Base ViewModel will create the dependency tree for the application. Make sure dependency injection
         * is not called more than once due to the fact that higher memo
         * ry foot print
         */
        App.getApplicationComponent().inject(this);
        loading = new MutableLiveData<Boolean>();
    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }

    /**
     * ViewModel will receive data if the API request success. Data will be wrapped inside a
     * RetrofitResponseWrapper object to have sim
     *
     * @param retrofitResponseWrapper
     */
    @Subscribe
    public void onApiData(RetrofitResponseWrapper retrofitResponseWrapper) {
        onData(retrofitResponseWrapper);
    }

    @Subscribe
    public void onNetworkOperationEvent(NetworkOperationEvent networkOperationEvent) {
        loading.setValue(networkOperationEvent.isNetworkOperationInProgress());
    }

    /**
     * Child classes are responsible for handling API data appropriately
     *
     * @param retrofitResponseWrapper
     */
    protected abstract void onData(RetrofitResponseWrapper retrofitResponseWrapper);

    public void registerEventBus() {
        bus.register(this);
    }

    public void unRegisterEventBus() {
        bus.unregister(this);
    }
}