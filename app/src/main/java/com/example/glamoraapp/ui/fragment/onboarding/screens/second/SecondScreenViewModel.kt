package com.example.glamoraapp.ui.fragment.onboarding.screens.second

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondScreenViewModel @Inject constructor() : ViewModel() {

    private val _currentPage = MutableLiveData<Int>().apply { value = 1 } // Varsayılan değer
    val currentPage: LiveData<Int> get() = _currentPage

    fun goToNextPage() {
        _currentPage.value = 2
    }
}