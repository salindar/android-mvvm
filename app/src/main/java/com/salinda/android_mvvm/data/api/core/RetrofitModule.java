package com.salinda.android_mvvm.data.api.core;

import android.os.Bundle;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Salinda Rathnayeka May 2021
 * salindakrishantha@gmail.com
 */
//TODO add class level javadoc
public class RetrofitModule<T> {
    @Inject
    public RetrofitModule() {

    }

    private RequestInterceptor requestInterceptor;

    public T getRestClient(Class<T> t, Gson gson, Bundle bundle,String apiUrl) {
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(apiUrl);
        builder.addConverterFactory(GsonConverterFactory.create());
        /*
        Bundle available means there are some headers to be added to the request.
        This is only possible with adding interceptor to the OkHttpClient and add that
        OkHttpClient object to the Retrofit.Builder
         */
        if (bundle != null) {
            if (requestInterceptor == null) {
                requestInterceptor = new RequestInterceptor();
            }
            requestInterceptor.setBundle(bundle);
            //OK HTTP
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(requestInterceptor).build();
            builder.client(okHttpClient);
        }
        Retrofit retrofit = builder.build();
        return retrofit.create(t);
    }

}
