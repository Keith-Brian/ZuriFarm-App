package com.DevKB.myzuri.data.viewModel

import androidx.lifecycle.ViewModel
import com.DevKB.myzuri.data.RetroInterface
import com.DevKB.myzuri.data.model.RetrofitCall
import com.DevKB.myzuri.data.model.RetrofitData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private lateinit var retrofitApi: RetrofitCall
private lateinit var retroCall: RetrofitCall

class RetrofitViewModel: ViewModel() {

    var temperature: String? =null
    var humidity: String? =null
    var moisture: String? =null
    var concentration: String? =null

    fun fetchData(){
        var retrofitApi = RetrofitCall.getInstance().create(RetroInterface::class.java)
        val retrofitCall = retrofitApi.getData().enqueue(object : Callback<RetrofitData?> {
            override fun onResponse(call: Call<RetrofitData?>, response: Response<RetrofitData?>) {
                val results = response.body()
                if (results!=null){
                    temperature = results.field1
                    humidity = results.field2.toString()
                    moisture = results.field3.toString()
                    concentration = results.field4.toString()
                }
            }

            override fun onFailure(call: Call<RetrofitData?>, t: Throwable) {

            }
        })
    }
}


