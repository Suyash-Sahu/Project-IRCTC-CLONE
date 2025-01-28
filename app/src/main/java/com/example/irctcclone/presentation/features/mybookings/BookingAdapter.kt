package com.example.irctcclone.presentation.features.mybookings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ItemBookingBinding
import com.example.irctcclone.domain.model.Booking
import com.example.irctcclone.domain.model.BookingStatus

class BookingAdapter : ListAdapter<Booking, BookingAdapter.ViewHolder>(BookingDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBookingBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemBookingBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Booking) {
            binding.apply {
                tvBookingTrainName.text = item.trainName
                tvBookingTrainNumber.text = item.trainNumber
                tvBookingDate.text = item.journeyDate
                tvBookingStatus.text = item.status.toString()

                // Set text color based on status
                val statusColor = when (item.status) {
                    BookingStatus.CONFIRMED -> R.color.success
                    BookingStatus.WAITLISTED, BookingStatus.RAC -> R.color.warning
                    BookingStatus.CANCELLED -> R.color.error
                    BookingStatus.PENDING -> R.color.text_secondary
                }
                tvBookingStatus.setTextColor(ContextCompat.getColor(root.context, statusColor))
            }
        }
    }
}

class BookingDiffCallback : DiffUtil.ItemCallback<Booking>() {
    override fun areItemsTheSame(oldItem: Booking, newItem: Booking): Boolean {
        return oldItem.pnr == newItem.pnr
    }

    override fun areContentsTheSame(oldItem: Booking, newItem: Booking): Boolean {
        return oldItem == newItem
    }
}