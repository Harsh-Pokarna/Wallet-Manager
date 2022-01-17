package com.example.walletmanager.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walletmanager.R
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.transaction_history_section.*

class DashboardActivity : AppCompatActivity() {

    private val transactionHistoryAdapter by lazy { TransactionHistoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        
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
        transaction_history_recyclerview.layoutManager = LinearLayoutManager(this)
    	transaction_history_recyclerview.adapter = transactionHistoryAdapter
    }
    
    private fun setListeners() {
        add_transaction_button.setOnClickListener { startActivity(RecordPaymentActivity.newInstance(this)) }
    	
    }
    
    private fun setObservers() {
    	
    }

    companion object {
        fun newInstance(context: Context) = Intent(context, DashboardActivity::class.java)
    }
}