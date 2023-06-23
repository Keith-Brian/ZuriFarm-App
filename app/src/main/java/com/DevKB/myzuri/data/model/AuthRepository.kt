package com.DevKB.myzuri.data.model

import android.app.Application
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class AuthRepository {

    private lateinit var auth: FirebaseAuth
    private lateinit var application: Application
   // private lateinit var intent: Intent

    public fun authGetInstance(application: Application) {
        this.application = application
        auth = FirebaseAuth.getInstance()
     //   intent = Intent(application,DashboardActivity::class.java)
    }

    fun registerUser(email: String, password: String): Task<AuthResult>{
      return auth.createUserWithEmailAndPassword(email,password)
    }

    public fun loginUSer(email: String, password: String): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email,password)
    }

    public fun signOut(){
        auth.signOut()
    }

    fun getUser(){
        auth.currentUser
    }

}

