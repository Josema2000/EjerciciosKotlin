package com.example.filmapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.filmapp.databinding.FilmListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FilmListActivity:  AppCompatActivity() {

    @Inject
    lateinit var adapter: FilmListAdapter

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

            val intent = Intent(this, FilmListActivity::class.java)
            intent.putExtra(FilmActivity.FILM_ID, it.id)
            startActivity(intent)
        }
    }
}