package com.example.mvvm_kotlin_example.ui

import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_kotlin_example.api.ApiUtils
import com.example.mvvm_kotlin_example.model.Movie
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlin.coroutines.CoroutineContext

/**
 * Created by Sarsenov Yerlan on 01.11.2020.
 */

abstract class BaseViewModel: ViewModel() {

    // TODO: https://developer.android.com/topic/libraries/architecture/coroutines  -  lets try it

    private val viewModelJob = Job()
    val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var _isError = MutableLiveData<Boolean>()
    val isError : LiveData<Boolean>
        get() = _isError

    var _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean>
        get() = _isLoading


    init {
        _isError.value = false
        _isLoading.value = true
        Log.d("${this.javaClass.simpleName}: init", "isError: ${_isError.value}")
        Log.d("${this.javaClass.simpleName}: init", "isLoading: ${_isLoading.value}")
    }

    fun <P> doWork(doAsyncBlock: suspend CoroutineScope.() -> P) {
        Log.d("${this.javaClass.simpleName}: doWork", "isLoading: ${_isLoading.value}")
        Log.d("${this.javaClass.simpleName}: doWork", "isError: ${_isError.value}")
        doCoroutineWork(doAsyncBlock, viewModelScope, IO)
    }

    fun <P> doWorkInMainThread(doOnAsyncBlock: suspend CoroutineScope.() -> P) {
        doCoroutineWork(doOnAsyncBlock, viewModelScope, Main)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private inline fun <P> doCoroutineWork(
        crossinline doOnAsyncBlock: suspend CoroutineScope.() -> P,
        coroutineScope: CoroutineScope,
        context: CoroutineContext
    ) {
        coroutineScope.launch {
            withContext(context) {
                try {
                    doOnAsyncBlock.invoke(this)
                    _isError.postValue(false)
                    _isLoading.postValue(false)
                    Log.d(this.javaClass.simpleName, "Success")
                } catch (e: UnknownHostException) {
                    e.printStackTrace()
                    _isError.postValue(true)
                    _isLoading.postValue(false)
                    Log.d(this.javaClass.simpleName, "Server is unreachable")
                } catch (e: SocketTimeoutException) {
                    e.printStackTrace()
                    _isError.postValue(true)
                    _isLoading.postValue(false)
                    Log.d(this.javaClass.simpleName, "No internet connection")
                } finally {
//                    _isLoading.postValue(false)
                    Log.d("${this.javaClass.simpleName}: finally", "isLoading: ${_isLoading.value}")
                    Log.d("${this.javaClass.simpleName}: finally", "isError: ${_isError.value}")
                }
            }
        }
    }

}