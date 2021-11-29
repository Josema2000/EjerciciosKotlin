package com.example.filmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var log: AndroidLog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log.Log("onCreate")
    }

    override fun onResume(){
        super.onResume()
        log.Log("onResume")
    }
    override fun onStop(){
        super.onStop()
        log.Log("onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        log.Log("onDestroy")
    }
}