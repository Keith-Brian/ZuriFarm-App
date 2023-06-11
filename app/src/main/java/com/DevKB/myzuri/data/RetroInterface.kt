package com.DevKB.myzuri.data

import com.DevKB.myzuri.data.model.RetrofitData
import retrofit2.Call
import retrofit2.http.GET

interface RetroInterface {
    @GET("/channels/2130961/feeds/last.json?api_key=W39DE3LXTLMQOQAJ")
    fun getData(): Call<RetrofitData>
}