package com.example.flickerphotos.networking

import com.example.flickerphotos.data.model.FlickerResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface FlickerService {

    @GET("services/feeds/photos_public.gne")
    fun getFlickerPhotoResponse(@Query("format") format: String, @Query("nojsoncallback") noJsonCallback: Int): Observable<FlickerResponse>
}