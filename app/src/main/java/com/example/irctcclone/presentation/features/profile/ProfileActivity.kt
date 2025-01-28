package com.example.irctcclone.presentation.features.profile

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupProfile()
    }

    private fun setupToolbar() {
        binding.toolbar.findViewById<View>(R.id.btnBack).setOnClickListener { finish() }
    }

    private fun setupProfile() {
        // TODO: Load user profile data
        binding.apply {
            tvName.text = "John Doe"
            tvEmail.text = "john.doe@example.com"
            tvPhone.text = "+91 9876543210"
            tvAddress.text = "123 Main Street, Mumbai, Maharashtra"
        }
    }
}