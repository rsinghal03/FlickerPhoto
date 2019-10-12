package com.example.flickerphotos.ui.largePhoto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.flickerphotos.R
import com.example.flickerphotos.ui.BaseFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.large_photo_fragment.*

const val URL_KEY = "url"

class LargePhotoFragment : BaseFragment() {

    lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        url = arguments?.getString(URL_KEY) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return LayoutInflater.from(inflater.context).inflate(R.layout.large_photo_fragment,container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext())
            .load(url)
            .placeholder(R.drawable.place_holder)
            .into(large_photo_id)

    }

    companion object {
        fun getInstance(url: String): LargePhotoFragment {
            val fragment = LargePhotoFragment()
            fragment.arguments = Bundle().apply {
                putString(URL_KEY, url)
            }
            return fragment
        }
    }
}