package com.example.wallpaperapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/api")
    fun getDataRandom(
        @Query("key") key : String = "39283380-391834c9393fabd25f10a2ac1"
    ) : Call<ImagesResponse>

}