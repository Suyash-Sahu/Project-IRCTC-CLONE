package com.example.irctcclone.presentation.features.searchresults

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ActivitySearchResultsBinding
import com.example.irctcclone.domain.model.Train

class SearchResultsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchResultsBinding
    private lateinit var trainAdapter: TrainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        loadTrains()
    }

    private fun setupToolbar() {
        binding.toolbar.findViewById<View>(R.id.btnBack).setOnClickListener { finish() }
    }

    private fun setupRecyclerView() {
        trainAdapter = TrainAdapter()
        binding.rvTrains.apply {
            layoutManager = LinearLayoutManager(this@SearchResultsActivity)
            adapter = trainAdapter
        }
    }

    private fun loadTrains() {
        // TODO: Implement API call to load trains
        // For now, using dummy data
        val dummyTrains = listOf(
            Train(
                trainNumber = "12345",
                trainName = "Rajdhani Express",
                source = "Delhi",
                destination = "Mumbai",
                departureTime = "16:00",
                arrivalTime = "08:00",
                duration = "16h",
                distance = "1384 km",
                availableClasses = listOf("1A", "2A", "3A", "SL"),
                runsOn = listOf("Mon", "Wed", "Fri")
            ),
            Train(
                trainNumber = "12001",
                trainName = "Shatabdi Express",
                source = "Mumbai",
                destination = "Pune",
                departureTime = "06:00",
                arrivalTime = "10:00",
                duration = "4h",
                distance = "192 km",
                availableClasses = listOf("CC", "EC"),
                runsOn = listOf("Daily")
            )
        )
        trainAdapter.submitList(dummyTrains)
    }
}