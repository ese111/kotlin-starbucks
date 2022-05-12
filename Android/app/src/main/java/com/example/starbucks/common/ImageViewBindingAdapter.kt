package com.example.starbucks.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun applyImageAdapter(imageView: ImageView, image: String) {
    imageView.load(image)
}