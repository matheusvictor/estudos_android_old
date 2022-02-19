package com.matheusvictor.dio.mycontacts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.matheusvictor.dio.mycontacts.listener.ClickItemContactListener
import com.matheusvictor.dio.mycontacts.R
import com.matheusvictor.dio.mycontacts.model.Contact

class ContactAdapter(var contactListener: ClickItemContactListener) :
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val list: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false) // card view
        return ContactAdapterViewHolder(view, list, contactListener)
    }

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(list: List<Contact>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    // inner class
    class ContactAdapterViewHolder(
        itemView: View,
        var list: List<Contact>,
        var listener: ClickItemContactListener
    ) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        private val ivPhotograph: ImageView = itemView.findViewById(R.id.iv_photograph)

        init {
            itemView.setOnClickListener {
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact) {
            tvName.text = contact.name
            tvPhone.text = contact.phone
        }
    }

    /*
    pt-bt: O Adapter é responsável por fazer o gerenciamento da lista, enquanto a classe ViewHolder
    é responsável  pelo gerenciamento de cada item dentro dessa lista
    */

}
