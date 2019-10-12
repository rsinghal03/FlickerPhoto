package com.example.flickerphotos.ui

interface ListOfPhotoContract {

    interface View {
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun getListOfPhoto()
    }
}