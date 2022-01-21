package com.example.walletmanager.pojos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.walletmanager.utils.TRANSACTION_TABLE_NAME

@Entity(tableName = TRANSACTION_TABLE_NAME)
data class Transaction(

    @PrimaryKey(autoGenerate = true)
    var id: Int = -1,

    @ColumnInfo(name = "transactionDescription")
    val transactionDescription: String = "",

    @ColumnInfo(name = "transactionAmount")
    val transactionAmount: Float = -1f,

    @ColumnInfo(name = "transactionDate")
    val transactionDate: String = "",

    @ColumnInfo(name = "transactionTime")
    val transactionTime: String = "",

)
