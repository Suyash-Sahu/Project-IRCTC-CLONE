package com.example.irctcclone.presentation.features.payment

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.irctcclone.R
import com.example.irctcclone.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupPayment()
    }

    private fun setupToolbar() {
        binding.toolbar.findViewById<View>(R.id.btnBack).setOnClickListener { finish() }
    }

    private fun setupPayment() {
        binding.btnPay.setOnClickListener {
            val selectedPaymentMethodId = binding.radioGroupPayment.checkedRadioButtonId
            if (selectedPaymentMethodId != -1) {
                val selectedPaymentMethod = findViewById<RadioButton>(selectedPaymentMethodId).text
                Toast.makeText(this, "Processing payment via $selectedPaymentMethod", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show()
            }
        }
    }
}