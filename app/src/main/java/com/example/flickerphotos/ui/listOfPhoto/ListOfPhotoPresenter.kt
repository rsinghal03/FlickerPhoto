package com.example.flickerphotos.ui.listOfPhoto

import com.example.flickerphotos.data.FlickerServiceProvider
import com.example.flickerphotos.data.model.FlickerResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ListOfPhotoPresenter(private val serviceProvider: FlickerServiceProvider) :
    ListOfPhotoContract.Presenter {
    override var view: ListOfPhotoContract.View? = null

    override var compositeDisposable: CompositeDisposable =  CompositeDisposable()


    override fun getListOfPhoto() {
        view?.showLoading()
        val disposable =
            serviceProvider.getFlickerResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({ success -> showListOfPhoto(success)}, { error -> })
        compositeDisposable.add(disposable)
    }

    private fun showListOfPhoto(flickerResponse: FlickerResponse) {
        view?.hideLoading()
        view?.setListOfPhoto(flickerResponse.items)
    }
}