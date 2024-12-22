package com.example.glamoraapp.ui.fragment.onboarding.screens.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor() : ViewModel() {

    private val _currentPage = MutableLiveData<Int>().apply { value = 0 }
    val currentPage: LiveData<Int> get() = _currentPage

    fun goToNextPage() {
        _currentPage.value = (_currentPage.value ?: 0) + 1
    }
}