package com.example.hw1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.hw1.databinding.ItemCarBinding

class CarAdapter(
    private var list: List<Car>,
    private val glide: RequestManager,
    private val onItemClick: (Car) -> Unit,
) : RecyclerView.Adapter<CarHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarHolder = CarHolder(
        ItemCarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onItemClick,
    )

    // may be trouble ~!~~~~~!!!! 38:35

    override fun onBindViewHolder(
        holder: CarHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}