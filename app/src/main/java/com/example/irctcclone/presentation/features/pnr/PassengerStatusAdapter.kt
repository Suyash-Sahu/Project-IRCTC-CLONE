package com.example.irctcclone.presentation.features.pnr

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.irctcclone.R

class PassengerStatusAdapter : ListAdapter<PassengerStatus, PassengerStatusAdapter.ViewHolder>(PassengerStatusDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPassengerStatusBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemPassengerStatusBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PassengerStatus) {
            binding.apply {
                tvPassengerNumber.text = item.passengerNumber
                tvBookingStatus.text = item.bookingStatus
                tvCurrentStatus.text = item.currentStatus

                // Set text color based on status
                val statusColor = when {
                    item.currentStatus.startsWith("CNF") -> R.color.success
                    item.currentStatus.startsWith("WL") -> R.color.warning
                    else -> R.color.error
                }
                tvCurrentStatus.setTextColor(ContextCompat.getColor(root.context, statusColor))
            }
        }
    }
}

class PassengerStatusDiffCallback : DiffUtil.ItemCallback<PassengerStatus>() {
    override fun areItemsTheSame(oldItem: PassengerStatus, newItem: PassengerStatus): Boolean {
        return oldItem.passengerNumber == newItem.passengerNumber
    }

    override fun areContentsTheSame(oldItem: PassengerStatus, newItem: PassengerStatus): Boolean {
        return oldItem == newItem
    }
}