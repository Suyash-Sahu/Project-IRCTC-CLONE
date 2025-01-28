package com.example.irctcclone.presentation.features.booking

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ActivityBookTicketBinding
import java.text.SimpleDateFormat
import java.util.*

class BookTicketActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookTicketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupForm()
        updateTimestamp()
    }

    private fun setupToolbar() {
        binding.toolbar.findViewById<View>(R.id.backButton).setOnClickListener { finish() }
        binding.loginButton.setOnClickListener {
            Toast.makeText(this, "Login clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupForm() {
        binding.searchButton.setOnClickListener {
            validateAndSearch()
        }

        binding.classSelector.setOnClickListener {
            // TODO: Show class selection dialog
            Toast.makeText(this, "Class selection coming soon", Toast.LENGTH_SHORT).show()
        }

        binding.quotaSelector.setOnClickListener {
            // TODO: Show quota selection dialog
            Toast.makeText(this, "Quota selection coming soon", Toast.LENGTH_SHORT).show()
        }

        binding.swapButton.setOnClickListener {
            // Swap both code and name
            val fromCode = binding.fromStationCode.text.toString()
            val fromName = binding.fromStationName.text.toString()
            val toCode = binding.toStationCode.text.toString()
            val toName = binding.toStationName.text.toString()

            binding.fromStationCode.setText(toCode)
            binding.fromStationName.text = toName
            binding.toStationCode.setText(fromCode)
            binding.toStationName.text = fromName
        }
    }

    private fun validateAndSearch() {
        val fromCode = binding.fromStationCode.text.toString()
        val toCode = binding.toStationCode.text.toString()
        val date = binding.selectedDateCard.toString() // TODO: Get proper date

        when {
            fromCode.isEmpty() -> {
                Toast.makeText(this, "Please enter source station", Toast.LENGTH_SHORT).show()
            }
            toCode.isEmpty() -> {
                Toast.makeText(this, "Please enter destination station", Toast.LENGTH_SHORT).show()
            }
            date.isEmpty() -> {
                Toast.makeText(this, "Please select journey date", Toast.LENGTH_SHORT).show()
            }
            fromCode == toCode -> {
                Toast.makeText(this, "Source and destination cannot be same", Toast.LENGTH_SHORT).show()
            }
            else -> {
                // TODO: Implement search functionality
                Toast.makeText(this, "Searching trains...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateTimestamp() {
        val sdf = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
        binding.timestampText.text = sdf.format(Date())
    }
}