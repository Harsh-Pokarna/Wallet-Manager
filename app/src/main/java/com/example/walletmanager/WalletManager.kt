package com.example.walletmanager

import android.app.Application
import android.content.Context
import com.example.walletmanager.dao.TransactionDatabase

class WalletManager : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: WalletManager? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }
}