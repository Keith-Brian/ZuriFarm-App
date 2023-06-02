package com.DevKB.myzuri.data

interface AuthInterface {

    fun onSuccess()
    fun onFailure(message: String)
    fun onStarted(message: String)
}