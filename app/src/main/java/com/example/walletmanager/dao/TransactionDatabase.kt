package com.example.walletmanager.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.walletmanager.pojos.Transaction

@Database(entities = [Transaction::class], version = 1)

abstract class TransactionDatabase : RoomDatabase() {

    abstract fun getTransactionDao() : TransactionDao

    companion object {
        @Volatile
        private var dbInstance: TransactionDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = dbInstance ?: synchronized(LOCK) {
            dbInstance ?: Room.databaseBuilder(
                context.applicationContext,
                TransactionDatabase::class.java,
                "TransactionDatabase.db"
            ).build().also {
                dbInstance = it
            }
        }

    }
}