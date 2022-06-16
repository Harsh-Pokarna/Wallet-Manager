package com.example.walletmanager.dao

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.walletmanager.WalletManager
import com.example.walletmanager.pojos.Tag
import com.example.walletmanager.pojos.Transaction

@Database(entities = [Transaction::class, Tag::class], version = 6)
abstract class WalletManagerDatabase : RoomDatabase() {

    abstract fun getTransactionDao() : WalletManagerDao

    companion object {
        @Volatile
        private var dbInstance: WalletManagerDatabase? = null
        private var LOCK = Any()

        operator fun invoke() = dbInstance ?: synchronized(LOCK) {
            dbInstance ?: Room.databaseBuilder(
                WalletManager.applicationContext(),
                WalletManagerDatabase::class.java,
                "TransactionDatabase.db"
            ).fallbackToDestructiveMigration().build().also {
                dbInstance = it
            }
        }

    }
}
