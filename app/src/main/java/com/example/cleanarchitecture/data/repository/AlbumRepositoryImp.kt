package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.source.remote.RetrofitService
import com.example.cleanarchitecture.domain.model.Album
import com.example.cleanarchitecture.domain.repository.AlbumRepository
import io.reactivex.Single

class AlbumRepositoryImp(
    private val retrofitService: RetrofitService
): AlbumRepository{


    override fun getAlbums(): Single<List<Album>> {
        return retrofitService.getAlbums()
    }

}