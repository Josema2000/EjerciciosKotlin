package com.example.filmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.domain.FilmUseCase
import com.example.filmapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var log: AndroidLog
    @Inject
    lateinit var useCase: FilmUseCase

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        log.Log("onCreate")
        var pelicula = useCase.execute()
        log.Log(pelicula.nameDir)
        binding.Titulo.text = resources.getString(R.string.titulo)
        binding.imageView.setImageResource(R.drawable.ic_launcher_background)
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