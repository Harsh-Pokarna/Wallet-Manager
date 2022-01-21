package com.example.walletmanager.home

import androidx.lifecycle.ViewModel
import com.example.walletmanager.pojos.Transaction
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepo: HomeRepo) : ViewModel() {

    fun insertTransaction(transaction: Transaction) = GlobalScope.launch {
        homeRepo.insertTransaction(transaction)
    }

    fun deleteTransaction(transaction: Transaction) = GlobalScope.launch {
        homeRepo.deleteTransaction(transaction)
    }

    fun getAllTransactions() = GlobalScope.launch {
        homeRepo.getAllTransactions()
    }
}