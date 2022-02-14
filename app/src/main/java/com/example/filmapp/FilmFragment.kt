package com.example.filmapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.filmapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FilmFragment : Fragment() {

    companion object {
        const val FILM_ID = "ID"
    }

    @Inject
    lateinit var log: AndroidLog

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityMainBinding.inflate(layoutInflater)

        val id = arguments?.getInt(FILM_ID) ?: 0
        viewModel.loadFilm(id)

        viewModel.film.observe(this){
            binding.Titulo.text = it.title
            binding.Director.text = it.nameDir
            Glide.with(this).load(it.imageUrl).into(binding.imageView)
            binding.imageView.setImageResource(R.drawable.ic_launcher_background)

            if (it.videoId == null) {
                binding.trailer.visibility = View.GONE
            }else{
                binding.trailer.visibility = View.VISIBLE
                binding.trailer.setOnClickListener {_->
                    launchYoutube(it.videoId)
                }
            }
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun launchYoutube(id: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=$id"))
        startActivity(intent)
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