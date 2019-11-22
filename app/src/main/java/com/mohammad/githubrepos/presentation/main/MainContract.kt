package com.mohammad.githubrepos.presentation.main

class MainContract {
    interface View {
        fun initLayout()
        fun showTrending()
        fun showSettings()
    }

    interface Presentor {
        fun onCreate()
        fun trendingClick()
        fun settingsClick()
    }

    interface Interactor
}