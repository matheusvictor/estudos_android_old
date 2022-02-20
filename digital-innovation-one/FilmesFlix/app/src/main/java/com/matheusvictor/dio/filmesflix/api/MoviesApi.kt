package com.matheusvictor.dio.filmesflix.api

import com.matheusvictor.dio.filmesflix.model.Movie
import retrofit2.http.GET

interface MoviesApi {

    @GET("natanfelipe/FilmesFlixJson/main/moviesList")
    fun getAllMovies(): List<Movie>

}
