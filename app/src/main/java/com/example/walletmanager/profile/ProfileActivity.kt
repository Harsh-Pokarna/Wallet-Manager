package com.example.walletmanager.profile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.walletmanager.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        init()
    }

    private fun init() {
        fetchData()
        setViews()
        setObservers()
        setListeners()
    }

    private fun fetchData() {

    }

    private fun setViews() {

    }

    private fun setObservers() {
        activity_profile_back_btn.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setListeners() {
        activity_profile_change_tags_btn.setOnClickListener {
            startActivity(TagsActivity.newInstance(this))
        }
    }

    companion object {
        fun newInstance(context: Context) : Intent {
            return Intent(context, ProfileActivity::class.java)
        }
    }
}