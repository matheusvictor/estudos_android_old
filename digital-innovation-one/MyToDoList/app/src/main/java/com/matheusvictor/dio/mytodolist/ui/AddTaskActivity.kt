package com.matheusvictor.dio.mytodolist.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.matheusvictor.dio.mytodolist.databinding.ActivityAddTaskBinding
import com.matheusvictor.dio.mytodolist.datasource.TaskDataSource
import com.matheusvictor.dio.mytodolist.extensions.format
import com.matheusvictor.dio.mytodolist.extensions.formatText
import com.matheusvictor.dio.mytodolist.model.Task
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

        binding.taskHour.editText?.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build()

            timePicker.addOnPositiveButtonClickListener {
                val hour =
                    if (timePicker.hour in 0..9) "0${timePicker.hour}" else timePicker.hour
                val minute =
                    if (timePicker.minute in 0..9) "0${timePicker.minute}" else timePicker.minute
                binding.taskHour.formatText = "${hour}:${minute}"
            }

            timePicker.show(supportFragmentManager, null)
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }

        binding.btnAddTask.setOnClickListener {
            val newTask = Task(
                title = binding.taskTitle.formatText,
                description = binding.taskDescription.formatText,
                date = binding.taskDate.formatText,
                hour = binding.taskHour.formatText
            )
            TaskDataSource.insertTask(newTask)
            Log.e("TEST", "teste" + TaskDataSource.getList())
        }

    }

}
