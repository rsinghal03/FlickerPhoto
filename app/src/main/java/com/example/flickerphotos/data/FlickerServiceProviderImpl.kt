package com.example.flickerphotos.data

import com.example.flickerphotos.data.model.FlickerResponse
import com.example.flickerphotos.networking.FlickerApiClient
import com.example.flickerphotos.networking.FlickerService
import io.reactivex.Observable

const val FORMAT = "json"

class FlickerServiceProviderImpl(private val flickerApiClient: FlickerApiClient) : FlickerServiceProvider {

    override fun getFlickerResponse(): Observable<FlickerResponse> {
        val flickerService = flickerApiClient.getRetrofit().create(FlickerService::class.java)
        return flickerService.getFlickerPhotoResponse(FORMAT)
    }
}