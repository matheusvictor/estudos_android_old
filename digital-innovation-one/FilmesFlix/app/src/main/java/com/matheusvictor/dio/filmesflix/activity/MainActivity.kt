package com.matheusvictor.dio.filmesflix.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matheusvictor.dio.filmesflix.R
import com.matheusvictor.dio.filmesflix.adapter.MoviesAdapter
import com.matheusvictor.dio.filmesflix.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val movieList = arrayListOf<Movie>(
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateMovieList()
    }

    private fun populateMovieList() {
        rv_movie_list.apply {
            hasFixedSize()
            adapter = MoviesAdapter(movieList)
        }
    }

}