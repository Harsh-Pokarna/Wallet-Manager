package com.example.walletmanager.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.walletmanager.R

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

    }

    private fun setListeners() {

    }
}