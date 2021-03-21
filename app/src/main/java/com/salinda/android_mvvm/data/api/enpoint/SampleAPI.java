package com.salinda.android_mvvm.data.api.enpoint;
import com.salinda.android_mvvm.data.model.SampleModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Salinda Rathnayeka May 2021
 * salindakrishantha@gmail.com
 * Define all the endpoints, data for the API and return types of the API.
 * All these models need to be GSON serialized class extended from BaseModel
 */
public interface SampleAPI {
    /**
     * Sample HTTP get call to placeholder API endpoint
     * @return
     */
    @GET("/users")
    Call<List<SampleModel>> getUsers();
}
