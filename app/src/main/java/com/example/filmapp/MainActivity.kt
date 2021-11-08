package com.example.filmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("manolo", "La aplicacion se ha creado")
    }

    override fun onResume(){
        super.onResume()
        Log.d("manolo", "La aplicacion continua")
    }
    override fun onStop(){
        super.onStop()
        Log.d("manolo", "La aplicación se ha detenido")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("manolo", "La aplicación se ha borrado")
    }
}