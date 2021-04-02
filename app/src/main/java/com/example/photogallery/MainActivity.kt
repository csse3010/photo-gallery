package com.example.photogallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity(), PhotoGalleryFragment.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainer, PhotoGalleryFragment.newInstance())
                    .commit()
        }
    }

    override fun onGalleryItemSelected(galleryItem: GalleryItem) {
        Log.d("MainActivity", "Gallery item was selected: ${galleryItem.id}")
        val fragment = GalleryItemFragment.newInstance(galleryItem)
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
    }
}