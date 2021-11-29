package com.example.filmapp

import android.util.Log
import javax.inject.Inject

class AndroidLog @Inject constructor(){
    fun Log(message: String){
        Log.d("Jose Manuel", message)
    }
}