package com.example.mvvm_kotlin_example.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_kotlin_example.databinding.MoviesBinding
import com.example.mvvm_kotlin_example.ui.BaseFragment
import com.example.mvvm_kotlin_example.ui.ContainerActivity
import com.example.mvvm_kotlin_example.ui.movie_detail.MovieDetailFragment
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Sarsenov Yerlan on 03.11.2020.
 */
class MoviesFragment : BaseFragment(), MoviesAdapter.OnItemClickListener {

    val titleKey = "GENRE"

    override val title: String
        get() = arguments?.get(titleKey) as String


    companion object {
        @JvmStatic
        fun newInstance(string: String) = MoviesFragment().apply {
            arguments = Bundle().apply {
                putString(titleKey, string)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: MovieListViewModel by lazy { ViewModelProvider(this, MoviesVMFactory(title)).get(MovieListViewModel::class.java) }
        val binding = MoviesBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.recyclerViewMovies.layoutManager = LinearLayoutManager(context)
        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            val adapter = MoviesAdapter(it, this)
            binding.recyclerViewMovies.adapter = adapter
        })
        return binding.root
    }

    override fun onClick(title: String, imdbId: String) {
        (activity as ContainerActivity).changeFragment(MovieDetailFragment.newInstance(title, imdbId))
    }

}