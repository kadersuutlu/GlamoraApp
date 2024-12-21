package com.example.glamoraapp.ui.fragment.onboarding

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.glamoraapp.ui.fragment.onboarding.screens.first.FirstScreenFragment
import com.example.glamoraapp.ui.fragment.onboarding.screens.second.SecondScreenFragment
import com.example.glamoraapp.ui.fragment.onboarding.screens.third.ThirdScreenFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewPagerViewModel @Inject constructor() : ViewModel() {

    private val _fragmentList = MutableLiveData<List<Fragment>>()
    val fragmentList: LiveData<List<Fragment>> get() = _fragmentList

    init {
        _fragmentList.value = listOf(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )
    }
}