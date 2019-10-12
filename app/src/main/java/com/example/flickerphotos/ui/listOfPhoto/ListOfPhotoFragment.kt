package com.example.flickerphotos.ui.listOfPhoto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flickerphotos.FlickerPhotoApplication
import com.example.flickerphotos.R
import com.example.flickerphotos.data.model.Item
import com.example.flickerphotos.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_list_photo.*
import javax.inject.Inject

class ListOfPhotoFragment : BaseFragment(), ListOfPhotoContract.View {

    lateinit var listOfPhotoAdapter: ListOfPhotoAdapter

    @Inject
    lateinit var listOfPhotoPresenter: ListOfPhotoContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FlickerPhotoApplication.getInstance().flickerPhotoComponent.inject(this)
        listOfPhotoPresenter.attachView(this)
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

    override fun setListOfPhoto(listOfItem: List<Item>) {
        listOfPhotoAdapter.updateList(listOfItem as ArrayList)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        listOfPhotoPresenter.detachView()
    }

    companion object {
        val instance = ListOfPhotoFragment()
    }
}