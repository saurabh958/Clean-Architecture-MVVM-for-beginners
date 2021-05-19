package com.example.cleanarchitecture.presentation.album

import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.domain.model.Album

class AlbumViewModel(val album: Album)
{
    private val TAG= AlbumViewModel::class.java.simpleName
    val albumData = MutableLiveData<Album>()

    init {
        albumData.value = album
    }

}