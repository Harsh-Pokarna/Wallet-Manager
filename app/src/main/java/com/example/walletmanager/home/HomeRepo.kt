package com.example.walletmanager.home

import androidx.lifecycle.LiveData
import com.example.walletmanager.dao.TransactionDatabase
import com.example.walletmanager.pojos.Transaction

class HomeRepo(private val db: TransactionDatabase) {

    suspend fun insertTransaction(transaction: Transaction) =
        db.getTransactionDao().insertTransaction(transaction)

    suspend fun deleteTransaction(transaction: Transaction) =
        db.getTransactionDao().deleteTransaction(transaction)

    fun getAllTransactions(): LiveData<List<Transaction>> {
        return db.getTransactionDao().getAllTransactions()
    }
}