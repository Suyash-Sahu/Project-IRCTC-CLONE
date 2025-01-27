package com.example.irctcclone.presentation.features.auth

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.irctcclone.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LoginActivity : AppCompatActivity() {

    // Declare views
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etCaptcha: EditText
    private lateinit var btnTogglePassword: ImageButton
    private lateinit var btnRefreshCaptcha: ImageButton
    private lateinit var cbLoginWithOtp: CheckBox
    private lateinit var fabLogin: FloatingActionButton
    private lateinit var tvForgotAccount: TextView
    private lateinit var tvRegister: TextView
    private lateinit var tvBack: TextView
    private lateinit var tvUserGuide: TextView
    private lateinit var tvAgentLogin: TextView

    private var isPasswordVisible = false
    private var currentCaptcha = "T==DM" // Default captcha, you can generate random later

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize views
        initializeViews()
        // Set up click listeners
        setupClickListeners()
    }

    private fun initializeViews() {
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etCaptcha = findViewById(R.id.etCaptcha)
        btnTogglePassword = findViewById(R.id.btnTogglePassword)
        btnRefreshCaptcha = findViewById(R.id.btnRefreshCaptcha)
        cbLoginWithOtp = findViewById(R.id.cbLoginWithOtp)
        fabLogin = findViewById(R.id.fabLogin)
        tvForgotAccount = findViewById(R.id.tvForgotAccount)
        tvRegister = findViewById(R.id.tvRegister)
        tvBack = findViewById(R.id.tvBack)
        tvUserGuide = findViewById(R.id.tvUserGuide)
        
        // Find the TextView inside Agent Login CardView
        val cvAgentLogin = findViewById<androidx.cardview.widget.CardView>(R.id.cvAgentLogin)
        tvAgentLogin = cvAgentLogin.findViewById(R.id.tvAgentLoginText)
    }

    private fun setupClickListeners() {
        // Password visibility toggle
        btnTogglePassword.setOnClickListener {
            togglePasswordVisibility()
        }

        // Refresh captcha
        btnRefreshCaptcha.setOnClickListener {
            refreshCaptcha()
        }

        // Login button
        fabLogin.setOnClickListener {
            attemptLogin()
        }

        // OTP Checkbox
        cbLoginWithOtp.setOnCheckedChangeListener { _, isChecked ->
            handleOtpCheckbox(isChecked)
        }

        // Forgot Account
        tvForgotAccount.setOnClickListener {
            // Navigate to forgot account screen
            Toast.makeText(this, "Forgot Account clicked", Toast.LENGTH_SHORT).show()
        }

        // Register
        tvRegister.setOnClickListener {
            // Navigate to registration screen
            Toast.makeText(this, "Register clicked", Toast.LENGTH_SHORT).show()
        }

        // Agent Login
        tvAgentLogin.setOnClickListener {
            // Navigate to agent login screen
            Toast.makeText(this, "Agent Login clicked", Toast.LENGTH_SHORT).show()
        }

        // Back button
        tvBack.setOnClickListener {
            onBackPressed()
        }

        // User Guide
        tvUserGuide.setOnClickListener {
            // Show user guide
            Toast.makeText(this, "User Guide clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible
        
        if (isPasswordVisible) {
            // Show password
            etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            btnTogglePassword.setImageResource(R.drawable.ic_visibility_on)
        } else {
            // Hide password
            etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            btnTogglePassword.setImageResource(R.drawable.ic_visibility_off)
        }
        
        // Keep cursor at the end of the text
        etPassword.setSelection(etPassword.text.length)
    }

    private fun refreshCaptcha() {
        // Here you can implement logic to generate a new captcha
        // For now, just showing a toast
        Toast.makeText(this, "Refreshing captcha...", Toast.LENGTH_SHORT).show()
    }

    private fun handleOtpCheckbox(isChecked: Boolean) {
        if (isChecked) {
            // Handle OTP login option
            Toast.makeText(this, "OTP login enabled", Toast.LENGTH_SHORT).show()
        }
    }

    private fun attemptLogin() {
        val username = etUsername.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val captcha = etCaptcha.text.toString().trim()

        // Validate inputs
        when {
            username.isEmpty() -> {
                etUsername.error = "Please enter username"
                etUsername.requestFocus()
                return
            }
            password.isEmpty() -> {
                etPassword.error = "Please enter password"
                etPassword.requestFocus()
                return
            }
            captcha.isEmpty() -> {
                etCaptcha.error = "Please enter captcha"
                etCaptcha.requestFocus()
                return
            }
            captcha != currentCaptcha -> {
                etCaptcha.error = "Invalid captcha"
                etCaptcha.requestFocus()
                return
            }
        }

        // If using OTP
        if (cbLoginWithOtp.isChecked) {
            // Implement OTP login logic
            Toast.makeText(this, "Sending OTP...", Toast.LENGTH_SHORT).show()
            return
        }

        // Regular login
        performLogin(username, password)
    }

    private fun performLogin(username: String, password: String) {
        // Here you would typically make an API call to your backend
        // For now, just show a success message
        Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show()
        
        // TODO: Implement actual login logic with your backend
        // If login successful, navigate to main screen
        // If login fails, show error message
    }

    override fun onBackPressed() {
        // You can customize back button behavior here
        super.onBackPressed()
    }
}