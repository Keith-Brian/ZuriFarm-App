package com.DevKB.myzuri.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.DevKB.myzuri.R
import com.DevKB.myzuri.data.viewModel.AdafruitViewModel
import com.DevKB.myzuri.databinding.FragmentControlBinding
import com.google.android.material.timepicker.MaterialTimePicker
//import com.google.android.material.timepicker.TimeFormat
import com.google.android.material.timepicker.TimeFormat.CLOCK_24H


class ControlFragment : Fragment(R.layout.fragment_control) {
    private lateinit var controlBinding: FragmentControlBinding
    private lateinit var adafruitModel: AdafruitViewModel

    private var hour: String?= null
    private var min: String?= null
    private var setTime: String? = null

    private var isConnected = false
    private var isSwitched = false

   // @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controlBinding = FragmentControlBinding.bind(view)
        adafruitModel = ViewModelProvider(this).get(AdafruitViewModel::class.java)

        //connect to the broker
        adafruitModel.connect(requireContext())

        adafruitModel.connected().observe(requireActivity(), Observer {
            isConnected = it
            if (!isConnected){
                adafruitModel.connect(requireContext())
            }
        })

        adafruitModel.switched().observe(requireActivity(), Observer {
            isSwitched = it
        })

        controlBinding.myPumpSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                if (isConnected) {
                    adafruitModel.publish("pump", "ON", 1)
                    Log.d("Listener","$isSwitched")
                    println("Hey: $isSwitched")

                    if (isSwitched){
                        makeText(requireContext(),"Pump switched ON", LENGTH_LONG).show()
                    } else {
                        makeText(requireContext(), "Failed to switch ON", LENGTH_LONG).show()
                        controlBinding.myPumpSwitch.isChecked = false
                    }
                }
            } else {
                if (isConnected) {
                    adafruitModel.publish("pump", "OFF", 1)

                    if (isSwitched){
                        makeText(requireContext(),"Pump switched OFF", LENGTH_LONG).show()
                    } else {
                        makeText(requireContext(), "Failed to Switch Pump OFF", LENGTH_LONG).show()
                        controlBinding.myPumpSwitch.isChecked = true
                    }
                }

            }
        }

        controlBinding.myFanSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                if (isConnected) {
                    adafruitModel.publish("fan", "ON", 1)
                    Log.d("Listener","$isSwitched")
                    println("Hey: $isSwitched")

                    if (isSwitched){
                        makeText(requireContext(),"Fan switched ON", LENGTH_LONG).show()
                    } else {
                        makeText(requireContext(), "Failed to switch ON", LENGTH_LONG).show()
                        controlBinding.myFanSwitch.isChecked = false
                    }
                }
                } else {
                if (isConnected) {
                    adafruitModel.publish("fan", "OFF", 1)

                    if (isSwitched){
                        makeText(requireContext(),"Fan switched OFF", LENGTH_LONG).show()
                    } else {
                        makeText(requireContext(), "Failed to Switch Fan OFF", LENGTH_LONG).show()
                        controlBinding.myFanSwitch.isChecked = true
                    }
                }

            }
            }

        controlBinding.setTime.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder()
                .setTimeFormat(CLOCK_24H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("SCHEDULE IRRIGATION")
                .build()
            timePicker.show(childFragmentManager,"TAG")

            timePicker.addOnPositiveButtonClickListener {
                hour = timePicker.hour.toString()
                min = timePicker.minute.toString()
                setTime = hour.plus(min)

                controlBinding.irrigationTime.text = hour.plus(":").plus(min)

                adafruitModel.publish("time", setTime!!,1)
            }

        }

        }

    }