package com.example.irctcclone.presentation.features.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.irctcclone.R
import com.example.irctcclone.presentation.features.train.TrainActivity
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

        // Setup service click listeners
        setupServiceClickListeners()
    }

    private fun setupListeners() {
        // Back button click listener
        backButton.setOnClickListener {
            onBackPressed()
        }

        // Login button click listener
        loginButton.setOnClickListener {
            // TODO: Implement login functionality
            Toast.makeText(this, "Login clicked", Toast.LENGTH_SHORT).show()
        }

        // Bottom navigation listener
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            handleNavigationItemSelected(menuItem)
        }
    }

    private fun setupServiceClickListeners() {
        // Train service
        findViewById<View>(R.id.trainService).setOnClickListener {
            startActivity(Intent(this, TrainActivity::class.java))
            Toast.makeText(this, "Train booking clicked", Toast.LENGTH_SHORT).show()
        }

        // Flights service
        findViewById<View>(R.id.flightsService).setOnClickListener {
            Toast.makeText(this, "Flights booking clicked", Toast.LENGTH_SHORT).show()
        }

        // Bus service
        findViewById<View>(R.id.busService).setOnClickListener {
            Toast.makeText(this, "Bus booking clicked", Toast.LENGTH_SHORT).show()
        }

        // Hotel service
        findViewById<View>(R.id.hotelService).setOnClickListener {
            Toast.makeText(this, "Hotel booking clicked", Toast.LENGTH_SHORT).show()
        }

        // Food service
        findViewById<View>(R.id.foodService).setOnClickListener {
            Toast.makeText(this, "Food ordering clicked", Toast.LENGTH_SHORT).show()
        }

        // Ask Disha service
        findViewById<View>(R.id.dishaService).setOnClickListener {
            Toast.makeText(this, "Ask Disha 2.0 clicked", Toast.LENGTH_SHORT).show()
        }

        // Tourism service
        findViewById<View>(R.id.tourismService).setOnClickListener {
            Toast.makeText(this, "Tourism clicked", Toast.LENGTH_SHORT).show()
        }

        // Retiring Room service
        findViewById<View>(R.id.retiringRoomService).setOnClickListener {
            Toast.makeText(this, "Retiring Room clicked", Toast.LENGTH_SHORT).show()
        }

        // YouTube service
        findViewById<View>(R.id.youtubeService).setOnClickListener {
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/c/IRCTC")))
            } catch (e: Exception) {
                Toast.makeText(this, "Unable to open YouTube", Toast.LENGTH_SHORT).show()
            }
        }

        // Daily Deals service
        findViewById<View>(R.id.dealsService).setOnClickListener {
            Toast.makeText(this, "Daily Deals clicked", Toast.LENGTH_SHORT).show()
        }

        // Bills & Shop Services
        findViewById<View>(R.id.rechargeService).setOnClickListener {
            Toast.makeText(this, "Recharge & Bills clicked", Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.groceryService).setOnClickListener {
            Toast.makeText(this, "Grocery clicked", Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.kitchenService).setOnClickListener {
            Toast.makeText(this, "Kitchen clicked", Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.apparelService).setOnClickListener {
            Toast.makeText(this, "Apparel clicked", Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.yatriMallService).setOnClickListener {
            Toast.makeText(this, "Yatri Mall clicked", Toast.LENGTH_SHORT).show()
        }


    }

    private fun handleNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_home -> {
                // Already on home screen
                return true
            }
            R.id.nav_account -> {
                // TODO: Implement account screen navigation
                Toast.makeText(this, "Account clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.nav_shop -> {
                // TODO: Implement shop screen navigation
                Toast.makeText(this, "Shop clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.nav_transactions -> {
                // TODO: Implement transactions screen navigation
                Toast.makeText(this, "Transactions clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.nav_more -> {
                // TODO: Implement more options screen navigation
                Toast.makeText(this, "More clicked", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }
}