package com.example.walletmanager.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walletmanager.R
import com.example.walletmanager.pojos.Transaction

class TransactionHistoryAdapter(private var listOfTransaction: List<Transaction>, private val listener: OnClicked) :

    RecyclerView.Adapter<TransactionHistoryAdapter.TransactionHistoryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionHistoryViewHolder {
        return TransactionHistoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false))

    }

    override fun onBindViewHolder(holder: TransactionHistoryViewHolder, position: Int) {
        holder.bind(listOfTransaction[position])
    }

    override fun getItemCount(): Int {
        return listOfTransaction.size
    }

    fun addData(listOfTransaction: List<Transaction>) {
        this.listOfTransaction = listOfTransaction
        notifyDataSetChanged()
    }

    inner class TransactionHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val transactionAmountTextView: TextView = itemView.findViewById(R.id.transaction_amount)
        private val transactionDescriptionTextView: TextView = itemView.findViewById(R.id.transaction_description)
        private val transactionDateTextView: TextView = itemView.findViewById(R.id.transaction_date)
        private val transactionTimeTextview: TextView = itemView.findViewById(R.id.transaction_time)
        private val deleteTransactionButton: ImageButton = itemView.findViewById(R.id.delete_transaction_button)

        fun bind(transaction: Transaction) {
            transactionAmountTextView.text = transaction.transactionAmount.toInt().toString()
            transactionDescriptionTextView.text = transaction.transactionDescription
            transactionDateTextView.text = transaction.transactionDate
            transactionTimeTextview.text = transaction.transactionTime

            deleteTransactionButton.setOnClickListener {
                listener.onDeleteClicked(transaction)
            }
        }

    }

    interface OnClicked {
        fun onDeleteClicked(transaction: Transaction)
        fun onItemClicked(transaction: Transaction)
    }
}