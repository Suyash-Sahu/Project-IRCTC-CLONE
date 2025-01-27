package com.example.irctcclone.presentation.features.train

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.irctcclone.R
import com.example.irctcclone.presentation.features.main.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TrainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var backButton: ImageButton
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var infoText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train)

        initializeViews()
        setupToolbar()
        setupClickListeners()
        setupBottomNavigation()
    }

    private fun initializeViews() {
        toolbar = findViewById(R.id.toolbar)
        backButton = findViewById(R.id.backButton)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        infoText = findViewById(R.id.infoText)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setupClickListeners() {
        // Back button
        backButton.setOnClickListener {
            finish()
        }

        // First Row
        findViewById<View>(R.id.bookTicketLayout).setOnClickListener {
            handleServiceClick("Book Ticket") {
                // Launch BookTicketActivity when implemented
                // startActivity(Intent(this, BookTicketActivity::class.java))
            }
        }

        findViewById<View>(R.id.myBookingsLayout).setOnClickListener {
            handleServiceClick("My Bookings") {
                // Launch MyBookingsActivity when implemented
            }
        }

        findViewById<View>(R.id.pnrEnquiryLayout).setOnClickListener {
            handleServiceClick("PNR Enquiry") {
                // Launch PNR Enquiry functionality
            }
        }

        findViewById<View>(R.id.lastTransactionLayout).setOnClickListener {
            handleServiceClick("Last Transaction") {
                // Show last transaction details
            }
        }

        findViewById<View>(R.id.upcomingJourneyLayout).setOnClickListener {
            handleServiceClick("Upcoming Journey") {
                // Show upcoming journey details
            }
        }

        // Second Row
        findViewById<View>(R.id.cancelTicketLayout).setOnClickListener {
            handleServiceClick("Cancel Ticket") {
                // Launch ticket cancellation flow
            }
        }

        findViewById<View>(R.id.fileTDRLayout).setOnClickListener {
            handleServiceClick("File TDR") {
                // Launch TDR filing process
            }
        }

        findViewById<View>(R.id.refundHistoryLayout).setOnClickListener {
            handleServiceClick("Refund History") {
                // Show refund history
            }
        }

        findViewById<View>(R.id.faqLayout).setOnClickListener {
            handleServiceClick("FAQ") {
                // Show FAQ section
            }
        }

        findViewById<View>(R.id.eWalletLayout).setOnClickListener {
            handleServiceClick("IRCTC E-Wallet") {
                // Show E-Wallet details
            }
        }

        // Third Row
        findViewById<View>(R.id.chartVacancyLayout).setOnClickListener {
            handleServiceClick("Chart Vacancy") {
                // Show chart vacancy
            }
        }

        findViewById<View>(R.id.trainScheduleLayout).setOnClickListener {
            handleServiceClick("Train Schedule") {
                // Show train schedule
            }
        }

        findViewById<View>(R.id.trackTrainLayout).setOnClickListener {
            handleServiceClick("Track Your Train") {
                // Launch train tracking
            }
        }

        findViewById<View>(R.id.askDishaLayout).setOnClickListener {
            handleServiceClick("Ask Disha 2.0") {
                // Launch Ask Disha chatbot
            }
        }

        findViewById<View>(R.id.delhiMetroLayout).setOnClickListener {
            handleServiceClick("Delhi Metro") {
                // Show Delhi Metro information
            }
        }

        // Information text click
        infoText.setOnClickListener {
            try {
                val url = "https://www.indianrail.gov.in"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Unable to open website", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleServiceClick(serviceName: String, action: () -> Unit) {
        try {
            action.invoke()
        } catch (e: Exception) {
            Toast.makeText(this, "$serviceName coming soon!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    if (this.javaClass != MainActivity::class.java) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                    true
                }
                R.id.nav_account -> {
                    handleNavigationClick("Account") {
                        // Launch Account Activity when implemented
                    }
                    true
                }
                R.id.nav_shop -> {
                    handleNavigationClick("Shop") {
                        // Launch Shop Activity when implemented
                    }
                    true
                }
                R.id.nav_transactions -> {
                    handleNavigationClick("Transactions") {
                        // Launch Transactions Activity when implemented
                    }
                    true
                }
                R.id.nav_more -> {
                    handleNavigationClick("More") {
                        // Launch More Activity when implemented
                    }
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun handleNavigationClick(screenName: String, action: () -> Unit) {
        try {
            action.invoke()
        } catch (e: Exception) {
            Toast.makeText(this, "$screenName section coming soon!", Toast.LENGTH_SHORT).show()
        }
    }

    // Helper function to check if network is available
    @RequiresApi(Build.VERSION_CODES.M)
    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as android.net.ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        return actNw.hasCapability(android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    companion object {
        private const val TAG = "TrainActivity"
    }
}