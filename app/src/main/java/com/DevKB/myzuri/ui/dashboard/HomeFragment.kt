package com.DevKB.myzuri.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.DevKB.myzuri.R
import com.DevKB.myzuri.data.viewModel.AdafruitViewModel
import com.DevKB.myzuri.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var monitorBinding: FragmentHomeBinding
    private lateinit var adafruitViewModel: AdafruitViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        monitorBinding = FragmentHomeBinding.bind(view)

        adafruitViewModel = ViewModelProvider(this).get(AdafruitViewModel::class.java)
        //connecting to the server option
        adafruitViewModel.connect(requireContext())
       // adafruitViewModel.subscribe("temp")

        adafruitViewModel.temp().observe(requireActivity(), Observer {
            monitorBinding.temp.text = it
        })

        adafruitViewModel.humi().observe(requireActivity(), Observer {
            monitorBinding.humid.text = it
        })

        adafruitViewModel.conc().observe(requireActivity(), Observer {
            monitorBinding.concen.text = it
        })

        adafruitViewModel.moist().observe(requireActivity(), Observer {
            monitorBinding.moist.text = it
        })

        monitorBinding.refreshLayout.setOnRefreshListener {
            monitorBinding.temp.text = adafruitViewModel.email.toString()
            monitorBinding.refreshLayout.isRefreshing = false
        }

        monitorBinding.temp.text = adafruitViewModel.email.toString()

    }
}


