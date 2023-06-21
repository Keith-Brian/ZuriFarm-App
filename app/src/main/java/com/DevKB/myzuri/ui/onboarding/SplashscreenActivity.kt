package com.DevKB.myzuri.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.DevKB.myzuri.R
import com.DevKB.myzuri.databinding.ActivityMainBinding
import com.DevKB.myzuri.ui.auth.SignupActivity
import com.DevKB.myzuri.ui.dashboard.DashboardActivity

class SplashscreenActivity : AppCompatActivity() {
    private lateinit var splashBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()

        },3000)
    }
}