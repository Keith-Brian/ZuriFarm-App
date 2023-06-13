package com.DevKB.myzuri.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.DevKB.myzuri.R
import com.DevKB.myzuri.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var profileBinding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileBinding = FragmentProfileBinding.bind(view)
    }

}