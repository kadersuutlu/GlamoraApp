package com.example.glamoraapp.ui.fragment.splash

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val sharedPreferences: SharedPreferences) : ViewModel() {

    fun checkOnboardingStatus(): Boolean {
        return sharedPreferences.getBoolean("Finished", false)
    }
}
