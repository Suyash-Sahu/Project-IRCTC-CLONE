package com.example.irctcclone.presentation.features.searchresults

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.irctcclone.databinding.ItemTrainBinding
import com.example.irctcclone.presentation.features.searchresults.models.Train

class TrainAdapter : ListAdapter<Train, TrainAdapter.ViewHolder>(TrainDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTrainBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemTrainBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Train) {
            binding.apply {
                tvTrainName.text = item.name
                tvTrainNumber.text = item.number
                tvDepartureArrival.text = item.departureArrival
                tvDuration.text = item.duration
                tvAvailability.text = item.availability

                // Set text color based on availability
                val availabilityColor = when {
                    item.availability.contains("Available", true) -> R.color.success
                    item.availability.contains("Waitlist", true) -> R.color.warning
                    else -> R.color.error
                }
                tvAvailability.setTextColor(ContextCompat.getColor(root.context, availabilityColor))
            }
        }
    }
}

class TrainDiffCallback : DiffUtil.ItemCallback<Train>() {
    override fun areItemsTheSame(oldItem: Train, newItem: Train): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: Train, newItem: Train): Boolean {
        return oldItem == newItem
    }
}