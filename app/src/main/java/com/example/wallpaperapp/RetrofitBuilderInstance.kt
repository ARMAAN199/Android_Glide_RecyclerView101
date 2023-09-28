package com.example.wallpaperapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitBuilderInstance {
    lateinit var retrofitBuilderObject : ApiInterface;
    val BASE_URL = "https://pixabay.com";

     fun getRetrofitBuilder() : ApiInterface {
            if(::retrofitBuilderObject.isInitialized)
            {
                return retrofitBuilderObject;
            }
            retrofitBuilderObject = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiInterface::class.java)
            return retrofitBuilderObject;
    }
}
