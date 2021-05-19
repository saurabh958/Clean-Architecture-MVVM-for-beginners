package com.example.cleanarchitecture.presentation.album

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.model.Album
import com.example.cleanarchitecture.domain.usecase.GetAlbumsUseCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(private val getAlbumListUseCase: GetAlbumsUseCase):ViewModel()
{
    private val TAG = AlbumsViewModel::class.java.simpleName
    val albumsReceivedLiveData = MutableLiveData<List<Album>>()
    val isLoad = MutableLiveData<Boolean>()
    val albumData= MutableLiveData<Album>()


    init {
        isLoad.value=false
    }

    val album:Album? get() = albumData.value

    fun set(album:Album) = run{
        albumData.value = album
    }

    fun loadAlbums(){
        getAlbumListUseCase.execute(
            onSuccess = {
                isLoad.value = true
                albumsReceivedLiveData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }



}