package com.salinda.android_mvvm.data.api.core;

import com.salinda.android_mvvm.data.model.RetrofitResponseWrapper;
import com.salinda.android_mvvm.infrastructure.dto.busevent.NetworkOperationEvent;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Salinda Rathnayeka May 2021
 * salindakrishantha@gmail.com
 */
//TODO add class level javadoc
public class APIResponseCallBack<T> implements Callback<T> {
    /**
     * Dagger does not support injection into private fields
     */
    @Inject
    public EventBus bus;

    private int requestCode = 0;


    public int getRequestCode() {
        return requestCode;
    }
    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    @Inject
    public <T> APIResponseCallBack(){}

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        bus.post(new NetworkOperationEvent(false));

        if (response.isSuccessful()) {
            bus.post(new RetrofitResponseWrapper<T>(response, requestCode));
        } else {
            RetrofitErrorWrapper retrofitErrorWrapper = new RetrofitErrorWrapper(null);
            retrofitErrorWrapper.setRequestCode(requestCode);
            retrofitErrorWrapper.setResponse(response);
           bus.post(retrofitErrorWrapper);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        bus.post(new NetworkOperationEvent(false));

        RetrofitErrorWrapper retrofitErrorWrapper = new RetrofitErrorWrapper(t);
        retrofitErrorWrapper.setRequestCode(requestCode);
        retrofitErrorWrapper.setThrowable(t);
        bus.post(retrofitErrorWrapper);
    }
}
