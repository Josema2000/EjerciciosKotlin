package com.example.filmapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmapp.databinding.FilmOverviewBinding
import javax.inject.Inject

open class FilmViewHolder(val binding: FilmOverviewBinding) : RecyclerView.ViewHolder(binding.root)

class FilmListAdapter @Inject constructor(): ListAdapter<FilmOverviewDataView, FilmViewHolder>(diffUtil) {

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<FilmOverviewDataView>() {
            override fun areItemsTheSame(
                oldItem: FilmOverviewDataView,
                newItem: FilmOverviewDataView
            ) =
                oldItem.title == newItem.title

            override fun areContentsTheSame(
                oldItem: FilmOverviewDataView,
                newItem: FilmOverviewDataView
            ) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        object : FilmViewHolder(
            FilmOverviewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)) {}

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = getItem(position)
        holder.binding.info.text = film.title
        Glide.with(holder.binding.imageInfo).load(film.imageUrl).into(holder.binding.imageInfo)
    }
}


