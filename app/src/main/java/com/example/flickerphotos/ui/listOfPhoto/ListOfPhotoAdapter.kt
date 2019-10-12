package com.example.flickerphotos.ui.listOfPhoto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flickerphotos.R
import com.example.flickerphotos.data.model.Item

class ListOfPhotoAdapter(private val context: Context) : RecyclerView.Adapter<ListOfPhotoAdapter.ViewHolder>() {

    lateinit var listOfItem: ArrayList<Item>

    var onItemClick: ((url: String)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listOfItem.size-1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(listOfItem[position].media.m)
            .placeholder(R.drawable.place_holder)
            .into(holder.imageView)
    }

    fun updateList(listOfItem: ArrayList<Item>) {
        this.listOfItem = listOfItem
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<AppCompatImageView>(R.id.item_view)
        init {
            imageView.setOnClickListener { onItemClick?.invoke(listOfItem[adapterPosition].media.m) }
        }
    }
}