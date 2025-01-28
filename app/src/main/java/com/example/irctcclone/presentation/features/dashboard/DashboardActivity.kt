package com.example.irctcclone.presentation.features.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.irctcclone.databinding.ActivityDashboardBinding
import com.example.irctcclone.presentation.features.mybookings.MyBookingsActivity
import com.example.irctcclone.presentation.features.passengerdetails.PassengerDetailsActivity
import com.example.irctcclone.presentation.features.payment.PaymentActivity
import com.example.irctcclone.presentation.features.pnr.PNRStatusActivity
import com.example.irctcclone.presentation.features.profile.ProfileActivity
import com.example.irctcclone.presentation.features.searchresults.SearchResultsActivity
import com.example.irctcclone.presentation.features.trainstatus.TrainStatusActivity

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        binding.btnPnrStatus.setOnClickListener {
            startActivity(Intent(this, PNRStatusActivity::class.java))
        }
        binding.btnTrainStatus.setOnClickListener {
            startActivity(Intent(this, TrainStatusActivity::class.java))
        }
        binding.btnSearchResults.setOnClickListener {
            startActivity(Intent(this, SearchResultsActivity::class.java))
        }
        binding.btnPassengerDetails.setOnClickListener {
            startActivity(Intent(this, PassengerDetailsActivity::class.java))
        }
        binding.btnMyBookings.setOnClickListener {
            startActivity(Intent(this, MyBookingsActivity::class.java))
        }
        binding.btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        binding.btnPayment.setOnClickListener {
            startActivity(Intent(this, PaymentActivity::class.java))
        }
    }
}