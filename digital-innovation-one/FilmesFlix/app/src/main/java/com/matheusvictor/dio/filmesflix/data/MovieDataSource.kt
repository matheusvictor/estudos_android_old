package com.matheusvictor.dio.filmesflix.data

import com.matheusvictor.dio.filmesflix.domain.Movie

interface MovieDataSource {

    fun getAllMovies(): List<Movie>

}
