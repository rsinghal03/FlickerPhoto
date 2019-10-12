package com.example.flickerphotos.ui.listOfPhoto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flickerphotos.R
import com.example.flickerphotos.data.model.Item

class ListOfPhotoAdapter : RecyclerView.Adapter<ListOfPhotoAdapter.ViewHolder>() {

    lateinit var listOfItem: ArrayList<Item>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listOfItem.size-1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    fun updateList(listOfItem: ArrayList<Item>) {
        this.listOfItem = listOfItem
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}