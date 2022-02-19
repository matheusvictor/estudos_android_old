package com.matheusvictor.dio.mycontacts.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.matheusvictor.dio.mycontacts.R
import com.matheusvictor.dio.mycontacts.model.Contact

class ContactDetailActivity : AppCompatActivity() {

    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        initToolbar()
        getExtras()
        bindViews()
    }

    private fun getExtras() {
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    private fun bindViews() {
        findViewById<TextView>(R.id.tv_name).text = contact?.name
        findViewById<TextView>(R.id.tv_phone).text = contact?.phone
    }

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }

}
