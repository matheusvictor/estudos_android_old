package com.matheusvictor.dio.bussinesscard

import android.app.Application
import com.matheusvictor.dio.bussinesscard.data.AppDatabase
import com.matheusvictor.dio.bussinesscard.data.BusinessCardRepository

class App : Application() {

    private val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
    private val repository: BusinessCardRepository by lazy { BusinessCardRepository(database.businessDAO()) }


}
