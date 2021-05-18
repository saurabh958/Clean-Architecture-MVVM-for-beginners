package com.example.cleanarchitecture.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecture.data.source.local.dao.PhotoDao
import com.example.cleanarchitecture.domain.model.Photo

@Database(entities = [Photo::class],version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val photoDao:PhotoDao

    companion object{
        const val DB_NAME = "ArtGalleryDatabase.db"
    }


}