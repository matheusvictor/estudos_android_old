package com.matheusvictor.dio.filmesflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheusvictor.dio.filmesflix.model.Movie

class MovieListViewModel : ViewModel() {

    private val list = arrayListOf<Movie>(
        Movie(
            id = 0,
            title = "Titanic",
            description = null,
            image = null,
            releaseDate = null
        ),
        Movie(
            id = 1,
            title = "Central do Brasil",
            description = null,
            image = null,
            releaseDate = null
        ),
    )

    fun init() {
        getAllMovies()
    }

    private var mMovieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = mMovieList

    fun getAllMovies() {
        mMovieList.value = list
    }

}
