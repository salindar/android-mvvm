package com.salinda.android_mvvm.data.repository;

import com.salinda.android_mvvm.data.api.core.APIResponseCallBack;
import com.salinda.android_mvvm.infrastructure.dto.busevent.NetworkOperationEvent;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
/**
 * Created by Salinda Rathnayeka May 2021
 * salindakrishantha@gmail.com
 * */
public class BaseRepository<A> {
    @Inject
    EventBus bus;

    public void execute(Call<A> call, APIResponseCallBack<A> callBack) {
        /*
        Notify the presentation layer via live data about network operation. So that presentation layer
        can update the UI to notify users.
         */
        bus.post(new NetworkOperationEvent(true));
        call.enqueue((Callback<A>) callBack);
    }
}
