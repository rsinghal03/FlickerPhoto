package com.example.flickerphotos.dependencyInjection

import com.example.flickerphotos.data.FlickerServiceProvider
import com.example.flickerphotos.data.FlickerServiceProviderImpl
import com.example.flickerphotos.data.model.FlickerResponse
import com.example.flickerphotos.networking.FlickerApiClient
import com.example.flickerphotos.ui.listOfPhoto.ListOfPhotoContract
import com.example.flickerphotos.ui.listOfPhoto.ListOfPhotoPresenter
import dagger.Module
import dagger.Provides

@Module
class FlickerPhotoModule {

    @Provides
    fun provideListOfPhotoPresenter(flickerServiceProvider: FlickerServiceProvider): ListOfPhotoContract.Presenter {
        return ListOfPhotoPresenter(flickerServiceProvider)
    }

    @Provides
    fun provideFlickerServiceProvider(flickerApiClient: FlickerApiClient): FlickerServiceProvider {
        return FlickerServiceProviderImpl(flickerApiClient)
    }

    @Provides
    fun providesFlickerApiClient(): FlickerApiClient {
        return FlickerApiClient()
    }
}