package com.example.irctcclone.presentation.features.auth

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var isPasswordVisible = false
    private var currentCaptcha = "T==DM" // Default captcha, you can generate random later

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Password visibility toggle
        binding.btnTogglePassword.setOnClickListener {
            togglePasswordVisibility()
        }

        // Refresh captcha
        binding.btnRefreshCaptcha.setOnClickListener {
            refreshCaptcha()
        }

        // Login button
        binding.fabLogin.setOnClickListener {
            attemptLogin()
        }

        // OTP Checkbox
        binding.cbLoginWithOtp.setOnCheckedChangeListener { _, isChecked ->
            handleOtpCheckbox(isChecked)
        }

        // Forgot Account
        binding.tvForgotAccount.setOnClickListener {
            // Navigate to forgot account screen
            Toast.makeText(this, "Forgot Account clicked", Toast.LENGTH_SHORT).show()
        }

        // Register
        binding.tvRegister.setOnClickListener {
            // Navigate to registration screen
            Toast.makeText(this, "Register clicked", Toast.LENGTH_SHORT).show()
        }

        // Agent Login
        binding.tvAgentLoginText.setOnClickListener {
            // Navigate to agent login screen
            Toast.makeText(this, "Agent Login clicked", Toast.LENGTH_SHORT).show()
        }

        // Back button
        binding.tvBack.setOnClickListener {
            onBackPressed()
        }

        // User Guide
        binding.tvUserGuide.setOnClickListener {
            // Show user guide
            Toast.makeText(this, "User Guide clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible
        
        if (isPasswordVisible) {
            // Show password
            binding.etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.btnTogglePassword.setImageResource(R.drawable.ic_visibility_on)
        } else {
            // Hide password
            binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.btnTogglePassword.setImageResource(R.drawable.ic_visibility_off)
        }
        
        // Keep cursor at the end of the text
        binding.etPassword.setSelection(binding.etPassword.text.length)
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
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val captcha = binding.etCaptcha.text.toString().trim()

        // Validate inputs
        when {
            username.isEmpty() -> {
                binding.etUsername.error = "Please enter username"
                binding.etUsername.requestFocus()
                return
            }
            password.isEmpty() -> {
                binding.etPassword.error = "Please enter password"
                binding.etPassword.requestFocus()
                return
            }
            captcha.isEmpty() -> {
                binding.etCaptcha.error = "Please enter captcha"
                binding.etCaptcha.requestFocus()
                return
            }
            captcha != currentCaptcha -> {
                binding.etCaptcha.error = "Invalid captcha"
                binding.etCaptcha.requestFocus()
                return
            }
        }

        // If using OTP
        if (binding.cbLoginWithOtp.isChecked) {
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