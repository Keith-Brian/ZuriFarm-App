package com.DevKB.myzuri.data.model

import com.DevKB.myzuri.data.model.RetrofitData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import kotlin.properties.Delegates

interface RetroInterface {

    var field: String
    var state: String
    var endpoint: String

    // Retrofit POST API https://api.thingspeak.com/update?api_key=FJ33Y1PVN6SPFG96&field1=0
    @GET("/channels/2130961/feeds/last.json?api_key=W39DE3LXTLMQOQAJ")
    fun getData(): Call<RetrofitData>

    @POST("update?api_key=FJ33Y1PVN6SPFG96&field1=$")
    fun pushData(@Body retrofitData: RetrofitData): Call<RetrofitData>

}