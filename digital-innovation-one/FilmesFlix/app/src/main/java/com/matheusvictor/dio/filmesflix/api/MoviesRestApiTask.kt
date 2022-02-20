package com.matheusvictor.dio.filmesflix.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesRestApiTask {

    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/"
    }

    private fun movieProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun retrofitApi(): MoviesApi = movieProvider().create(MoviesApi::class.java)

}
