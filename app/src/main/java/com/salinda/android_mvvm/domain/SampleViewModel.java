package com.salinda.android_mvvm.domain;

import androidx.lifecycle.MutableLiveData;

import com.salinda.android_mvvm.data.model.RetrofitResponseWrapper;
import com.salinda.android_mvvm.data.model.SampleModel;

import java.util.List;

/**
 * Created by Salinda Rathnayeka March 2021
 * salindakrishantha@gmail.com
 */
public class SampleViewModel extends BaseViewModel {
    private MutableLiveData<List<SampleModel>> sampleList;

    public MutableLiveData<List<SampleModel>> getSampleList() {
        if (sampleList == null) {
            sampleList = new MutableLiveData<List<SampleModel>>();
        }
        return sampleList;
    }


    public void getData() {
        sampleRepo.execute(sampleRepo.getApi().getUsers(), sampleRepo.getSampleApiResponseCallback());
    }

    public SampleViewModel() {
        super();
    }

    /**
     * Child classes are responsible for handling API data appropriately
     *
     * @param retrofitResponseWrapper
     */
    protected void onData(RetrofitResponseWrapper retrofitResponseWrapper) {
        if (retrofitResponseWrapper != null && retrofitResponseWrapper.getRetrofitResponse() != null &&
                retrofitResponseWrapper.getRetrofitResponse().body() instanceof List) {
            List<SampleModel> sampleModelList = ((List<SampleModel>) retrofitResponseWrapper.getRetrofitResponse().body());
            sampleList.setValue(sampleModelList);
        }

    }
}