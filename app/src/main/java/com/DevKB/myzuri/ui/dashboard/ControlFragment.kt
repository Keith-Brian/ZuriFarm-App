package com.DevKB.myzuri.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import android.widget.Toast.*
import androidx.lifecycle.ViewModelProvider
import com.DevKB.myzuri.R
import com.DevKB.myzuri.data.viewModel.AdafruitViewModel
import com.DevKB.myzuri.databinding.FragmentControlBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ControlFragment : Fragment(R.layout.fragment_control) {
    private lateinit var controlBinding: FragmentControlBinding
    private lateinit var adafruitModel: AdafruitViewModel


    private var hour: String?= null
    private var min: String?= null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controlBinding = FragmentControlBinding.bind(view)
        adafruitModel = ViewModelProvider(this).get(AdafruitViewModel::class.java)

        //connect to the broker
        adafruitModel.connect(requireContext())


}}