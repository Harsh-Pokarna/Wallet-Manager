package com.example.walletmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.walletmanager.dao.TransactionDatabase
import com.example.walletmanager.home.DashboardActivity
import com.example.walletmanager.home.HomeRepo
import com.example.walletmanager.home.HomeViewModel
import com.example.walletmanager.home.HomeViewModelFactory
import com.example.walletmanager.pojos.Transaction

class SplashActivity : AppCompatActivity() {

    private var homeRepo = HomeRepo(TransactionDatabase.invoke())
    private var viewModelFactory = HomeViewModelFactory(homeRepo)
//    private lateinit var homeRepo: HomeRepo
//    private lateinit var viewModelFactory: HomeViewModelFactory

    private val homeViewModel by viewModels<HomeViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val transaction1 = Transaction(transactionAmount = 54f,
            transactionDescription = "Budh Redi", id = 1L)
        val transaction2 = Transaction(transactionAmount = 64f,
            transactionDescription = "Ram Redi", id = 2L)
        val transaction3 = Transaction(transactionAmount = 74f,
            transactionDescription = "Budh Redi", id = 3L)

        homeViewModel.insertTransaction(transaction1)
        homeViewModel.insertTransaction(transaction2)
        homeViewModel.insertTransaction(transaction3)

        startActivity(Intent(this, DashboardActivity::class.java))

    }
}