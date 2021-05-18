package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.source.local.AppDatabase
import com.example.cleanarchitecture.data.source.remote.RetrofitService
import com.example.cleanarchitecture.domain.model.Photo
import com.example.cleanarchitecture.domain.repository.PhotoRepository
import io.reactivex.Single

class PhotoRepositoryImp(
    private val database: AppDatabase,
    private val retrofitService: RetrofitService
): PhotoRepository {
    override fun getPhotos(albumId: Long?): Single<List<Photo>> {
        return retrofitService.getPhotos(albumId!!)
    }

    override fun getPhotoDetail(photoId: Long?): Single<Photo> {
        return retrofitService.getPhotoDetail(photoId!!)
    }

    override fun deletePhoto(photo: Photo) {
        database.photoDao.delete(photo)
    }

    override fun addPhoto(photo: Photo) {
        database.photoDao.insert(photo)
    }

    override fun isFavorite(photoId: Long): Boolean {
        val loadOneByPhotoId  = database.photoDao.loadOneByPhotoId(photoId)
        return loadOneByPhotoId != null
    }
}