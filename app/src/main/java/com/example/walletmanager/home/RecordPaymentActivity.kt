package com.example.walletmanager.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.walletmanager.R
import com.example.walletmanager.dao.WalletManagerDatabase
import com.example.walletmanager.pojos.ModeOfPayment
import com.example.walletmanager.pojos.Transaction
import kotlinx.android.synthetic.main.activity_record_payment.*

class RecordPaymentActivity : AppCompatActivity() {

    private val homeRepo = HomeRepo(WalletManagerDatabase.invoke())
    private val viewModelFactory = HomeViewModelFactory(homeRepo)

    private val homeViewModel by viewModels<HomeViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_payment)

        init()
    }

    private fun init() {
        fetchData()
        setViews()
        setListeners()
        setObservers()
    }

    private fun fetchData() {

    }

    private fun setViews() {

    }

    private fun setListeners() {

        record_payment_back_button.setOnClickListener {
            startActivity(
                DashboardActivity.newInstance(
                    this
                )
            )
        }
        cash_payment_button.setOnClickListener { recordTransaction(ModeOfPayment.CASH) }
        card_payment_button.setOnClickListener { recordTransaction(ModeOfPayment.CARD) }
        paytm_payment_button.setOnClickListener { recordTransaction(ModeOfPayment.PAYTM) }

    }

    private fun getDescription(): String {
        if (transaction_description_input.text.toString() != "") {
            return transaction_description_input.text.toString()
        }
        return "-"
    }


    private fun recordTransaction(modeOfPayment: ModeOfPayment) {

        val transaction = Transaction(transactionAmount = transaction_amount_input.text.toString().toFloat(),
        transactionDescription = getDescription(), id = System.currentTimeMillis(), modeOfPayment = modeOfPayment)


        if (modeOfPayment == ModeOfPayment.GOOGLEPAY) {
            val intent = packageManager.getLaunchIntentForPackage("com.google.android.apps.nbu.paisa.user")
            Log.e("TAG", intent.toString() )
            if (intent != null ) {
                homeViewModel.insertTransaction(transaction)
                Toast.makeText(this, "Transaction Added", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please install google pay", Toast.LENGTH_SHORT).show()
            }
        }
        if (modeOfPayment == ModeOfPayment.PAYTM) {
            val intent = packageManager.getLaunchIntentForPackage("net.one97.paytm")
            Log.e("TAG", intent.toString() )
            if (intent != null ) {
                homeViewModel.insertTransaction(transaction)
                Toast.makeText(this, "Transaction Added", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please install Paytm", Toast.LENGTH_SHORT).show()
            }
        }
        if (modeOfPayment == ModeOfPayment.CASH || modeOfPayment == ModeOfPayment.CARD) {
            homeViewModel.insertTransaction(transaction)
            Toast.makeText(this, "Transaction Added", Toast.LENGTH_SHORT).show()
            startActivity(DashboardActivity.newInstance(this))
        }
//        val uri = Uri.Builder()
//        uri.scheme("upi").authority("pay")
//
//        val upiPayIntent = Intent(Intent.ACTION_VIEW)
//        upiPayIntent.data = uri.build()
//
//        // will always show a dialog to user to choose an app
//        val chooser = Intent.createChooser(upiPayIntent, "Pay with")
//
//        // check if intent resolves
//        if (null != chooser.resolveActivity(packageManager)) {
//            startActivity(chooser)
//        } else {
//            Toast.makeText(this, "No UPI app found, please install one to continue", Toast.LENGTH_SHORT)
//                .show()
//        }

    }

private fun setObservers() {

}

companion object {

    fun newInstance(context: Context) = Intent(context, RecordPaymentActivity::class.java)
}

//    private fun upiPaymentDataOperation(data: String) {
//            var str: String? = data
//            Log.d("UPIPAY", "upiPaymentDataOperation: " + str!!)
//            var paymentCancel = ""
//            if (str == null) str = "discard"
//            var status = ""
//            var approvalRefNo = ""
//            val response = str.split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//            for (i in response.indices) {
//                val equalStr = response[i].split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//                if (equalStr.size >= 2) {
//                    if (equalStr[0].lowercase() == "Status".lowercase()) {
//                        status = equalStr[1].lowercase()
//                    } else if (equalStr[0].lowercase() == "ApprovalRefNo".lowercase() || equalStr[0].lowercase() == "txnRef".lowercase()) {
//                        approvalRefNo = equalStr[1]
//                    }
//                } else {
//                    paymentCancel = "Payment cancelled by user."
//                }
//            }
//
//            if (status == "success") {
//                //Code to handle successful transaction here.
//                Toast.makeText(this, "Transaction successful.", Toast.LENGTH_SHORT).show()
//                Log.d("UPI", "responseStr: $approvalRefNo")
//            } else if ("Payment cancelled by user." == paymentCancel) {
//                Toast.makeText(this, "Payment cancelled by user.", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, "Transaction failed.Please try again", Toast.LENGTH_SHORT).show()
//            }
//        }


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (data != null) {
//            val trxt = data.getStringExtra("response")
//            Log.e("TAG", "data value is: $data")
//            Log.e("UPI", "trx value is: $trxt")
//            upiPaymentDataOperation(data.toString())
//        } else {
//            Log.e("UPI", "onActivityResult: " + "Return data is null")
//            upiPaymentDataOperation(data.toString())
//        }
//    }


}

