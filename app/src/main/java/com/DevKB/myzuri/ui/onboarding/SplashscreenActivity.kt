package com.DevKB.myzuri.ui.onboarding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import com.DevKB.myzuri.R
import com.DevKB.myzuri.data.viewModel.AuthViewModel
import com.DevKB.myzuri.databinding.ActivityMainBinding
import com.DevKB.myzuri.ui.auth.SignupActivity
import com.DevKB.myzuri.ui.dashboard.DashboardActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@SuppressLint("CustomSplashScreen")
class SplashscreenActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var firebaseUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)


        firebaseAuth = Firebase.auth
        firebaseUser = firebaseAuth.currentUser

        Handler(Looper.getMainLooper()).postDelayed({
            if(firebaseUser == null){
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
                finish()
            } else{
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()
            }


        },3000)
    }
}