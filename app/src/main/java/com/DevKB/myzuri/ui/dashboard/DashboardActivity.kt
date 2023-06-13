package com.DevKB.myzuri.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.DevKB.myzuri.R
import com.DevKB.myzuri.databinding.ActivityDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {
    private lateinit var dashBinding: ActivityDashboardBinding
    private lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(dashBinding.root)

        val bottomNav = dashBinding.bottomNavBar
        val navController = findNavController(R.id.homeContainer)
        bottomNav.setupWithNavController(navController)

    }
}