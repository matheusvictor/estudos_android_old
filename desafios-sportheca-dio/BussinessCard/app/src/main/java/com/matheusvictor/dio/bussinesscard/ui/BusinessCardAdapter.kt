package com.matheusvictor.dio.bussinesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.matheusvictor.dio.bussinesscard.data.BusinessCard
import com.matheusvictor.dio.bussinesscard.databinding.ItemBusinessCardBinding

class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemBusinessCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binding(item: BusinessCard) {
            binding.tvName.text = item.name
            binding.tvPhone.text = item.phone
            binding.tvEmail.text = item.email
            binding.tvCompany.text = item.company
            binding.cardContent.setBackgroundColor(Color.parseColor(item.colorBackground))
            binding.cardContent.setOnClickListener {
                listenerShare(it)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<BusinessCard>() {

    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean =
        oldItem.id == newItem.id

}
