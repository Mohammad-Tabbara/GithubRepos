package com.mohammad.githubrepos.presentation.main

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(): ViewModel() {


    val bottomBarNavigation = NavLiveData()

    fun onCreate() {
        bottomBarNavigation.sendAction(0)
    }

    fun trendingClicked() {
        bottomBarNavigation.sendAction(0)
    }

    fun settingsClicked() {
        bottomBarNavigation.sendAction(1)
    }
}

class NavLiveData: LiveData<Int>(){
    @MainThread
    fun sendAction(data: Int) {
        value = data
    }
}