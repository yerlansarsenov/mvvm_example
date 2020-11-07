package com.example.mvvm_kotlin_example.ui

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Created by Sarsenov Yerlan on 03.11.2020.
 */
abstract class BaseFragment : Fragment() {

    abstract val title: String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity!!.title = title
    }
}