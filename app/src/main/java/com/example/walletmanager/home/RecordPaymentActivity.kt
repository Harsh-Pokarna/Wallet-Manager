package com.example.walletmanager.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.walletmanager.R
import kotlinx.android.synthetic.main.activity_record_payment.*

class RecordPaymentActivity : AppCompatActivity() {

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
    }

    private fun setObservers() {

    }

    companion object {
        fun newInstance(context: Context) = Intent(context, RecordPaymentActivity::class.java)
    }
}
