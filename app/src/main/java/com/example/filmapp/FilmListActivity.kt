package com.example.filmapp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.filmapp.databinding.FilmListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FilmListActivity:  AppCompatActivity() {

    @Inject
    lateinit var adapter: FilmListAdapter

    @Inject
    private lateinit var myLog: AndroidLog

    private lateinit var binding: FilmListBinding

    private val viewModel: FilmListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FilmListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.adapter = adapter

        viewModel.loadFilms()

        viewModel.films.observe(this) {
            adapter.submitList(it)
        }

        adapter.callback = {
            Log.i("TAG",".ask.fasdt")
            myLog.Log("Click en película: ${it.title}")
        }
    }
}