package com.example.irctcclone.presentation.features.mybookings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irctcclone.databinding.FragmentBookingsBinding
import com.example.irctcclone.domain.model.Booking
import com.example.irctcclone.domain.model.BookingStatus

class CurrentBookingsFragment : Fragment() {

    private var _binding: FragmentBookingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var bookingAdapter: BookingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        fetchCurrentBookings()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
            Booking(
                pnr = "1234567890",
                trainNumber = "12345",
                trainName = "Rajdhani Express",
                journeyDate = "27 Jan 2025",
                source = "Delhi",
                destination = "Mumbai",
                passengers = emptyList(),
                status = BookingStatus.CONFIRMED,
                classCode = "3A",
                totalFare = 1500.0
            ),
            Booking(
                pnr = "0987654321",
                trainNumber = "12001",
                trainName = "Shatabdi Express",
                journeyDate = "28 Jan 2025",
                source = "Mumbai",
                destination = "Pune",
                passengers = emptyList(),
                status = BookingStatus.WAITLISTED,
                classCode = "CC",
                totalFare = 800.0
            )
        )
        bookingAdapter.submitList(dummyBookings)
    }
}
