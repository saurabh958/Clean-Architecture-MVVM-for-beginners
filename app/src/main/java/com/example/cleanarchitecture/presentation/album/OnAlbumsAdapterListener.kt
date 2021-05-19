package com.example.cleanarchitecture.presentation.album

import com.example.cleanarchitecture.domain.model.Album

interface OnAlbumsAdapterListener {

    fun showPhotos(album: Album)
}