package com.example.mvvm_kotlin_example.binding_util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

/**
 * Created by Sarsenov Yerlan on 06.11.2020.
 */
class CustomLayout(val layout: ConstraintLayout) : Target {

    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
        layout.background = BitmapDrawable(layout.resources, bitmap)
//        Log.d(this.javaClass.simpleName, "onBitmapLoaded: here we go")
    }

    override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {

    }

    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

    }

}