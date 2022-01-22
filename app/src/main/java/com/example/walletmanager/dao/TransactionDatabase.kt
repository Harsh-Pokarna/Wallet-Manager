package com.example.walletmanager.dao

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.walletmanager.WalletManager
import com.example.walletmanager.pojos.Transaction

@Database(entities = [Transaction::class], version = 3)
abstract class TransactionDatabase : RoomDatabase() {

    abstract fun getTransactionDao() : TransactionDao

    companion object {
        @Volatile
        private var dbInstance: TransactionDatabase? = null
        private var LOCK = Any()

        operator fun invoke() = dbInstance ?: synchronized(LOCK) {
            dbInstance ?: Room.databaseBuilder(
                WalletManager.applicationContext(),
                TransactionDatabase::class.java,
                "TransactionDatabase.db"
            ).fallbackToDestructiveMigration().build().also {
                dbInstance = it
            }
        }

    }
}
