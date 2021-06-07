package com.example.retrofitrecyclerview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieViewModel: ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            try {
                var result = MovieApi.apiService.getMovies()
                _status.value = "Success: ${result.size}"
                if (result.isNotEmpty()) {
                    _movieList.value = result
                }
            } catch (error: Exception) {
                _status.value = "ERROR: ${error.message}"
            }
        }
    }

}