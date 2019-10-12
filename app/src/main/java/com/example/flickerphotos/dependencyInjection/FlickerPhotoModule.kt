package com.example.flickerphotos.dependencyInjection

import com.example.flickerphotos.ui.ListOfPhotoContract
import com.example.flickerphotos.ui.ListOfPhotoPresenter
import dagger.Module
import dagger.Provides

@Module
class FlickerPhotoModule {

    @Provides
    fun provideListOfPhotoPresenter(): ListOfPhotoContract.Presenter {
        return ListOfPhotoPresenter()
    }
}