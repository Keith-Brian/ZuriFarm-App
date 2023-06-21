package com.DevKB.myzuri.utils

import android.content.Context
import android.widget.Toast
import com.google.android.material.timepicker.TimeFormat
import com.google.android.material.timepicker.TimeFormat.*

class ViewUtils {

    object Extension{
        fun Context.toast(message: String){
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        }


    }

}