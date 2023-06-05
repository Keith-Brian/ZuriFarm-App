package com.DevKB.myzuri.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.DevKB.myzuri.R
import com.DevKB.myzuri.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var dashBinding: ActivityDashboardBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(dashBinding.root)

        initializeNavController()

    }

    private fun initializeNavController() {
        val navHostFragmentManager = supportFragmentManager.findFragmentById(R.id.homeContainer) as NavHostFragment
        navController = navHostFragmentManager.navController
        setupWithNavController(dashBinding.bottomNavBar, navController)
    }


}