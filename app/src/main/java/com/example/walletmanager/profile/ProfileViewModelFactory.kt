package com.example.walletmanager.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.walletmanager.home.HomeViewModel

class ProfileViewModelFactory(private val profileRepo: ProfileRepo) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(profileRepo) as T
    }
}