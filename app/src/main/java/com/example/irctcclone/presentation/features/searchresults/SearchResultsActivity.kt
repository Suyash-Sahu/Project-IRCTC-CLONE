package com.example.irctcclone.presentation.features.searchresults

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ActivitySearchResultsBinding
import com.example.irctcclone.presentation.features.searchresults.models.Train

class SearchResultsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchResultsBinding
    private lateinit var trainAdapter: TrainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        fetchSearchResults()
    }

    private fun setupToolbar() {
        binding.toolbar.findViewById<View>(R.id.btnBack).setOnClickListener { finish() }
    }

    private fun setupRecyclerView() {
        trainAdapter = TrainAdapter()
        binding.rvTrainList.apply {
            layoutManager = LinearLayoutManager(this@SearchResultsActivity)
            adapter = trainAdapter
        }
    }

    private fun fetchSearchResults() {
        // TODO: Implement API call to fetch search results
        // For now, showing dummy data
        val dummyTrains = listOf(
            Train("Rajdhani Express", "12345", "10:00 AM - 06:00 PM", "8h", "Available"),
            Train("Shatabdi Express", "12001", "07:00 AM - 01:00 PM", "6h", "Waitlist")
        )
        trainAdapter.submitList(dummyTrains)
    }
}