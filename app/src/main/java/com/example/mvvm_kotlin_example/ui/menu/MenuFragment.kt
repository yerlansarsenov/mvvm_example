package com.example.mvvm_kotlin_example.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mvvm_kotlin_example.databinding.FragmentMenuBinding
import com.example.mvvm_kotlin_example.ui.BaseFragment
import com.example.mvvm_kotlin_example.ui.ContainerActivity
import com.example.mvvm_kotlin_example.ui.movies.MoviesFragment

/**
 * Created by Sarsenov Yerlan on 03.11.2020.
 */
class MenuFragment : BaseFragment() {

    val listener = View.OnClickListener {
        val s = (it as Button).text
        (activity as ContainerActivity).changeFragment(MoviesFragment.newInstance(s as String))
    }
    val viewModel = MenuViewModel(listener)

    override val title: String
        get() = "Genres"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMenuBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}