package com.deas.scraptlyfecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun userLogin() = MutableLiveData<Boolean>().apply {
        value = true
    }

}