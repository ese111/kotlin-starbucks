package com.example.starbucks.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.example.starbucks.R

@BindingAdapter("imageUrl")
fun applyImageAdapter(imageView: ImageView, image: String) {
    if(image == "") {
        imageView.load(R.drawable.ic_baseline_image_24)
    }else{
        imageView.load(image)
    }
}

@BindingAdapter("circleImage")
fun circleCropImage(imageView: ImageView, image: String) {
    if(image == "") {
        imageView.load(R.drawable.ic_baseline_image_24) {
            transformations(CircleCropTransformation())
        }
    }else {
        imageView.load(image) {
            transformations(CircleCropTransformation())
        }
    }
}
