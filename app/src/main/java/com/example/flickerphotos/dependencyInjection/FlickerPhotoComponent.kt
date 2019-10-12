package com.example.flickerphotos.dependencyInjection

import com.example.flickerphotos.ui.ListOfPhotoFragment
import dagger.Component

@Component(modules = [FlickerPhotoModule::class])
interface FlickerPhotoComponent {

    fun inject(listOfPhotoFragment: ListOfPhotoFragment)
}