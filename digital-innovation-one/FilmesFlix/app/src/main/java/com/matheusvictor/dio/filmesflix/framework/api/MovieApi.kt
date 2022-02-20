package com.matheusvictor.dio.filmesflix.framework.api

import com.matheusvictor.dio.filmesflix.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("the-bugs/estudos_android/main/digital-innovation-one/FilmesFlix.json")
    fun getAllMovies(): Call<List<Movie>>

}
