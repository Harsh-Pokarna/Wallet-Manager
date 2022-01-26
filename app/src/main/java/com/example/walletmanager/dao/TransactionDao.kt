package com.example.walletmanager.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.walletmanager.pojos.Tag
import com.example.walletmanager.pojos.Transaction
@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTag(tag: Tag)

    @Query("SELECT * FROM TRANSACTIONS_TABLE")
    fun getAllTransactions(): LiveData<List<Transaction>>

    @Query("SELECT * FROM TAGS_TABLE")
    fun getAllTags(): LiveData<List<Tag>>

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTag(tag: Tag)

}