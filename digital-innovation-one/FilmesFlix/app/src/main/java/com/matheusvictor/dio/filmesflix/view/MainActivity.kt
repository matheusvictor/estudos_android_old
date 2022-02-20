package com.matheusvictor.dio.filmesflix.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.matheusvictor.dio.filmesflix.R
import com.matheusvictor.dio.filmesflix.adapter.MoviesAdapter
import com.matheusvictor.dio.filmesflix.domain.Movie
import com.matheusvictor.dio.filmesflix.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieListViewModel =
            ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()

        observer()
        showLoadVisibility(true)
    }

    private fun observer() {
        movieListViewModel.movieList.observe(this, Observer { list ->
            if (list.isNotEmpty()) {
                populateMovieList(list)
                showLoadVisibility(false)
            }
        })
    }

    private fun populateMovieList(list: List<Movie>) {
        rv_movie_list.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }

    private fun showLoadVisibility(isLoading: Boolean) {
        progress_bar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}
