package com.matheusvictor.dio.filmesflix.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.matheusvictor.dio.filmesflix.R
import com.matheusvictor.dio.filmesflix.adapter.MoviesAdapter
import com.matheusvictor.dio.filmesflix.model.Movie
import com.matheusvictor.dio.filmesflix.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieLiViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieLiViewModel =
            ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieLiViewModel.init()

        observer()
    }

    private fun observer() {
        movieLiViewModel.movieList.observe(this, Observer { list ->
            populateMovieList(list)
        })
    }

    private fun populateMovieList(list: List<Movie>) {
        rv_movie_list.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }

}