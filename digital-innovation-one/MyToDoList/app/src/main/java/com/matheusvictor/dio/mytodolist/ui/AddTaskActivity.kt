package com.matheusvictor.dio.mytodolist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.matheusvictor.dio.mytodolist.databinding.ActivityAddTaskBinding
import com.matheusvictor.dio.mytodolist.extensions.format
import com.matheusvictor.dio.mytodolist.extensions.formatText
import java.util.*

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListeners()

    }

    private fun insertListeners() {
        binding.taskDate.editText?.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.addOnPositiveButtonClickListener { dateSelected ->
                binding.taskDate.formatText = Date(dateSelected).format()
            }
            datePicker.show(supportFragmentManager, "TAG_DATE_PICKER")
        }
    }

}
