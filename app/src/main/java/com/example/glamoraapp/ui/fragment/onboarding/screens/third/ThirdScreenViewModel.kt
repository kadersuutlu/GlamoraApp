package com.example.glamoraapp.ui.fragment.onboarding.screens.third

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThirdScreenViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    private val _navigateToRoleSelection = MutableLiveData<Boolean>()
    val navigateToRoleSelection: LiveData<Boolean> get() = _navigateToRoleSelection

    fun onBoardingFinished() {
        sharedPreferences.edit().putBoolean("Finished", true).apply()
        _navigateToRoleSelection.value = true
    }

    fun resetNavigation() {
        _navigateToRoleSelection.value = false
    }
}