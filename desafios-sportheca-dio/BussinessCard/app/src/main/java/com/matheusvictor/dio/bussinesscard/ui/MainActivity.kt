package com.matheusvictor.dio.bussinesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matheusvictor.dio.bussinesscard.R
import com.matheusvictor.dio.bussinesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}