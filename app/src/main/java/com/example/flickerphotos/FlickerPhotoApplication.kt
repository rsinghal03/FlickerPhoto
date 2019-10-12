package com.example.flickerphotos

import android.app.Application
import android.content.Context
import com.example.flickerphotos.dependencyInjection.DaggerFlickerPhotoComponent
import com.example.flickerphotos.dependencyInjection.FlickerPhotoComponent

class FlickerPhotoApplication : Application() {

    lateinit var flickerPhotoComponent: FlickerPhotoComponent

    init {
        initDagger()
    }

    private fun initDagger() {
        flickerPhotoComponent = DaggerFlickerPhotoComponent.create()
    }

    companion object {

        private var instance: FlickerPhotoApplication? = null

        fun getInstance(): FlickerPhotoApplication =
            instance ?: FlickerPhotoApplication().also {
                instance = it
            }
    }
}