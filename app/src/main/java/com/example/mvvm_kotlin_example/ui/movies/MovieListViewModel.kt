package com.example.mvvm_kotlin_example.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_kotlin_example.BuildConfig
import com.example.mvvm_kotlin_example.api.ApiUtils
import com.example.mvvm_kotlin_example.model.Movie
import com.example.mvvm_kotlin_example.ui.BaseViewModel

/**
 * Created by Sarsenov Yerlan on 02.11.2020.
 */
class MovieListViewModel(val name: String) : BaseViewModel() {
    var _liveData = MutableLiveData<List<Movie>>()
    val liveData: LiveData<List<Movie>>
        get() = _liveData

    init {
        getListMovies(name)
    }

    fun getListMovies(name: String) {
        doWork {
//            _liveData.value = ApiUtils.apiM().getListMovies(name).await()
            _liveData.postValue(ApiUtils.apiM().getListMovies(name).await())
            //Log.e(this.javaClass.simpleName, "title is ${liveData.value?.get(0)?.title}")
        }
    }

}