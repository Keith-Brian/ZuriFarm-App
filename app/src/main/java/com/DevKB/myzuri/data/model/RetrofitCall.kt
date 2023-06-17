package com.DevKB.myzuri.data.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCall{

    private const val baseURL = "https://api.thingspeak.com/"

    fun getInstance():Retrofit{
        return Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}