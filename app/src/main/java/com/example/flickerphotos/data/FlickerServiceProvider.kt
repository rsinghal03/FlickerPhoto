package com.example.flickerphotos.data

import com.example.flickerphotos.data.model.FlickerResponse
import io.reactivex.Observable

interface FlickerServiceProvider {

    fun getFlickerResponse(): Observable<FlickerResponse>
}