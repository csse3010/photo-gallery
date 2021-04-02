package com.example.photogallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import java.util.*

private const val ARG_GALLERY_ITEM_TITLE = "gallery_item_title"
private const val ARG_GALLERY_ITEM_URL = "gallery_item_url"

class GalleryItemFragment: Fragment() {

    private lateinit var titleTextView: TextView
    private lateinit var imageView: ImageView

    private lateinit var galleryItemTitle: String
    private lateinit var galleryItemUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        galleryItemTitle = arguments?.getSerializable(ARG_GALLERY_ITEM_TITLE) as String
        galleryItemUrl = arguments?.getSerializable(ARG_GALLERY_ITEM_URL) as String
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_gallery_item, container, false)

        titleTextView = view.findViewById(R.id.titleTextView)
        imageView = view.findViewById(R.id.imageView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titleTextView.text = galleryItemTitle
        Picasso.get().load(galleryItemUrl).into(imageView)
    }

    companion object {
        fun newInstance(galleryItem: GalleryItem): GalleryItemFragment {
            val fragment = GalleryItemFragment()

            val arguments = Bundle()
            arguments.putSerializable(ARG_GALLERY_ITEM_TITLE, galleryItem.title)
            arguments.putSerializable(ARG_GALLERY_ITEM_URL, galleryItem.urlLarge)
            fragment.arguments = arguments

            return fragment
        }
    }
}