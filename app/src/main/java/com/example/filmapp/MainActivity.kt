package com.example.filmapp

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.filmapp.databinding.MainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity(), FilmLauncher {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.list, FilmListFragment())
            .commit()
    }

    override fun openDetails(id: Int) {
        val fragment = FilmFragment()
        fragment.arguments = Bundle().apply {
            putInt(FilmFragment.FILM_ID, id)
        }

        val isTablet = resources.getBoolean(R.bool.isTablet)
        if(isTablet) {
            supportFragmentManager.beginTransaction()
                .add(R.id.detail, fragment)
                .commit()
        }else{
            supportFragmentManager.beginTransaction()
                .add(R.id.list, fragment)
                .addToBackStack("BackStack")
                .commit()
        }
    }
}