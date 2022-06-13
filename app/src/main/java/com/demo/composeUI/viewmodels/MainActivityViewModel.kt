package com.demo.composeUI.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    val messages = MutableLiveData(mutableListOf("Text 0", "Text 1", "Text 2", "Text 3", "Text 4"))
}