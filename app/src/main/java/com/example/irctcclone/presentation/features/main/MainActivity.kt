package com.example.irctcclone.presentation.features.main

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.irctcclone.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var backButton: ImageButton
    private lateinit var loginButton: TextView
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        // Initialize toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Initialize views
        backButton = findViewById(R.id.backButton)
        loginButton = findViewById(R.id.loginButton)
        bottomNavigation = findViewById(R.id.bottomNavigation)
    }

    private fun setupListeners() {
        // Back button click listener
        backButton.setOnClickListener {
            onBackPressed()
        }

        // Login button click listener
        loginButton.setOnClickListener {
            Toast.makeText(this, "Login clicked", Toast.LENGTH_SHORT).show()
        }

        // Train booking click listener
        findViewById<View>(R.id.trainService).setOnClickListener {
            Toast.makeText(this, "Train booking clicked", Toast.LENGTH_SHORT).show()
        }

        // Bottom navigation listener
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Already on home screen
                    true
                }
                R.id.nav_account -> {
                    Toast.makeText(this, "Account clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}