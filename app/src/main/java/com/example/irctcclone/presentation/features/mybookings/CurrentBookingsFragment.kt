package com.example.irctcclone.presentation.features.mybookings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irctcclone.databinding.FragmentBookingsBinding
import com.example.irctcclone.presentation.features.mybookings.models.Booking

class CurrentBookingsFragment : Fragment() {

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
        fetchCurrentBookings()
    }

    private fun setupRecyclerView() {
        bookingAdapter = BookingAdapter()
        binding.rvBookings.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = bookingAdapter
        }
    }

    private fun fetchCurrentBookings() {
        // TODO: Implement API call to fetch current bookings
        // For now, showing dummy data
        val dummyBookings = listOf(
            Booking("Rajdhani Express", "12345", "27 Jan 2025", "Confirmed"),
            Booking("Shatabdi Express", "12001", "28 Jan 2025", "Waitlisted")
        )
        bookingAdapter.submitList(dummyBookings)
    }
}

