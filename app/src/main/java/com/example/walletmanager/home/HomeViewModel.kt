package com.example.walletmanager.home

import androidx.lifecycle.*
import com.example.walletmanager.pojos.Transaction
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepo: HomeRepo) : ViewModel() {

    private var _transactionsLiveData: MutableLiveData<List<Transaction>> = MutableLiveData()
    val transactionsLiveData: LiveData<List<Transaction>>
        get() = _transactionsLiveData

    fun insertTransaction(transaction: Transaction) = viewModelScope.launch {
        homeRepo.insertTransaction(transaction)
    }

    fun deleteTransaction(transaction: Transaction) = viewModelScope.launch {
        val response = homeRepo.deleteTransaction(transaction)
    }

    fun getAllTransactions() = viewModelScope.launch {
        val response = homeRepo.getAllTransactions()
        _transactionsLiveData.value = response
    }
}