package com.example.filmapp


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.filmapp.databinding.FilmListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FilmListFragment:  Fragment() {

    @Inject
    lateinit var adapter: FilmListAdapter

    private lateinit var binding: FilmListBinding

    private val viewModel: FilmListViewModel by viewModels()

    private var filmLauncher: FilmLauncher? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        filmLauncher = context as? FilmLauncher
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FilmListBinding.inflate(layoutInflater)

        binding.root.adapter = adapter

        viewModel.loadFilms()

        viewModel.films.observe(this) {
            adapter.submitList(it)
        }

        adapter.callback = {
            //TODO
        }
        return binding.root
    }
}



