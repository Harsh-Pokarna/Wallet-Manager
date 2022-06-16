package com.example.walletmanager.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walletmanager.R
import com.example.walletmanager.dao.WalletManagerDatabase
import com.example.walletmanager.pojos.Transaction
import com.example.walletmanager.profile.TagsActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.transaction_history_section.*

class DashboardActivity : AppCompatActivity(), TransactionHistoryAdapter.OnClicked {

    private val transactionHistoryAdapter by lazy { TransactionHistoryAdapter(emptyList(), this) }
    private var listOfTransactions: List<Transaction> = emptyList()
    private var homeRepo = HomeRepo(WalletManagerDatabase.invoke())
    private var viewModelFactory = HomeViewModelFactory(homeRepo)
//    private lateinit var homeRepo: HomeRepo
//    private lateinit var viewModelFactory: HomeViewModelFactory

    private val homeViewModel by viewModels<HomeViewModel> { viewModelFactory }
//    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        
        init()
    }
    
    private fun init() {
        initialiseVariables()
        addData()
        fetchData()
        setViews()
        setListeners()
        setObservers()
    }

    private fun initialiseVariables() {
//        WalletManager.setContext(this)
        if (applicationContext == null) {
            Log.e("TAG", "APPLICATION CONTEXT IS NULL")
        }
//        homeRepo = HomeRepo(TransactionDatabase.invoke(application))
//        viewModelFactory = HomeViewModelFactory(homeRepo)
//        homeViewModel by viewModels<HomeViewModel> { viewModelFactory }

    }

    private fun addData() {

//        val transaction1 = Transaction(transactionAmount = 54f,
//            transactionDescription = "Budh Redi", id = 1)
//        val transaction2 = Transaction(transactionAmount = 64f,
//            transactionDescription = "Ram Redi", id = 2)
//        val transaction3 = Transaction(transactionAmount = 74f,
//            transactionDescription = "Budh Redi", id = 3)
//
//        homeViewModel.insertTransaction(transaction1)
//        homeViewModel.insertTransaction(transaction2)
//        homeViewModel.insertTransaction(transaction3)
    }
    
    private fun fetchData() {
        homeViewModel.getAllTransactions()
    }
    
    private fun setViews() {
        transaction_history_recyclerview.layoutManager = LinearLayoutManager(this)
    	transaction_history_recyclerview.adapter = transactionHistoryAdapter
    }
    
    private fun setListeners() {
        add_transaction_button.setOnClickListener { startActivity(RecordPaymentActivity.newInstance(this)) }
    	profile_image_button.setOnClickListener { startActivity(TagsActivity.newInstance(this)) }
    }
    
    private fun setObservers() {
//        homeViewModel.transactionsLiveData.observe(this, {
//            Log.e("TAG", "The value of transactionLivedata is: $it" )
//            if (it == null) {
//                Log.e("TAG", "setObservers: null list", )
//                return@observe
//            }
//            transactionHistoryAdapter.addData(it)
//        })

        homeViewModel.getAllTransactions().observe(this) {
            Log.e("TAG", "transaction values: $it")
            transactionHistoryAdapter.addData(it)
        }
    }

    companion object {
        fun newInstance(context: Context) = Intent(context, DashboardActivity::class.java)
    }

    override fun onDeleteClicked(transaction: Transaction) {
        homeViewModel.deleteTransaction(transaction)
    }

    override fun onItemClicked(transaction: Transaction) {
        TODO("Not yet implemented")
    }
}