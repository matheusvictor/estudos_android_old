package com.matheusvictor.dio.bussinesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.matheusvictor.dio.bussinesscard.App
import com.matheusvictor.dio.bussinesscard.R
import com.matheusvictor.dio.bussinesscard.data.BusinessCard
import com.matheusvictor.dio.bussinesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.inputName.editText?.text.toString(),
                phone = binding.inputPhone.editText?.text.toString(),
                email = binding.inputEmail.editText?.text.toString(),
                company = binding.inputCompany.editText?.text.toString(),
                colorBackground = binding.inputColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}
