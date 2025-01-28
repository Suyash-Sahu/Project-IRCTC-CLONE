package com.example.irctcclone.presentation.features.train

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ActivityTrainBinding
import com.example.irctcclone.presentation.features.booking.BookTicketActivity
import com.example.irctcclone.presentation.features.mybookings.MyBookingsActivity
import com.example.irctcclone.presentation.features.pnr.PNRStatusActivity
import com.example.irctcclone.presentation.features.trainstatus.TrainStatusActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TrainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupClickListeners()
        setupBottomNavigation()
    }

    private fun setupToolbar() {
        binding.toolbar.apply {
            title = ""
            setSupportActionBar(this)
        }
        
        binding.backButton.setOnClickListener { finish() }
        binding.infoText.text = getString(R.string.app_name)
    }

    private fun setupClickListeners() {
        // First Row
        binding.bookTicketLayout.setOnClickListener {
            handleServiceClick("Book Ticket") {
                // Launch BookTicketActivity when implemented
                // startActivity(Intent(this, BookTicketActivity::class.java))
            }
        }

        binding.myBookingsLayout.setOnClickListener {
            startActivity(Intent(this, MyBookingsActivity::class.java))
        }

        binding.pnrEnquiryLayout.setOnClickListener {
            startActivity(Intent(this, PNRStatusActivity::class.java))
        }

        binding.lastTransactionLayout.setOnClickListener {
            handleServiceClick("Last Transaction") {
                // Show last transaction details
            }
        }

        binding.upcomingJourneyLayout.setOnClickListener {
            handleServiceClick("Upcoming Journey") {
                // Show upcoming journey details
            }
        }

        // Second Row
        binding.cancelTicketLayout.setOnClickListener {
            handleServiceClick("Cancel Ticket") {
                // Launch ticket cancellation flow
            }
        }

        binding.fileTDRLayout.setOnClickListener {
            handleServiceClick("File TDR") {
                // Launch TDR filing process
            }
        }

        binding.refundHistoryLayout.setOnClickListener {
            handleServiceClick("Refund History") {
                // Show refund history
            }
        }

        binding.faqLayout.setOnClickListener {
            handleServiceClick("FAQ") {
                // Show FAQ section
            }
        }

        binding.eWalletLayout.setOnClickListener {
            handleServiceClick("IRCTC E-Wallet") {
                // Show E-Wallet details
            }
        }

        // Third Row
        binding.chartVacancyLayout.setOnClickListener {
            handleServiceClick("Chart Vacancy") {
                // Show chart vacancy
            }
        }

        binding.trainScheduleLayout.setOnClickListener {
            handleServiceClick("Train Schedule") {
                // Show train schedule
            }
        }

        binding.trackTrainLayout.setOnClickListener {
            handleServiceClick("Track Your Train") {
                // Launch train tracking
            }
        }

        binding.askDishaLayout.setOnClickListener {
            handleServiceClick("Ask Disha 2.0") {
                // Launch Ask Disha chatbot
            }
        }

        binding.delhiMetroLayout.setOnClickListener {
            handleServiceClick("Delhi Metro") {
                // Show Delhi Metro information
            }
        }

        // Information text click
        binding.infoText.setOnClickListener {
            try {
                val url = "https://www.indianrail.gov.in"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Unable to open website", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
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

    private fun handleServiceClick(serviceName: String, action: () -> Unit) {
        try {
            action.invoke()
        } catch (e: Exception) {
            Toast.makeText(this, "$serviceName coming soon!", Toast.LENGTH_SHORT).show()
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