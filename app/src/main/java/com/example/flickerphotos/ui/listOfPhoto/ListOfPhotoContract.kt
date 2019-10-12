package com.example.flickerphotos.ui.listOfPhoto

import com.example.flickerphotos.data.model.Item
import com.example.flickerphotos.ui.BaseContract

interface ListOfPhotoContract {

    interface View: BaseContract.BaseView {
        fun setListOfPhoto(listOfItem: List<Item>)
    }

    interface Presenter : BaseContract.BasePresenter<View> {
        fun getListOfPhoto()
    }
}