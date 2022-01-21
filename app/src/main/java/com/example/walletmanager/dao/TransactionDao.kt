package com.example.walletmanager.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.walletmanager.pojos.Transaction
import com.example.walletmanager.utils.TRANSACTION_TABLE_NAME

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)

    @Query("SELECT * FROM TRANSACTIONS_TABLE")
    fun getAllTransactions(): LiveData<List<Transaction>>

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

}