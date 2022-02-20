package com.matheusvictor.dio.filmesflix.usecase

import com.matheusvictor.dio.filmesflix.data.MovieRepository

class MoviesListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()

}
