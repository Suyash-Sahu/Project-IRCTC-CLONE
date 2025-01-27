package com.example.irctcclone.presentation.features.pnr

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.irctcclone.R

class PNRStatusActivity : AppCompatActivity() {

    private lateinit var binding: activity_pnrstatusBinding
    private lateinit var recentPnrAdapter: RecentPNRAdapter
    private lateinit var passengerStatusAdapter: PassengerStatusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = activity_pnrstatusBinding.inflate(layoutInflater)
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
            val pnrNumber = binding.etPnrNumber.text.toString()
            if (validatePnr(pnrNumber)) {
                fetchPnrStatus(pnrNumber)
            }
        }
    }

    private fun validatePnr(pnr: String): Boolean {
        return when {
            pnr.isEmpty() -> {
                binding.etPnrNumber.error = "Please enter PNR number"
                false
            }
            pnr.length != 10 -> {
                binding.etPnrNumber.error = "PNR should be 10 digits"
                false
            }
            else -> true
        }
    }

    private fun fetchPnrStatus(pnr: String) {
        // TODO: Implement API call to fetch PNR status
        // For now, showing dummy data
        showPnrStatus(
            PnrStatus(
                pnrNumber = pnr,
                trainNumber = "12345",
                trainName = "RAJDHANI EXPRESS",
                journeyDate = "27 Jan 2025",
                fromStation = "NDLS",
                toStation = "MMCT",
                passengers = listOf(
                    PassengerStatus("Passenger 1", "CNF/B3/34", "CNF"),
                    PassengerStatus("Passenger 2", "CNF/B3/35", "CNF")
                )
            )
        )
    }

    private fun showPnrStatus(status: PnrStatus) {
        binding.apply {
            cardPnrStatus.visibility = View.VISIBLE
            tvTrainNumber.text = "${status.trainNumber} - ${status.trainName}"
            tvJourneyDate.text = "Journey Date: ${status.journeyDate}"
            tvFromStation.text = status.fromStation
            tvToStation.text = status.toStation
            passengerStatusAdapter.submitList(status.passengers)
        }
    }

    private fun deleteRecentPnr(pnr: String) {
        // TODO: Implement delete from local storage
    }

    private fun sharePnrStatus() {
        // TODO: Implement share functionality
    }
}