package com.example.hw1

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.hw1.databinding.ItemCarBinding

class CarHolder(
    private val binding: ItemCarBinding,
    private val glide: RequestManager,
    private val onItemClick: (Car) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(car: Car) {
        with(binding) {
            tvName.text = car.name
            tvCreator.text = car.creator
            root.setOnClickListener{
                onItemClick(car)
            }
            glide
                .load(car.url)
                .into(ivCover)
        }
    }
}