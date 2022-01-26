package com.example.walletmanager.profile

import androidx.lifecycle.LiveData
import com.example.walletmanager.dao.TransactionDatabase
import com.example.walletmanager.pojos.Tag

class ProfileRepo(private val db: TransactionDatabase) {

    suspend fun insertTag(tag: Tag) = db.getTransactionDao().insertTag(tag = tag)

    suspend fun deleteTag(tag: Tag) = db.getTransactionDao().deleteTag(tag)

    fun getAllTags() : LiveData<List<Tag>> {
        return  db.getTransactionDao().getAllTags()
    }
}