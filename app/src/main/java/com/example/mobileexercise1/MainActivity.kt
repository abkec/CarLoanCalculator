package com.example.mobileexercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton: TextView = findViewById(R.id.buttonCalculate)
        calculateButton.setOnClickListener{ calculate() }

        val resetButton: TextView = findViewById(R.id.buttonReset)
        resetButton.setOnClickListener{ reset() }
    }

    private fun calculate() {

        val loanText: TextView = findViewById(R.id.textViewLoan)
        val interestText: TextView = findViewById(R.id.textViewInterest)
        val monRepayText: TextView = findViewById(R.id.textViewMonthlyRepayment)

        val carPriceText: EditText = findViewById(R.id.editTextCarPrice)
        val downPaymentText: EditText = findViewById(R.id.editTextDownPayment)
        val loanPeriodText: EditText = findViewById(R.id.editTextLoanPeriod)
        val interestRateText: EditText = findViewById(R.id.editTextInterestRate)

        if (TextUtils.isEmpty(carPriceText.getText().toString()) || TextUtils.isEmpty(downPaymentText.getText().toString()) || TextUtils.isEmpty(loanPeriodText.getText().toString()) || TextUtils.isEmpty(interestRateText.getText().toString()))
            Toast.makeText(this, "Invalid input detected. Try again.", Toast.LENGTH_SHORT).show()

        else {

            val carPrice = Integer.parseInt(carPriceText.text.toString())
            val downPayment = Integer.parseInt(downPaymentText.text.toString())
            val loanPeriod = Integer.parseInt(loanPeriodText.text.toString())
            val interestRate = Integer.parseInt(interestRateText.text.toString())
            val loan = carPrice - downPayment
            val interest = loan * interestRate * loanPeriod
            val monRepay = (loan + interest) / loanPeriod / 12

            loanText.text = "Loan : " + loan.toString()
            interestText.text = "Interest :" + interest.toString()
            monRepayText.text = "Monthly Repayment :" + monRepay.toString()
        }
    }

    private fun reset() {

        val carPriceText: EditText = findViewById(R.id.editTextCarPrice)
        val downPaymentText: EditText = findViewById(R.id.editTextDownPayment)
        val loanPeriodText: EditText = findViewById(R.id.editTextLoanPeriod)
        val interestRateText: EditText = findViewById(R.id.editTextInterestRate)

        carPriceText.setText("")
        downPaymentText.setText("")
        loanPeriodText.setText("")
        interestRateText.setText("")

        val loanText: TextView = findViewById(R.id.textViewLoan)
        val interestText: TextView = findViewById(R.id.textViewInterest)
        val monRepayText: TextView = findViewById(R.id.textViewMonthlyRepayment)
        loanText.text = "Loan : "
        interestText.text = "Interest :"
        monRepayText.text = "Monthly Repayment :"
    }
}
