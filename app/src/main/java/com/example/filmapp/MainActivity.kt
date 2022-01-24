package com.example.filmapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.domain.GetFilmUseCase
import com.example.filmapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var log: AndroidLog
    @Inject
    lateinit var useCase: GetFilmUseCase

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.loadFilm()
        viewModel.film.observe(this){
            binding.Titulo.text = it.title
            binding.Director.text = it.nameDir
            Glide.with(this).load(it.imageUrl).into(binding.imageView)
        }
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