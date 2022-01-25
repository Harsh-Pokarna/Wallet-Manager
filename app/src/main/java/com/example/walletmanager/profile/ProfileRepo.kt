package com.example.walletmanager.profile

import com.example.walletmanager.dao.TransactionDatabase

class ProfileRepo(private val db: TransactionDatabase) {

    suspend fun insertTag(tag: com.example.walletmanager.pojos.Tag) = db.getTransactionDao().insertTag(tag = tag)

    suspend fun getAllTags() = db.getTransactionDao().getAllTags()
}