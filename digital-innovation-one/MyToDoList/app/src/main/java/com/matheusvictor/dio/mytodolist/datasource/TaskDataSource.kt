package com.matheusvictor.dio.mytodolist.datasource

import com.matheusvictor.dio.mytodolist.model.Task

object TaskDataSource {
    private val list = arrayListOf<Task>()

    fun getList() = list.toList()

    fun insertTask(task: Task) {
        if (task.id == 0) {
            list.add(task.copy(id = list.size + 1))
        } else {
            list.remove(task)
            list.add(task)
        }
    }

    fun findById(taskId: Int) = list.find { task -> task.id == taskId }

    fun deleteTask(task: Task) {
        list.remove(task)
    }

}