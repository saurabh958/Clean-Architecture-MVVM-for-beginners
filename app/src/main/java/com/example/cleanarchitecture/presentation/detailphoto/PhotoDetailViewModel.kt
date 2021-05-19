package com.example.cleanarchitecture.presentation.detailphoto

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.model.Photo
import com.example.cleanarchitecture.domain.usecase.GetPhotoDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(private val getPhotoDetailUseCase: GetPhotoDetailUseCase):
    ViewModel() {

    private val TAG = PhotoDetailViewModel::class.java.simpleName
    val photoData = MutableLiveData<Photo>()
    val isLoad = MutableLiveData<Boolean>()
    val isFavorite = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }

    fun getDetail(id: Long?){
        if(id==null) return
        getPhotoDetailUseCase.savePhoto(id)
        getPhotoDetailUseCase.execute(
            onSuccess = {
                isLoad.value=true
                photoData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

    fun updateFavouriteStatus(){
        photoData.value?.let { photo ->
            if(isFavorite.value == true){
                getPhotoDetailUseCase.deleteAsFavorite(photo)
            }
            else
            {
                getPhotoDetailUseCase.addAsFavorite(photo)
            }
            isFavorite.value?.let {
                isFavorite.value = !it
            }
        }
    }

    fun checkFavoriteStatus(photoId: Long) {
        isFavorite.value = getPhotoDetailUseCase.isFavorite(photoId)
    }



}