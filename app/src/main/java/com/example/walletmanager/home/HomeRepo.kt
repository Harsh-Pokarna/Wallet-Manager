package com.example.walletmanager.home

import com.example.walletmanager.dao.TransactionDatabase
import com.example.walletmanager.pojos.Transaction

class HomeRepo(private val db: TransactionDatabase) {

    suspend fun insertTransaction(transaction: Transaction) =
        db.getTransactionDao().insertTransaction(transaction)

    suspend fun deleteTransaction(transaction: Transaction) =
        db.getTransactionDao().deleteTransaction(transaction)

    suspend fun getAllTransactions() = db.getTransactionDao().getAllTransactions()
}