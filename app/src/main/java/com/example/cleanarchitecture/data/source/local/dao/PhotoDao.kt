package com.example.cleanarchitecture.data.source.local.dao

import androidx.room.*
import com.example.cleanarchitecture.domain.model.Photo

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(photo:Photo):Long

    @Query("SELECT * FROM Photo")
    fun loadAll(): MutableList<Photo>

    @Delete
    fun delete(photo: Photo)

    @Query("DELETE FROM Photo")
    fun deleteAll()

    @Query("SELECT * FROM Photo where id = :photoId")
    fun loadOneByPhotoId(photoId: Long): Photo?

    @Query("SELECT * FROM Photo where title = :photoTitle")
    fun loadOneByPhotoTitle(photoTitle: String): Photo?

    @Update
    fun update(photo: Photo)

}