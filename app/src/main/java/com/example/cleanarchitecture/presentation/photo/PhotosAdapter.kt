package com.example.cleanarchitecture.presentation.photo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.HolderPhotoBinding
import com.example.cleanarchitecture.domain.model.Photo
import com.example.cleanarchitecture.presentation.loadImage

internal class PhotosAdapter(val mListener: OnPhotosAdapterListener):
RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private val TAG = PhotosAdapter::class.java.name
    private val photos: MutableList<Photo> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderPhotoBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.holder_photo,parent,false
        )
        return PhotoViewHolder(holderPhotoBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PhotoViewHolder).onBind(getItem(position))
    }

    private fun getItem(position: Int): Photo {
        return photos[position]

    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun addData(list: List<Photo>) {
        this.photos.clear()
        this.photos.addAll(list)
        notifyDataSetChanged()
    }

    inner class PhotoViewHolder(private val dataBinding: ViewDataBinding):RecyclerView.ViewHolder(dataBinding.root){
        fun onBind(photo: Photo){
            val holderPhotoBinding = dataBinding as HolderPhotoBinding
            holderPhotoBinding.photoViewModel= PhotoViewModel(photo)
            holderPhotoBinding.photoProgressBar.visibility = View.VISIBLE
            holderPhotoBinding.photoImageView.loadImage(photo.url, holderPhotoBinding.photoProgressBar)

            itemView.setOnClickListener {
                mListener.gotoDetailPage(holderPhotoBinding.photoImageView,photo.id)
            }
        }
    }

}