package com.example.walletmanager.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walletmanager.pojos.Tag
import kotlinx.coroutines.launch

class ProfileViewModel(private val profileRepo: ProfileRepo): ViewModel() {

    private var _tagsLiveData: MutableLiveData<List<Tag>> = MutableLiveData()
    val tagsLiveData: LiveData<List<Tag>>
        get() = _tagsLiveData

    fun insertTag(tag: Tag) = viewModelScope.launch {
        profileRepo.insertTag(tag)
    }

    fun getAllTags() = viewModelScope.launch {
        val response = profileRepo.getAllTags()
        _tagsLiveData.value = response
    }
}