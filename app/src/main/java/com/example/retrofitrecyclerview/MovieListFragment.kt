package com.example.retrofitrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitrecyclerview.databinding.MovieListFragmentBinding

class MovieListFragment: Fragment() {

    private val viewModel: MovieViewModel by lazy {
        ViewModelProvider(this).get(MovieViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MovieListFragmentBinding.inflate(inflater, container, false)
        //This allows binding to observe the LiveData
        binding.lifecycleOwner = this

        //This connects the xml variable with kotlin one
        binding.viewModel = viewModel

        //Connects an adapter to the xml recyclerView
        binding.movieList.adapter = MovieRecyclerViewAdapter()

        //Return binding root as view
        return binding.root
    }
}