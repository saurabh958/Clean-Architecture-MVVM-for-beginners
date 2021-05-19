package com.example.cleanarchitecture.presentation.gallery

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.domain.model.Album
import com.example.cleanarchitecture.presentation.album.AlbumsFragment
import com.example.cleanarchitecture.presentation.detailphoto.PhotoDetailActivity
import com.example.cleanarchitecture.presentation.photo.PhotosFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryActivity : AppCompatActivity(), OnGalleryCallback {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        if(savedInstanceState == null){
            navigateToGalleryPage()
        }

    }

    private fun navigateToGalleryPage() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.gallery_container,
                AlbumsFragment.newInstance(),
                AlbumsFragment.FRAGMENT_NAME
            ).commitAllowingStateLoss()
    }

    override fun navigateToAlbumPage(album: Album) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.gallery_container,
                PhotosFragment.newInstance(album.id),
                PhotosFragment.FRAGMENT_NAME
            )
            .addToBackStack(PhotosFragment.FRAGMENT_NAME)
            .commitAllowingStateLoss()
    }

    override fun gotoDetailPageByPhotoId(imageView: ImageView, id: Long) {
        val intent = Intent(this, PhotoDetailActivity::class.java)
        val bundle = Bundle().apply {
            putLong(KEY_PHOTO_ID,id)
        }
        intent.putExtras(bundle)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,imageView,
        ViewCompat.getTransitionName(imageView)?:"")
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            startActivity(intent, options.toBundle())
        }
        else
        {
            startActivity(intent)
        }
    }

    companion object {
        private val KEY_PHOTO_ID = "KEY_PHOTO_ID"
    }
}