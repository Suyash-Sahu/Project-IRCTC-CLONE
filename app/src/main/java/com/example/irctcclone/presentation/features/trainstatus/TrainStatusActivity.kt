package com.example.irctcclone.presentation.features.trainstatus

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ActivityTrainStatusBinding
import com.example.irctcclone.presentation.features.trainstatus.models.Schedule
import com.example.irctcclone.presentation.features.trainstatus.models.TrainStatus

class TrainStatusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrainStatusBinding
    private lateinit var scheduleAdapter: ScheduleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrainStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        setupClickListeners()
    }

    private fun setupToolbar() {
        binding.toolbar.findViewById<View>(R.id.btnBack).setOnClickListener { finish() }
    }

    private fun setupRecyclerView() {
        scheduleAdapter = ScheduleAdapter()
        binding.rvSchedule.apply {
            layoutManager = LinearLayoutManager(this@TrainStatusActivity)
            adapter = scheduleAdapter
        }
    }

    private fun setupClickListeners() {
        binding.btnCheckStatus.setOnClickListener {
            val trainNumber = binding.etTrainNumber.text.toString()
            val date = binding.etDate.text.toString()
            if (validateInput(trainNumber, date)) {
                fetchTrainStatus(trainNumber, date)
            }
        }
    }

    private fun validateInput(trainNumber: String, date: String): Boolean {
        return when {
            trainNumber.isEmpty() -> {
                binding.etTrainNumber.error = "Please enter train number"
                false
            }
            date.isEmpty() -> {
                binding.etDate.error = "Please select date"
                false
            }
            else -> true
        }
    }

    private fun fetchTrainStatus(trainNumber: String, date: String) {
        // TODO: Implement API call to fetch train status
        // For now, showing dummy data
        showTrainStatus(
            TrainStatus(
                trainNumber = trainNumber,
                trainName = "Rajdhani Express",
                currentStation = "NDLS",
                nextStation = "GZB",
                status = "On Time",
                schedule = listOf(
                    Schedule("NDLS", "10:00 AM", "10:15 AM", "Departed"),
                    Schedule("GZB", "11:00 AM", "11:15 AM", "On Time")
                )
            )
        )
    }

    private fun showTrainStatus(status: TrainStatus) {
        binding.layoutStatus.visibility = View.VISIBLE
        binding.tvTrainName.text = "${status.trainNumber} - ${status.trainName}"
        binding.tvCurrentStation.text = "Current Station: ${status.currentStation}"
        binding.tvNextStation.text = "Next Station: ${status.nextStation}"
        binding.tvStatus.text = "Status: ${status.status}"
        scheduleAdapter.submitList(status.schedule)
    }
}