package com.example.walletmanager.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.walletmanager.R
import com.example.walletmanager.dao.TransactionDatabase
import com.example.walletmanager.pojos.Transaction
import kotlinx.android.synthetic.main.activity_record_payment.*

class RecordPaymentActivity : AppCompatActivity() {

    private val homeRepo = HomeRepo(TransactionDatabase.invoke())
    private val viewModelFactory = HomeViewModelFactory(homeRepo)

    private val homeViewModel by viewModels<HomeViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_payment)

        init()
    }

    private fun init() {
        fetchData()
        setViews()
        setListeners()
        setObservers()
    }

    private fun fetchData() {

    }

    private fun setViews() {

    }

    private fun setListeners() {

    	record_payment_back_button.setOnClickListener { startActivity(DashboardActivity.newInstance(this)) }
        cash_payment_button.setOnClickListener { recordTransaction(ModeOfPayment.CASH) }

    }

    private fun recordTransaction(modeOfPayment: ModeOfPayment) {

        val transaction = Transaction(transactionAmount = transaction_amount_input.text.toString().toFloat(),
        transactionDescription = transaction_description_input.text.toString(), id = System.currentTimeMillis() )

        homeViewModel.insertTransaction(transaction)
        Toast.makeText(this, "Transaction Added", Toast.LENGTH_SHORT).show()
        startActivity(DashboardActivity.newInstance(this))

    }

    private fun setObservers() {

    }

    companion object {

        enum class ModeOfPayment(val type: String) {
            PAYTM("paytm"),
            GOOGLEPAY("google_pay"),
            CASH("cash"),
            CARD("card")
        }

        fun newInstance(context: Context) = Intent(context, RecordPaymentActivity::class.java)
    }
}
