package com.DevKB.myzuri.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.DevKB.myzuri.data.viewModel.AuthViewModel
import com.DevKB.myzuri.databinding.ActivitySigninBinding

class SigningActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        val authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        authViewModel.getInstance(this.application)

        loginBinding.btnLogin.setOnClickListener {

            authViewModel.email = loginBinding.loginEmail.text.toString()
            authViewModel.password = loginBinding.loginPass.text.toString()

            authViewModel.login(authViewModel.email!!,authViewModel.password!!)
        }
    }
}