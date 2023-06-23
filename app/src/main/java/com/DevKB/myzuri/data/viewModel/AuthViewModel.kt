package com.DevKB.myzuri.data.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.DevKB.myzuri.data.model.AuthRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class AuthViewModel: ViewModel() {

    var email: String? = null
    var password:String? = null

    val authRepo = AuthRepository()

    public fun getInstance(application: Application){
        authRepo.authGetInstance(application)
    }

    public fun register(email: String, password: String): Task<AuthResult> {
       return authRepo.registerUser(email,password)
    }

    public fun login(email: String,password: String): Task<AuthResult> {
       // authRepo.loginUSer(email,password)
        return authRepo.loginUSer(email, password)
    }
    public fun logout(){
        authRepo.signOut()
    }

    public fun getUser(){
        return authRepo.getUser()
    }
}