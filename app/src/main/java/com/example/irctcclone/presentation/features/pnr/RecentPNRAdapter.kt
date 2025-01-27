package com.example.irctcclone.presentation.features.pnr

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.irctcclone.R

class RecentPNRAdapter(
    private val onPnrClick: (String) -> Unit,
    private val onDeleteClick: (String) -> Unit
) : ListAdapter<RecentPNR, RecentPNRAdapter.ViewHolder>(RecentPNRDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecentPnrBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemRecentPnrBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RecentPNR) {
            binding.apply {
                tvPnrNumber.text = item.pnrNumber
                tvTrainInfo.text = "${item.trainNumber} - ${item.trainName}"

                root.setOnClickListener { onPnrClick(item.pnrNumber) }
                btnDelete.setOnClickListener { onDeleteClick(item.pnrNumber) }
            }
        }
    }
}

class RecentPNRDiffCallback : DiffUtil.ItemCallback<RecentPNR>() {
    override fun areItemsTheSame(oldItem: RecentPNR, newItem: RecentPNR): Boolean {
        return oldItem.pnrNumber == newItem.pnrNumber
    }

    override fun areContentsTheSame(oldItem: RecentPNR, newItem: RecentPNR): Boolean {
        return oldItem == newItem
    }
}