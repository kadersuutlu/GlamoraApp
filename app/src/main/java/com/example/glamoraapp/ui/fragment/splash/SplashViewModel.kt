package com.example.glamoraapp.ui.fragment.splash

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val sharedPreferences: SharedPreferences) : ViewModel() {

    private val _isOnboardingFinished = MutableLiveData<Boolean>()
    val isOnboardingFinished: LiveData<Boolean> get() = _isOnboardingFinished

    init {
        _isOnboardingFinished.value = sharedPreferences.getBoolean("Finished", false)
    }

    fun checkOnboardingStatus(): Boolean {
        return sharedPreferences.getBoolean("Finished", false)
    }
}
