package com.example.mvvm_kotlin_example.binding_util

import android.util.Log
import android.widget.ImageView
import android.widget.RatingBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import com.squareup.picasso.Target

/**
 * Created by Sarsenov Yerlan on 04.11.2020.
 */

//@BindingAdapter("please_bind:data")
//fun configureRecView(recycler: RecyclerView, list: List<Movie>) {
//
////    Log.e("BindingAdapter", "title is ${list[0].title}, and url is ${list[0].posterUrl}")
////    recycler.layoutManager = LinearLayoutManager(recycler.context)
////    recycler.adapter = adapter
//    (recycler.adapter as MoviesAdapter).list = list
//}


@BindingAdapter("imageUrlWithPic")
fun ImageView.setImageWithPicasso(imageUrl: String) {
    if (imageUrl != null && imageUrl.isNotBlank()) {
        //Log.d("BindingAdapter", "image: $imageUrl")
        Picasso.get().load(imageUrl).into(this)
    }
}

@BindingAdapter("changeBack")
fun ConstraintLayout.changeBack(imageUrl: String) {
    if (imageUrl != null && imageUrl.isNotBlank()) {
//        Log.d("BindingAdapter", "image: $imageUrl")
        Picasso.get().load(imageUrl)
            .into(CustomLayout(this))
    }
}


@BindingAdapter("rateIt")
fun RatingBar.rateItSimply(rate: Double) {
    this.rating = rate.toFloat() / 2
}
