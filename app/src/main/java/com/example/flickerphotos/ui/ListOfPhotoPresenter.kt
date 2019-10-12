package com.example.flickerphotos.ui

import com.example.flickerphotos.data.FlickerServiceProvider

class ListOfPhotoPresenter(val serviceProvider: FlickerServiceProvider) : ListOfPhotoContract.Presenter {

    override fun getListOfPhoto() {
        val disposable = serviceProvider.getFlickerResponse()
    }
}