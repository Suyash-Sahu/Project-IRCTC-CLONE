package com.example.irctcclone.presentation.features.pnr

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ActivityPnrstatusBinding
import com.example.irctcclone.domain.model.PassengerStatus

class PNRStatusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPnrstatusBinding
    private lateinit var recentPnrAdapter: RecentPNRAdapter
    private lateinit var passengerStatusAdapter: PassengerStatusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPnrstatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerViews()
        setupClickListeners()
    }

    private fun setupToolbar() {
        binding.toolbar.apply {
            btnBack.setOnClickListener { finish() }
            btnShare.setOnClickListener { sharePnrStatus() }
        }
    }

    private fun setupRecyclerViews() {
        // Setup Recent PNR RecyclerView
        recentPnrAdapter = RecentPNRAdapter(
            onPnrClick = { pnr -> fetchPnrStatus(pnr) },
            onDeleteClick = { pnr -> deleteRecentPnr(pnr) }
        )
        binding.rvRecentPnr.apply {
            layoutManager = LinearLayoutManager(this@PNRStatusActivity)
            adapter = recentPnrAdapter
        }

        // Setup Passenger Status RecyclerView
        passengerStatusAdapter = PassengerStatusAdapter()
        binding.rvPassengerStatus.apply {
            layoutManager = LinearLayoutManager(this@PNRStatusActivity)
            adapter = passengerStatusAdapter
        }
    }

    private fun setupClickListeners() {
        binding.btnGetStatus.setOnClickListener {
            val pnr = binding.etPnr.text.toString()
            if (pnr.isNotEmpty()) {
                fetchPnrStatus(pnr)
            } else {
                Toast.makeText(this, "Please enter PNR number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchPnrStatus(pnr: String) {
        // TODO: Implement API call to fetch PNR status
        // For now, showing dummy data
        val dummyPassengers = listOf(
            PassengerStatus(
                name = "John Doe",
                age = 30,
                gender = "Male",
                seatNumber = "B1 23",
                status = "Confirmed"
            ),
            PassengerStatus(
                name = "Jane Doe",
                age = 28,
                gender = "Female",
                seatNumber = "B1 24",
                status = "Confirmed"
            )
        )
        passengerStatusAdapter.submitList(dummyPassengers)
    }

    private fun deleteRecentPnr(pnr: String) {
        // TODO: Implement delete from local storage
        Toast.makeText(this, "PNR $pnr deleted", Toast.LENGTH_SHORT).show()
    }

    private fun sharePnrStatus() {
        // TODO: Implement share functionality
        Toast.makeText(this, "Share functionality coming soon", Toast.LENGTH_SHORT).show()
    }
}