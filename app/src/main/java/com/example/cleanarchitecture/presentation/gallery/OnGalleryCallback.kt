package com.example.cleanarchitecture.presentation.gallery

import android.widget.ImageView
import com.example.cleanarchitecture.domain.model.Album

interface OnGalleryCallback {
    fun navigateToAlbumPage(album: Album)

    fun gotoDetailPageByPhotoId(imageView: ImageView,id: Long)
}