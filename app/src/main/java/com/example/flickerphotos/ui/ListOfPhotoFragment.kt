package com.example.flickerphotos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flickerphotos.FlickerPhotoApplication
import com.example.flickerphotos.R
import kotlinx.android.synthetic.main.fragment_list_photo.*
import javax.inject.Inject

class ListOfPhotoFragment : Fragment() {

    lateinit var listOfPhotoAdapter: ListOfPhotoAdapter

    @Inject
    lateinit var listOfPhotoPresenter: ListOfPhotoContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FlickerPhotoApplication.getInstance().flickerPhotoComponent.inject(this)
        listOfPhotoPresenter.getListOfPhoto()
        listOfPhotoAdapter = ListOfPhotoAdapter()
        recycler_view_id.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        recycler_view_id.adapter = listOfPhotoAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return LayoutInflater.from(inflater.context).inflate(R.layout.fragment_list_photo,container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        val instance = ListOfPhotoFragment()
    }
}