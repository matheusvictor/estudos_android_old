package com.matheusvictor.dio.filmesflix.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val image: String?,
    val description: String?,
    val releaseDate: String?
) : Parcelable