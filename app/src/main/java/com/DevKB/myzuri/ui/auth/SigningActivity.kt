package com.DevKB.myzuri.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.lifecycle.ViewModelProvider
import com.DevKB.myzuri.data.viewModel.AuthViewModel
import com.DevKB.myzuri.databinding.ActivitySigninBinding
import com.DevKB.myzuri.ui.dashboard.DashboardActivity
import com.DevKB.myzuri.utils.ViewUtils.Extension.toast
import com.google.android.gms.tasks.OnCompleteListener


class SigningActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        val authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        authViewModel.getInstance(this.application)

        loginBinding.signUpTv.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }


        fun validateCredentials(email: String, password: String): Boolean {

            if (email.isEmpty()){
                loginBinding.loginEmail.error = "Email cannot be blank!"
                return false
            }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                loginBinding.loginEmail.error = "Invalid Email!"
                return false
            }else if(password.isEmpty()){
                loginBinding.loginPass.error = "Password Cannot be blank!"
                return false
            }else{
                loginBinding.loginEmail.error = null
                loginBinding.loginPass.error = null
                return true
            }
        }

        loginBinding.btnLogin.setOnClickListener {


            if (validateCredentials(loginBinding.loginEmail.text.toString(),loginBinding.loginPass.text.toString())) {

                authViewModel.email = loginBinding.loginEmail.text.toString()
                authViewModel.password = loginBinding.loginPass.text.toString()

                authViewModel.login(authViewModel.email!!, authViewModel.password!!)
                    .addOnCompleteListener(OnCompleteListener {
                        if (it.isSuccessful) {
                            toast("Login Successful")
                            val intent = Intent(this, DashboardActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            toast("Login Failed!")
                        }
                    })

            }
        }
    }
}