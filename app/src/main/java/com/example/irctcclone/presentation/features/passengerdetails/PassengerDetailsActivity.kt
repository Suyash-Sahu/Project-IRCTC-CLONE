package com.example.irctcclone.presentation.features.passengerdetails

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ActivityPassengerDetailsBinding
import com.example.irctcclone.presentation.features.passengerdetails.models.Passenger

class PassengerDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPassengerDetailsBinding
    private lateinit var passengerAdapter: PassengerAdapter
    private val passengers = mutableListOf<Passenger>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPassengerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        setupClickListeners()
    }

    private fun setupToolbar() {
        binding.toolbar.findViewById<View>(R.id.btnBack).setOnClickListener { finish() }
    }

    private fun setupRecyclerView() {
        passengerAdapter = PassengerAdapter()
        binding.rvPassengers.apply {
            layoutManager = LinearLayoutManager(this@PassengerDetailsActivity)
            adapter = passengerAdapter
        }
    }

    private fun setupClickListeners() {
        binding.btnAddPassenger.setOnClickListener {
            val name = binding.etPassengerName.text.toString()
            val age = binding.etPassengerAge.text.toString()
            val gender = binding.etPassengerGender.text.toString()
            if (validateInput(name, age, gender)) {
                addPassenger(name, age, gender)
            }
        }
    }

    private fun validateInput(name: String, age: String, gender: String): Boolean {
        return when {
            name.isEmpty() -> {
                binding.etPassengerName.error = "Please enter passenger name"
                false
            }
            age.isEmpty() -> {
                binding.etPassengerAge.error = "Please enter age"
                false
            }
            gender.isEmpty() -> {
                binding.etPassengerGender.error = "Please select gender"
                false
            }
            else -> true
        }
    }

    private fun addPassenger(name: String, age: String, gender: String) {
        passengers.add(Passenger(name, age.toInt(), gender))
        passengerAdapter.submitList(passengers.toList()) // Create a new list to trigger update
        binding.etPassengerName.text?.clear()
        binding.etPassengerAge.text?.clear()
        binding.etPassengerGender.text?.clear()
    }
}