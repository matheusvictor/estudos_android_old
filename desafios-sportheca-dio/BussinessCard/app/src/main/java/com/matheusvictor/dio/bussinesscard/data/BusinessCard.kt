package com.matheusvictor.dio.bussinesscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessCard(
    val name: String,
    val phone: String,
    val email: String,
    val company: String,
    val colorBackground: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
