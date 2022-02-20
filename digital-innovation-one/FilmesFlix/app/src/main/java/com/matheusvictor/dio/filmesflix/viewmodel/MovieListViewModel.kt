package com.matheusvictor.dio.filmesflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheusvictor.dio.filmesflix.api.MovieRestApiTask
import com.matheusvictor.dio.filmesflix.model.Movie
import com.matheusvictor.dio.filmesflix.repository.MovieRepository
import java.lang.Exception

class MovieListViewModel : ViewModel() {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val moviesRestApiTask = MovieRestApiTask()
    private val mMovieRepository = MovieRepository(moviesRestApiTask)

    fun init() {
        getAllMovies()
    }

    private var mMovieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = mMovieList

    private fun getAllMovies() {
        Thread {
            try {
                mMovieList.postValue(mMovieRepository.getAllMovies())
            } catch (e: Exception) {
                Log.d(TAG, e.message.toString())
            }
        }.start()
    }

}
