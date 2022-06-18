package com.example.walletmanager.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walletmanager.R
import com.example.walletmanager.pojos.Tag

class PaymentTagsAdapter(private var tags: List<Tag>, private val listener: OnClicked ) : RecyclerView.Adapter<PaymentTagsAdapter.PaymentTagsViewHolder>() {

    inner class PaymentTagsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val paymentTagTextView: TextView = itemView.findViewById(R.id.payment_tag_name)
        private val paymentTagAddBtn: ImageButton = itemView.findViewById(R.id.payment_tag_add_btn)

        fun bind(tag: Tag) {
            paymentTagTextView.text = tag.tagName

            paymentTagAddBtn.setOnClickListener {
                listener.OnClicked()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentTagsViewHolder {
        return PaymentTagsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_paymet_tag, parent, false))
    }

    override fun onBindViewHolder(holder: PaymentTagsViewHolder, position: Int) {
        holder.bind(tags[position])
    }

    override fun getItemCount(): Int {
        return tags.size
    }

    fun addData(listOfTags: List<Tag>) {
        this.tags = listOfTags
        notifyDataSetChanged()
    }

    interface OnClicked {
        fun OnClicked()
    }

}