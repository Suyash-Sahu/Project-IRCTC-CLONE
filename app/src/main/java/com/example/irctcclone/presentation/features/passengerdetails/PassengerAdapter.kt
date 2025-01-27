package com.example.irctcclone.presentation.features.passengerdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.irctcclone.databinding.ItemPassengerBinding
import com.example.irctcclone.presentation.features.passengerdetails.models.Passenger

class PassengerAdapter : ListAdapter<Passenger, PassengerAdapter.ViewHolder>(PassengerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPassengerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemPassengerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Passenger) {
            binding.apply {
                tvPassengerName.text = item.name
                tvPassengerAge.text = "Age: ${item.age}"
                tvPassengerGender.text = "Gender: ${item.gender}"
            }
        }
    }
}

class PassengerDiffCallback : DiffUtil.ItemCallback<Passenger>() {
    override fun areItemsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
        return oldItem == newItem
    }
}