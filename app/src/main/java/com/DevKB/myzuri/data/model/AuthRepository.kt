package com.DevKB.myzuri.data.model

import android.app.Application
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.DevKB.myzuri.ui.dashboard.DashboardActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

import com.DevKB.myzuri.utils.ViewUtils.Extension.toast

class AuthRepository {

    private lateinit var auth: FirebaseAuth
    private lateinit var application: Application

    public fun authGetInstance(application: Application) {
        this.application = application
        auth = FirebaseAuth.getInstance()
    }

    fun registerUser(email: String, password: String){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(OnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(application, "Register Successful", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(application, "Registration Failed",Toast.LENGTH_LONG).show()
                }
            })

    }

    public fun loginUSer(email: String, password: String){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(OnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(application,"Login Successful",Toast.LENGTH_LONG).show()

                }
                else{
                    Toast.makeText(application, "Login Failed!", Toast.LENGTH_LONG).show()
                }
            })
    }

    public fun signOut(){
        auth.signOut()
    }

}

