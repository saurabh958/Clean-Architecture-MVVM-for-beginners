package com.example.cleanarchitecture.presentation.photo

import android.widget.ImageView

interface OnPhotosAdapterListener {
    fun gotoDetailPage(imageView: ImageView,id:Long)
}