package com.matheusvictor.dio.mycontacts.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.matheusvictor.dio.mycontacts.R
import com.matheusvictor.dio.mycontacts.activity.ContactDetailActivity.Companion.EXTRA_CONTACT
import com.matheusvictor.dio.mycontacts.adapter.ContactAdapter
import com.matheusvictor.dio.mycontacts.listener.ClickItemContactListener
import com.matheusvictor.dio.mycontacts.model.Contact

class MainActivity : AppCompatActivity(), ClickItemContactListener {

    private val rvList: RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }

    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        fetchContactList()
        initDrawer()
        bindView()

    }

    private fun bindView() {
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        updateList()
    }

    private fun fetchContactList() {
        val list = arrayListOf(
            Contact("Matheus Victor", "(00) 0000-0000", "img.png"),
            Contact("Jorel's Brother", "(99) 9999-9999", "img.png"),
            Contact("Mr. Adelino", "(22) 2222-2222", "img.png")
        )

        getInstanceSharedPreferences().edit {
            // convert Contact class object to Json with Gson lib
            putString("contacts", Gson().toJson(list))
            commit()
        }
    }

    private fun getInstanceSharedPreferences(): SharedPreferences {
        return getSharedPreferences("com.matheusvictor.dio.PREFERENCES", Context.MODE_PRIVATE)
    }

    private fun updateList() {
        adapter.updateList(getContactList())
    }

    private fun getContactList(): List<Contact> {
        val list = getInstanceSharedPreferences().getString("contacts", "[]")
        val turnsType = object : TypeToken<List<Contact>>() {}.type
        return Gson().fromJson(list, turnsType)
    }

    private fun initDrawer() {
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item1 -> {
                showToast("Item 1")
                true
            }
            R.id.item2 -> {
                showToast("Item 2")
                true
            }
            else -> return onOptionsItemSelected(item)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, ContactDetailActivity::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }

}
