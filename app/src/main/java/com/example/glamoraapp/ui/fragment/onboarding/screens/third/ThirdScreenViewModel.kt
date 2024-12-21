package com.example.glamoraapp.ui.fragment.onboarding.screens.third

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThirdScreenViewModel @Inject constructor() : ViewModel() {

    private val _navigateToRoleSelection = MutableLiveData<Boolean>()
    val navigateToRoleSelection: LiveData<Boolean> get() = _navigateToRoleSelection

    fun onBoardingFinished(context: Context) {
        val sharedPref = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()

        _navigateToRoleSelection.value = true
    }
}