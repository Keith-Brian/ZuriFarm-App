package com.DevKB.myzuri.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.DevKB.myzuri.R
import com.DevKB.myzuri.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var dashBinding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(dashBinding.root)

    }


}