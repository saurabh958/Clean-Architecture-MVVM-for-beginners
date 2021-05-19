package com.example.cleanarchitecture.presentation.photo

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.model.Photo
import com.example.cleanarchitecture.domain.usecase.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(private val getPhotosUseCase: GetPhotosUseCase):ViewModel() {

    private val TAG = PhotosViewModel::class.java.simpleName
    val photoListReceivedLiveData = MutableLiveData<List<Photo>>()
    val isLoad = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }

    fun loadPhotos(id:Long?){
        if(id == null) return
        getPhotosUseCase.saveAlbum(id)
        getPhotosUseCase.execute(
            onSuccess = {
                isLoad.value= true
                photoListReceivedLiveData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }



}