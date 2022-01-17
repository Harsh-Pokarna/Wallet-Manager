package com.example.walletmanager.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walletmanager.R

class TransactionHistoryAdapter :
    RecyclerView.Adapter<TransactionHistoryAdapter.TransactionHistoryViewHolder>() {

    inner class TransactionHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionHistoryViewHolder {
        return TransactionHistoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false))

    }

    override fun onBindViewHolder(holder: TransactionHistoryViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }
}