package com.example.walletmanager.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

 fun getData() {
    val sdf = SimpleDateFormat("dd/M/yyyy")
    val currentDate = sdf.format(Date())
    Log.e("TAG", "Today's Date is: $currentDate")
}

fun getTime() {
    val sdf = SimpleDateFormat("hh:mm:ss")
    val currentTime = sdf.format(Date())
    Log.e("TAG", "Today's Date is: $currentTime")
}