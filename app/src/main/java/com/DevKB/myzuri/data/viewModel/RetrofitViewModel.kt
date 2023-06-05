package com.DevKB.myzuri.data.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.DevKB.myzuri.data.model.RetrofitCall
import retrofit2.create
import java.util.Objects

private lateinit var retrofitApi: RetrofitCall

class RetrofitViewModel: ViewModel() {
    var temperature: String? =null
    var humidity: String? =null
    var moisture: String? =null
    var concentration: String? =null
}


