package com.DevKB.myzuri.ui.auth


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.DevKB.myzuri.data.viewModel.AuthViewModel
import com.DevKB.myzuri.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var registerBinding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        val authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        authViewModel.getInstance(application)

        registerBinding.btnRegister.setOnClickListener {
            authViewModel.email = registerBinding.regEmail.text.toString()
            authViewModel.password = registerBinding.regPass.text.toString()

            authViewModel.register(authViewModel.email!!, authViewModel.password!!)
        }
    }
}