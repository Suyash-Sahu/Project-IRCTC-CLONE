package com.example.irctcclone.presentation.features.mybookings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irctcclone.databinding.FragmentBookingsBinding
import com.example.irctcclone.presentation.features.mybookings.models.Booking

class PastBookingsFragment : Fragment() {

    private lateinit var binding: FragmentBookingsBinding
    private lateinit var bookingAdapter: BookingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        fetchPastBookings()
    }

    private fun setupRecyclerView() {
        bookingAdapter = BookingAdapter()
        binding.rvBookings.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = bookingAdapter
        }
    }

    private fun fetchPastBookings() {
        // TODO: Implement API call to fetch past bookings
        // For now, showing dummy data
        val dummyBookings = listOf(
            Booking("Duronto Express", "22201", "15 Jan 2025", "Completed"),
            Booking("Garib Rath", "12909", "10 Jan 2025", "Cancelled")
        )
        bookingAdapter.submitList(dummyBookings)
    }
}