package com.example.irctcclone.presentation.features.trainstatus

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ItemScheduleBinding
import com.example.irctcclone.presentation.features.trainstatus.models.Schedule

class ScheduleAdapter : ListAdapter<Schedule, ScheduleAdapter.ViewHolder>(ScheduleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemScheduleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemScheduleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Schedule) {
            binding.apply {
                tvStationName.text = item.stationName
                tvArrivalTime.text = item.arrivalTime
                tvDepartureTime.text = item.departureTime
                tvStatus.text = item.status

                // Set text color based on status
                val statusColor = when (item.status) {
                    "On Time" -> R.color.success
                    "Delayed" -> R.color.error
                    else -> R.color.text_secondary
                }
                tvStatus.setTextColor(ContextCompat.getColor(root.context, statusColor))
            }
        }
    }
}

class ScheduleDiffCallback : DiffUtil.ItemCallback<Schedule>() {
    override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
        return oldItem.stationName == newItem.stationName
    }

    override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
        return oldItem == newItem
    }
}