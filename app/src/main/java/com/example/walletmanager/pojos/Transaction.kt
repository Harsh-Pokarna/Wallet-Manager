package com.example.walletmanager.pojos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.walletmanager.home.RecordPaymentActivity
import com.example.walletmanager.utils.TRANSACTION_TABLE_NAME

@Entity(tableName = TRANSACTION_TABLE_NAME)
data class Transaction(

    @PrimaryKey(autoGenerate = false)
    var id: Long = -1L,

    @ColumnInfo(name = "transactionDescription")
    val transactionDescription: String = "",

    @ColumnInfo(name = "transactionAmount")
    val transactionAmount: Float = -1f,

    @ColumnInfo(name = "transactionDate")
    val transactionDate: String = "5 Jan, 2022",
//
//    @ColumnInfo(name = "ModeOfPayment")
//    val modeOfPayment: RecordPaymentActivity.Companion.ModeOfPayment = RecordPaymentActivity.Companion.ModeOfPayment.CASH,

    @ColumnInfo(name = "transactionTime")
    val transactionTime: String = "14:34",

    )
