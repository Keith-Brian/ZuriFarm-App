package com.DevKB.myzuri.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.DevKB.myzuri.R
import com.DevKB.myzuri.databinding.FragmentControlBinding

class ControlFragment : Fragment(R.layout.fragment_control) {
    private lateinit var controlBinding: FragmentControlBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controlBinding = FragmentControlBinding.bind(view)

    }
}