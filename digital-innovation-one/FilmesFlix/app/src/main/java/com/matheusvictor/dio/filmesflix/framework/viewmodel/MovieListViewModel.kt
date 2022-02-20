package com.matheusvictor.dio.filmesflix.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheusvictor.dio.filmesflix.framework.api.MovieRestApiTask
import com.matheusvictor.dio.filmesflix.data.MovieRepository
import com.matheusvictor.dio.filmesflix.domain.Movie
import com.matheusvictor.dio.filmesflix.implementations.MovieDataSourceImplementation
import com.matheusvictor.dio.filmesflix.usecase.MoviesListUseCase
import java.lang.Exception

class MovieListViewModel : ViewModel() {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val moviesRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(moviesRestApiTask)
    private val mMovieRepository = MovieRepository(movieDataSource)
    private val moviesListUseCase = MoviesListUseCase(mMovieRepository)

    fun init() {
        getAllMovies()
    }

    private var mMovieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = mMovieList

    private fun getAllMovies() {
        Thread {
            try {
                mMovieList.postValue(moviesListUseCase.invoke())
            } catch (e: Exception) {
                Log.d(TAG, e.message.toString())
            }
        }.start()
    }

}
