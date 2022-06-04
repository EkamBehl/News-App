package com.example.newaapp;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitApi extends Serializable {
    @GET
    Call<NewsModel> getAllNews(@Url String url);
    //@GET
    //Call<NewsModel> getTopsNews(@Url String url);
}
