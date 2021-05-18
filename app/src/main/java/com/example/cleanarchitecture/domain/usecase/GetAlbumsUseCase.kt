package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.data.repository.AlbumRepositoryImp
import com.example.cleanarchitecture.domain.model.Album
import com.example.cleanarchitecture.domain.repository.AlbumRepository
import com.example.cleanarchitecture.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(private val repository: AlbumRepository): SingleUseCase<List<Album>>() {

    override fun buildUseCaseSingle(): Single<List<Album>> {
        return repository.getAlbums()
    }
}