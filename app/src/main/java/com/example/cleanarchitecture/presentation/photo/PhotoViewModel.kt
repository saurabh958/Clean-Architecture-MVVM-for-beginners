package com.example.cleanarchitecture.presentation.photo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.model.Photo

class PhotoViewModel(val photo: Photo): ViewModel() {

    private val TAG = PhotoViewModel::class.java.name
    val photoData = MutableLiveData<Photo>()

    init {
        photoData.value = photo
    }
}