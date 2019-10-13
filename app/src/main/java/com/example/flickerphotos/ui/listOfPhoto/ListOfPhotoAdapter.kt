package com.example.flickerphotos.ui.listOfPhoto

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flickerphotos.R
import com.example.flickerphotos.data.model.Item

class ListOfPhotoAdapter(private val context: Context) : BaseAdapter(),
    AdapterView.OnItemClickListener {

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        onItemClick?.invoke(listOfItem[position].media.m)
    }

    lateinit var listOfItem: ArrayList<Item>

    var onItemClick: ((url: String) -> Unit)? = null

    companion object {
        const val VIEW_HOLDER_KEY = 0
        const val POSITION_KEY = 1
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var row = convertView
        var viewHolder: ViewHolder? = null

        if (row == null) {
            row = ((context) as Activity).layoutInflater.inflate(R.layout.item_view, parent, false)
            viewHolder = ViewHolder()
            viewHolder.imageView = row.findViewById(R.id.item_view)
            row.setTag(viewHolder)
        } else {
            viewHolder = row.getTag(VIEW_HOLDER_KEY) as ViewHolder?
        }
        viewHolder?.imageView?.let {
            Glide.with(context)
                .load(listOfItem[position].media.m)
                .placeholder(R.drawable.place_holder)
                .into(it)
        }
        return row!!
    }

    override fun getItem(position: Int): Any {
        return listOfItem[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount() = listOfItem.size

    fun updateList(listOfItem: ArrayList<Item>) {
        this.listOfItem = listOfItem
        notifyDataSetChanged()
    }

    inner class ViewHolder {
        lateinit var imageView: AppCompatImageView
    }
}