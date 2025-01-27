package com.example.irctcclone.presentation.features.mybookings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ActivityMyBookingsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MyBookingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyBookingsBinding
    private lateinit var bookingsPagerAdapter: BookingsPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyBookingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupViewPager()
    }

    private fun setupToolbar() {
        binding.toolbar.findViewById<View>(R.id.btnBack).setOnClickListener { finish() }
    }

    private fun setupViewPager() {
        bookingsPagerAdapter = BookingsPagerAdapter(this)
        binding.viewPager.adapter = bookingsPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Current"
                1 -> "Past"
                else -> null
            }
        }.attach()
    }
}