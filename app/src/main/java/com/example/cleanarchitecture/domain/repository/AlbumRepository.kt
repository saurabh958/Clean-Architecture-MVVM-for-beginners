package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.domain.model.Album
import io.reactivex.Single

interface AlbumRepository
{
    fun getAlbums(): Single<List<Album>>
}