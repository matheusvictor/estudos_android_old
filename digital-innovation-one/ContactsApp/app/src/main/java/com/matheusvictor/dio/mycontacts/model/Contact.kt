package com.matheusvictor.dio.mycontacts.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    var name: String,
    var phone: String,
    var photograph: String
) : Parcelable
