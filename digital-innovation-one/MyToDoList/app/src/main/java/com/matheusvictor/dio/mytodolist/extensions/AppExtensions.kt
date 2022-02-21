package com.matheusvictor.dio.mytodolist.extensions

import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

private val locale = Locale("pt", "BR")

fun Date.format(): String {
    return SimpleDateFormat("dd/MM/yyyy", locale).format(this)
}

var TextInputLayout.formatText: String
    get() = editText?.text?.toString() ?: ""
    set(value) {
        editText?.setText(value)
    }