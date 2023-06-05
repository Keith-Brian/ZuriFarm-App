package com.DevKB.myzuri.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.DevKB.myzuri.R
import com.DevKB.myzuri.data.model.RetrofitCall
import com.DevKB.myzuri.data.model.retfrofitData
import com.DevKB.myzuri.data.retrofitInterface
import com.DevKB.myzuri.data.viewModel.RetrofitViewModel
import com.DevKB.myzuri.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.id.homeFragment) {
     private lateinit var homeBinding: FragmentHomeBinding
     lateinit var retrofitViewModel: RetrofitViewModel
     private lateinit var data: retfrofitData

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeBinding = FragmentHomeBinding.bind(view)

        retrofitViewModel = ViewModelProvider(this).get(RetrofitViewModel::class.java)

        homeBinding.refreshLayout.setOnRefreshListener {
            fetchData()
        }

        fetchData()
}

    private fun fetchData() {
        val retrofitApi = RetrofitCall.getInstance().create(retrofitInterface::class.java)
        val retrofitCall = retrofitApi.getData()

        retrofitCall.enqueue(object : Callback<retfrofitData?> {
            override fun onResponse(
                call: Call<retfrofitData?>,
                response: Response<retfrofitData?>
            ) {
                data = response.body()!!
                homeBinding.refreshLayout.isRefreshing = false
                if(data != null){
                    updateViewModel()

                    homeBinding.temp.text = retrofitViewModel.temperature.toString()
                    homeBinding.humi.text = retrofitViewModel.humidity.toString()
                    homeBinding.moist.text = retrofitViewModel.moisture.toString()
                    homeBinding.concentration.text = retrofitViewModel.concentration.toString()

                }
            }

            override fun onFailure(call: Call<retfrofitData?>, t: Throwable) {
                homeBinding.refreshLayout.isRefreshing = false
            }
        })


    }

    private fun updateViewModel() {
        retrofitViewModel.temperature = data.field1.toString()
        retrofitViewModel.humidity = data.field2.toString()
        retrofitViewModel.moisture = data.field3.toString()
        retrofitViewModel.concentration = data.field4.toString()
    }
}
