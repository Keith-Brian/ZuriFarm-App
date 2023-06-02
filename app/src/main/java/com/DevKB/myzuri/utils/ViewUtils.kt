package com.DevKB.myzuri.utils

import android.content.Context
import android.widget.Toast

class ViewUtils {

    object Extension{
        fun Context.toast(message: String){
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        }
    }

}