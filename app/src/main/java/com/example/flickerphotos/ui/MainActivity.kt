package com.example.flickerphotos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flickerphotos.R
import com.example.flickerphotos.extension.add

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add(ListOfPhotoFragment.instance, R.id.container, false)
    }
}
