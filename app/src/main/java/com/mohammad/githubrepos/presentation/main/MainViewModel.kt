package com.mohammad.githubrepos.presentation.main

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(): ViewModel() {

    enum class BottomNavigation{
        Trending, Settings
    }

    val bottomBarNavigation = NavLiveData()

    fun onCreate() {
        bottomBarNavigation.sendAction(BottomNavigation.Trending.ordinal)
    }

    fun trendingClicked() {
        bottomBarNavigation.sendAction(BottomNavigation.Trending.ordinal)
    }

    fun settingsClicked() {
        bottomBarNavigation.sendAction(BottomNavigation.Settings.ordinal)
    }

    class NavLiveData: LiveData<Int>(){
        @MainThread
        fun sendAction(data: Int) {
            value = data
        }
    }
}