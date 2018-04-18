package com.example.sisco.ayomileh;

import com.example.sisco.ayomileh.Model.CalonModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by LENOVO on 12/03/2018.
 */

public interface Server {

    @GET
    Call<CalonModel> getCalon(@Url String url);

}
