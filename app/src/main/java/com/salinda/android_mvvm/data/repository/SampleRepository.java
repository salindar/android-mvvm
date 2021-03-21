package com.salinda.android_mvvm.data.repository;

import android.os.Bundle;

import com.salinda.android_mvvm.data.api.core.APIResponseCallBack;
import com.salinda.android_mvvm.data.api.core.RetrofitModule;
import com.salinda.android_mvvm.data.api.enpoint.SampleAPI;
import com.salinda.android_mvvm.data.model.SampleModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Sample implementation for a Repository.All repositories should have a getter method to provide the
 * Retrofit Call object and one or more getters to provide APIResponseCallBack objects.
 */
public class SampleRepository extends BaseRepository {
    @Inject
    public APIResponseCallBack<List<SampleModel>> sampleModelAPIResponseCallBack;

    @Inject
    EventBus bus;

    @Inject
    @Named("BASE_URL")
    String baseUrl;

    private SampleAPI api;

    @Inject
    public SampleRepository(RetrofitModule<SampleAPI> retrofitModule, @Named("BASE_URL") String baseUrl) {
        Bundle bundle = new Bundle();
        bundle.putString("Content-Type", "application/json");
        api = retrofitModule.getRestClient(SampleAPI.class, null, bundle, baseUrl);
    }

    /**
     * Return the API object for the execute method. Use same approach for the future development
     * in order to compatible with the framework
     * @return
     */
    public SampleAPI getApi(){
        return api;
    }

    /**
     * Return the Retrofit CallBack  object for the execute method. Use same approach for the future development
     * in order to compatible with the framework.
     * @return
     */
    public APIResponseCallBack getSampleApiResponseCallback(){
        return sampleModelAPIResponseCallBack;
    }
}
