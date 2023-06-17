package com.DevKB.myzuri.data.viewModel

import androidx.lifecycle.ViewModel
import com.DevKB.myzuri.data.model.RetroInterface
import com.DevKB.myzuri.data.model.RetrofitCall
import com.DevKB.myzuri.data.model.RetrofitData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var retrofitApi: RetrofitCall
private lateinit var retroCall: RetrofitCall

class RetrofitViewModel: ViewModel() {

    var temperature: String? =""
    var humidity: String? =null
    var moisture: String? =null
    var concentration: String? =null


}


