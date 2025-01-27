package com.example.irctcclone.presentation.features.mybookings

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class BookingsPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CurrentBookingsFragment()
            1 -> PastBookingsFragment()
            else -> throw IllegalStateException("Invalid position $position")
        }
    }
}