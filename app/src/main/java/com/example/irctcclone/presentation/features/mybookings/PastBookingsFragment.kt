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

class PastBookingsFragment : Fragment() {

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
        fetchPastBookings()
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

    private fun fetchPastBookings() {
        // TODO: Implement API call to fetch past bookings
        // For now, showing dummy data
        val dummyBookings = listOf(
            Booking(
                pnr = "9876543210",
                trainNumber = "22201",
                trainName = "Duronto Express",
                journeyDate = "15 Jan 2025",
                source = "Mumbai",
                destination = "Kolkata",
                passengers = emptyList(),
                status = BookingStatus.CONFIRMED,
                classCode = "2A",
                totalFare = 2500.0
            ),
            Booking(
                pnr = "8765432109",
                trainNumber = "12909",
                trainName = "Garib Rath",
                journeyDate = "10 Jan 2025",
                source = "Delhi",
                destination = "Chennai",
                passengers = emptyList(),
                status = BookingStatus.CANCELLED,
                classCode = "3A",
                totalFare = 1800.0
            )
        )
        bookingAdapter.submitList(dummyBookings)
    }
}