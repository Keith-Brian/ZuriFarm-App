package com.DevKB.myzuri.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.DevKB.myzuri.R
import com.DevKB.myzuri.data.model.RetroInterface
import com.DevKB.myzuri.data.model.RetrofitCall
import com.DevKB.myzuri.data.model.RetrofitData
import com.DevKB.myzuri.data.viewModel.RetrofitViewModel
import com.DevKB.myzuri.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var monitorBinding: FragmentHomeBinding
    private lateinit var retrofitViewModel: RetrofitViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        monitorBinding = FragmentHomeBinding.bind(view)

        retrofitViewModel = ViewModelProvider(this).get(RetrofitViewModel::class.java)
        monitorBinding.refreshLayout.setOnRefreshListener {
            fetchData()
        }

        fetchData()
    }

    private fun fetchData() {
        val retrofitBuilder = RetrofitCall.getInstance().create(RetroInterface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<RetrofitData?> {
            override fun onResponse(call: Call<RetrofitData?>, response: Response<RetrofitData?>) {
                monitorBinding.refreshLayout.isRefreshing = false
                var results = response.body()

                if(results!=null){
                    retrofitViewModel.temperature = results.field1
                    monitorBinding.temp.text = retrofitViewModel.temperature
                }
            }

            override fun onFailure(call: Call<RetrofitData?>, t: Throwable) {
                println("Retrofit Call failed!")
                monitorBinding.refreshLayout.isRefreshing = false
            }
        })
    }
}